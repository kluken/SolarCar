package solarCar;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.BitSet;

//...Packet handling
public class netPacket {
	
	private static Surveillance Log = new Surveillance( "PACKET" );
	
	//...Packet Flags
	boolean fHeartBeat=false,fSetting=false,fRTR=false,fExtendId=false;
	
	private boolean J_DEBUG = true;
	
	//..Packet fields
	private static long protocalId = 0;// Protocal ID: 0x5472697469756;
	private long bus_id,client_id,protocal;
	private int packet_id;
	private byte flag,data_len;
	
	//...Static packet functions
	private static int badPackets = 0;
	private static long timeLastBadPacket = 0, timeNow =0,duration;
	
	//...Construct class
	public netPacket ( ) {
		///...Empty class
		
	}
	public netPacket ( byte[] raw ){
		//...Initial default values:
		bus_id=0;client_id=0;packet_id=0;flag=0;data_len=0;
		//...Read the header
		decompileHeader ( raw );
	}
	
	public boolean isSet(byte b, int bit) {
	    int index = bit / 8;  // Get the index of the array for the byte with this bit
	    int bitPosition = bit % 8;  // Position of this bit in a byte

	    return (b >> bitPosition & 1) == 1;
	}
	
   public void decompileHeader (byte [] data ) {
		try {
			//....Get Bus ID & Bus Number
			ByteBuffer bb = ByteBuffer.wrap( data );
			bb.order(ByteOrder.BIG_ENDIAN);
			
			/*
			 * 	For the bus/client id, we include the padding when retrieving the infomation.
			 * 	this is helpful as the padding is null (or zero'ed) meaning the data isn't affected.
			 * 	Will need to check in live testing. so far so good.
			 * 
			 * 	do note, that bus id needs to be broken down to get the version number and
			 * 	bus id. Version number is upper 52 bits and bus id low 4. 
			 * */
		
			bus_id		= bb.getLong();
			client_id 	= bb.getLong();
			packet_id 	= bb.getInt();
			flag 		= bb.get();
			data_len 	= bb.get();
			
			/*
			 * 	H – Heartbeat / query response packet Indicates that this datagram
			 *	contains a message from the bridge itself, rather than a bridged CAN
			 *	packet. This will either be a bridge heartbeat packet, or a packet
			 *	containing a response to a query request.
			 *	• S – Settings packet Indicates that this datagram contains a setting for
			 *	the bridge itself, and should not be bridged on to the physical CAN
			 *	network.
			 *	• R – RTR packet Indicates that the data contained in this datagram
			 *	should be sent as an RTR packet on the physical CAN network.
			 *	• E – Extended id packet Indicates that this packet should be sent with
			 *	an extended CAN identifier.
			 * */
			//...Flag extraction
			fHeartBeat=isSet(flag,0);
			fSetting=isSet(flag,1);
			fRTR=isSet(flag,6);
			fExtendId=isSet(flag,7);		
			
			// Packet Debug - LOW LEVEL
			//Log.Log( " BUS: " + bus_id + " Client: " + client_id +  " PACKET: " + getKey()	+ " LEN: " + data_len );						
		
		//
		}catch (BufferUnderflowException Ex) {
			//...Calc
			timeNow = System.currentTimeMillis();
            duration = (timeNow - timeLastBadPacket);
            
			//...Bad packet notifcation!
			if (badPackets < 5  && duration > 1200 ){
				Log.Error ("Bad Packet!! LEN: "+data.length + "\n\tTech: "+Ex.getMessage());
				timeLastBadPacket = System.currentTimeMillis();
				badPackets++;
				
				//...Bad packet flooding
			}else if (duration > 5000 ){
				badPackets = 4;
			}
			return;
		}
	}
   
    netPacket nextPacket() {
    	//...If we got more than we bargined 
    	return null;
    }
	
	public boolean isFlagged() {
		//...Is any are flagged
		return fHeartBeat || fSetting || fRTR || fExtendId;
	}
	
	public static int byteArrayToInt(byte[] b) 
	{
	    return   b[3] & 0xFF |
	            (b[2] & 0xFF) << 8 |
	            (b[1] & 0xFF) << 16 |
	            (b[0] & 0xFF) << 24;
	}
	//...Key of the packet: HEX ID 0x400 EG <--
	public String getKey() {
		return "0x" + Integer.toHexString(packet_id);
	}
	
	public String HexStr ( int i ){ return "0x" + Integer.toHexString(i); }
	public String HexStr ( long i ){ return "0x" + Long.toHexString(i); }	
	
	//....Packet flags
	public boolean flagHeartBeat() 	{return fHeartBeat; }
	public boolean flagSetting() 	{return fSetting; }
	public boolean flagRTR() 		{return fRTR; }
	public boolean flagExndId() 	{return fExtendId; }

	//...Packet type:
	
	/*
	 * 
	 * 	UDP MULTICAST PACKET LAYOUT
	 *  pad1, bus_id, pad2, client_id, packet_id, flags, data_length, data = \
    	bit_array.unpack('bits:8, bits:56, bits:8, bits:56, bits:32, bits:8, bits:8, bits')
    	
    	Read: 
    		- 64 Bits /8 8 Byte - Padding(8) + Bus ID(56)
    		- 64 Bits /8 8 Byte - Padding(8) + Client Id(56)
    		- 32 Bits /8 4 Byte - packet_id
    		-  8 Bits /8 1 Byte - Flags
    		-  8 Bits /8 1 Byte - Data length
    	
    	Packets sent over the bridge are as follows:
    	
    	Padding: 8 Bits  0 - 7 | N/A
    	Buss Id: 56 Bits 8-55 | 
    		Under bus id: first 52 bits encode protocal version being used
    						should read: 0x5472697469756 (HEX)
    						Last 4 Bits (56-52) are bus number:
    		[ 52 - Buss ID ][4 - Bus Num]
    		[ 		56 Bits				]
    		
    	NEXT
    		[
    		[ 8 Bit Padding 		]
    		[ 56 Bit Client Id		]
    		[ 32 Bit ID number		]
    		[ 8 Bit - Flags			]
    		[ 8 Bit - Data Length	]
    		
    	Total: 
    		
    	IMPORTANT:
    		[ 8 BIT FLAG ]
    			1 Bit - H - Heartbeat. From bridge, not CAN. 
    			1 Bit - S - Settings. Settings for the bridge
    			4 Bit Gap    			
    			1 Bit - R - RTR Packet. Data to be sent as RTR on CAN NETwork (SEET TRITIUM MANUAL)
    			1 Bit - E - Extended Id Packet : CAN EXTENDED ID PACKET
    	
	 */
	
}

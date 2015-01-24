package solarCar;

import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.BitSet;

//...Packet handling
public class netPacket {
	
	//...Packet Flags
	boolean fHeartBeat=false,fSetting=false,fRTR=false,fExtendId=false;
	
	private boolean J_DEBUG = true;
	
	//...Packet data
	private BitSet bit_array = null;
	private Buffer data = null;
	
	//..Packet fields
	private int bus_id,client_id,packet_id,flag,data_len;
	
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
	
    private void debugOut ( String str ) {
    	if (J_DEBUG)
    		System.out.println("[PACKET] " + str );
    }
	
	public void decompileHeader (byte [] data ) {
		try {
			//....Get Bus ID & Bus Number 
			byte [] subArray = Arrays.copyOfRange ( data , 1 , 3 );
			ByteBuffer temp = ByteBuffer.wrap( subArray );
			bus_id = temp.getInt();
			
			
		//
		}catch (BufferUnderflowException Ex) {
			//...Calc
			timeNow = System.nanoTime();
            duration = (timeNow - timeLastBadPacket)/1000000;
            
			//...Bad packet notifcation!
			if (badPackets < 5  && duration < 10000 ){
				debugOut ("Bad Packet | BusID ("
										+Integer.toHexString(bus_id)+")");
				timeLastBadPacket = System.nanoTime();
				badPackets++;
				
				//...Bad packet flooding
			}else if (duration > 30000 ){
				badPackets = 4;
			}
			return;
		}
		//...End result:
		debugOut ("Packet: BusID ("
									+Integer.toHexString(bus_id)+") | client_id("
									+Integer.toString(client_id)+") | packet_id("
									+Integer.toString(packet_id)+"");
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
		return Integer.toHexString(client_id);
	}

	/*
	 * 
	 * 	UDP MULTICAST PACKET LAYOUT
	 *  pad1, bus_id, pad2, client_id, packet_id, flags, data_length, data = \
    	bit_array.unpack('bits:8, bits:56, bits:8, bits:56, bits:32, bits:8, bits:8, bits')
    	
    	Read: 
    		- 64 Bits /8 8 Byte - Bus ID
    		- 64 Bits /8 8 Byte - Client Id
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

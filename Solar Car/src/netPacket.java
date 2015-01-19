import java.nio.Buffer;
import java.util.BitSet;

//...Packet handling
public class netPacket {
	private BitSet bit_array = null;
	private Buffer data = null;
	private int bus_id,client_id,packet_id,flag,data_len;
	
	//...Constuct class
	public netPacket ( ) {
		///...Empty class
	}
	public netPacket ( Object raw ){
		//...Read the header
	}
	
	///....Private deconstruct header
	/*
	 *  pad1, bus_id, pad2, client_id, packet_id, flags, data_length, data = \
    	bit_array.unpack('bits:8, bits:56, bits:8, bits:56, bits:32, bits:8, bits:8, bits')
    	
    	pad1 = "
	 */
	
}

package solarCar.Hardware;

import solarCar.Surveillance;
import solarCar.netPacket;

/**
 * 
 * @author *INSERT NAME HERE*
 *
 */
public class MiscData 
{
	//...Logging
	Surveillance Log = new Surveillance ( "MiscData");
	
	//...Can data
	private String MacAddress = "AA:BB:CC:DD:EE:FF";
	private short currentCANBitrate = 0;
	
	//...New packet from network
	public void pushFromNetwork ( netPacket packet ) {
		switch (packet.getKey())
		{
			/*
			 *		//Setup the array to hold the contents of the 
					{"0",
					"canEthernetBridge",
					"16 48",
					"currentCANBitrate",
					"MACAddress"};
					//Store the key and array in the HashMap 
			 */
			//...Misc
			case "0x000":
				
			break;
			default:
				
			break;
		}
	}
}

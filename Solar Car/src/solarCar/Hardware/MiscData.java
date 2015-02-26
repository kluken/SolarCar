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
	
	//...New packet from network
	public void pushFromNetwork ( netPacket packet ) {
		switch (packet.getKey())
		{
		//Setup the array to hold the contents of the 
		/*{"0",
						"canEthernetBridge",
						"16 48",
						"currentCANBitrate",
						"MACAddress"};*/
		case "0x100":
			//canEthernetBridge ( bitrate , address );
			break;
			
		/*	//Setup the array to hold the contents of the 
		{"0",
		"shuntBase", 
		"4 32",
		"tritiumID",
		"serialNumber"};*/
		case "0x000":
			
			break;
		}
	}
}

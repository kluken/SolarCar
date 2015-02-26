package solarCar.Hardware;

import solarCar.netPacket;

/**
 * 
 * @author *INSERT NAME HERE*
 *
 */
public class BatteryPack
{
	
	/*details to store:
	 * - serial number of cell management unit (this will eventually be stored as a name, rather than serial number. Identification purposes only
	 * - Per cell management unit - temperature of PCB
	 * - Per Cell management unit - temperature of Cells 
	 * - Per Cell management unit - voltage of each cell (8 in total) 
	 * - Yay! Thats it!
	 */
	
	public void pushFromNetwork ( netPacket packet ) {
		switch (packet.getKey())
		{
		//Setup the array to hold the contents of the 
		/*					"shuntCMUStatusTempAndVoltage1_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};*/
		case "0x101":
		case "0x102":
			//shuntCMUStatusTempAndVoltage ( key , cell1 , cell2 , cell3 , cell4 );
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
	
	//....shuntCMUStatusTempAndVoltage ( key , cell1 , cell2 , cell3 , cell4 );
	private void shuntCMUStatusTempAndVoltage ( String key , int cell1 , int cell2 , int cell3 , int cell4 ) {
		
	}
}

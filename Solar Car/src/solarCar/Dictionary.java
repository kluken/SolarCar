package solarCar;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Kieran Luken
 * Class to store the map that hold the details of every packet we care about
 */
public class Dictionary 
{//testy test
	private static boolean J_DEBUG = true;
	private Surveillance Log = new Surveillance( "DICTONARY");
	
	/**
	 * Dictionary to store the details of each packet, using the hex id as the key to retrieve from the map
	 */
	public HashMap<String, String[]> data;	
	
	/**
	 * Constructor to generate the map
	 */
	public Dictionary()
	{
		//Initialise the HashMap
		data = new HashMap<>();
		
		//Setup the array to hold the contents of the packet 
		String temp[] = {"0",
						"canEthernetBridge",
						"16 48",
						"currentCANBitrate",
						"MACAddress"};
		//Store the key and array in the HashMap
		data.put("0x000", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"0",
							"shuntBase", 
							"4 32",
							"tritiumID",
							"serialNumber"};
		//Store the key and array in the HashMap
		data.put("0x100", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x101", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x102", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x103", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x104", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x105", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x106", temp);
	
	
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x107", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x108", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x109", temp);
	
	
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage4_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x10a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage4_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x10b", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage4_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x10c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage5_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x10d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage5_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x10e", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage5_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x10f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage6_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x110", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage6_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x111", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage6_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x112", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage7_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x113", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage7_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x114", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage7_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x115", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage8_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x116", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage8_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x117", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage8_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x118", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage9_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x119", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage9_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x11a", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage9_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x11b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage10_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x11c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage10_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x11d", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage10_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x11e", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage11_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x11f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage11_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x120", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage11_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x121", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage12_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x122", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage12_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x123", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage12_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x124", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage13_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x125", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage13_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x126", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage13_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x127", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage14_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x128", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage14_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x129", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage14_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x12a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x12b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x12c", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x12d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x12e", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x12f", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage15_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x130", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage16_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x131", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage16_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x132", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage16_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x133", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage17_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x134", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage17_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x135", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage17_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x136", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage18_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x137", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage18_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x138", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage18_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x139", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage19_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x13a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage19_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x13b", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage19_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x13c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage20_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x13d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage20_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x13e", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage20_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x13f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage21_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x140", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage22_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x141", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage22_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x142", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage23_1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x143", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage23_2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x144", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage23_3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x145", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x146", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x147", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x148", temp);

		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x149", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x14a", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x14b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x14c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x14d", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x14e", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x14f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x150", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x151", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x152", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x153", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x154", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x155", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x156", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x157", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x158", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x159", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x15a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x15b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x15c", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x15d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x15e", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x15f", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x160", temp);
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x161", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x162", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x163", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x164", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x165", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x166", temp);
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x167", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x168", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x169", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x16a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x16b", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x16c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x16d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x16e", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x16f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x170", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x171", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x172", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x173", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x174", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x175", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x176", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x177", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x178", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x179", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x17a", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x17b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x17c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x17d", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x17e", temp);
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x17f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x180", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x181", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x182", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x183", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x184", temp);
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x185", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x186", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x187", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x188", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x189", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x18a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x18b", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x18c", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x18d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x18e", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x18f", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x190", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x191", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x192", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x193", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x194", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x195", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x196", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x197", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x198", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x199", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x19a", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x19b", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x19c", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x19d", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x19e", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x19f", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1a0", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a1", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a2", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1a3", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a4", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a5", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1a6", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a7", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1a8", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1a9", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1aa", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ab", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1ac", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ad", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ae", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1af", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b0", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b1", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1b2", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b3", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b4", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1b5", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b6", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b7", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1b8", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1b9", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ba", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1bb", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1bc", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1bd", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1be", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1bf", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c0", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1c1", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c2", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c3", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1c4", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c5", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c6", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1c7", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c8", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1c9", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1ca", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1cb", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1cc", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1cd", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ce", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1cf", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1d0", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d1", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d2", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1d3", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d4", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d5", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1d6", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d7", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1d8", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1d9", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1da", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1db", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1dc", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1dd", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1de", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1df", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e0", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e1", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1e2", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e3", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e4", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1e5", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e6", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e7", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1e8", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1e9", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ea", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1eb", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ec", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage3", 
							"16 16 16 16",
							"cell4Volt",
							"cell5Volt",
							"cell6Volt",
							"cell7Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ed", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage1", 
							"32 16 16",
							"CMUSerialNumber",
							"PCBTemp",
							"CellTemp"};
		//Store the key and array in the HashMap
		data.put("0x1ee", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntCMUStatusTempAndVoltage2", 
							"16 16 16 16",
							"cell0Volt",
							"cell1Volt",
							"cell2Volt",
							"cell3Volt"};
		//Store the key and array in the HashMap
		data.put("0x1ef", temp);		
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntPackStateOfCharge", 
							"32 32",
							"stateOfChargeAmpHoursConsumed",
							"stateOfChargePercentage"};
		//Store the key and array in the HashMap
		data.put("0x1ef", temp);	
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved1", 
							"32",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1f0", temp);	
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved1", 
							"32",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1f1", temp);	
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved1", 
							"32",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1f2", temp);	
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved1", 
							"32",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1f3", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntPackStateOfCharge", 
							"32 32",
							"stateOfChargeAmpHoursConsumed",
							"stateOfChargePercentage"};
		//Store the key and array in the HashMap
		data.put("0x1f4", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntPackBalanceStateOfCharge", 
							"32 32",
							"balanceStateOfChargeAmpHoursConsumed",
							"balanceStateOfChargePercentage"};
		//Store the key and array in the HashMap
		data.put("0x1f5", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntChargerControlInformation", 
							"16 16 16 16",
							"chargingCellVoltageError",
							"cellTemperatureMargin",
							"dischargingCellVoltageError",
							"totalPackCapacity"};
		//Store the key and array in the HashMap
		data.put("0x1f6", temp);
		
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntPrechargeStatus", 
							"1 1 1 1 1 1 1 1 8 16 16 8 8",
							"errorStatusOfContactor1Driver",
							"errorStatusOfContactor2Driver",
							"outputStatusOfContactor1Driver",
							"outputStatusOfContactor2Driver",
							"12vContactorSupplyVoltageOk",
							"errorStatusOfContactor3",
							"outputStatusOfContactor3Driver",
							"unused",
							"prechargeState",
							"12vContactorSupplyVoltage",
							"unused",
							"prechargedTimerElapsed",
							"prechargedTimerCounter",};
		//Store the key and array in the HashMap
		data.put("0x1f7", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntMinMaxCellVoltage", 
							"16 16 8 8 8 8",
							"minimumCellVoltage",
							"maximumCellVoltage",
							"cmuNumberWithMinVoltage",
							"cmuCellNumberWithMinVoltage",
							"cmuNumberWithMaxVoltage",
							"cmuCellNumberWithMaxVoltage"};
		//Store the key and array in the HashMap
		data.put("0x1f8", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"16 16 8 8 8 8",
							"minimumCellTemp",
							"maximumCellTemp",
							"cmuNumberWithMinTemp",
							"unused",
							"cmuNumberWithMaxTemp",
							"unused"};
		//Store the key and array in the HashMap
		data.put("0x1f9", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntPackVoltageAndCurrent", 
							"32 32",
							"unused",
							"batteryCurrent"};
		//Store the key and array in the HashMap
		data.put("0x1fa", temp);
				
		//Setup the array to hold the contents of the packet 
		/*
		 * 
		 * 
		 * 
		 * 
		 * May need to check these flags - could be backwards!!
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		temp = new String[] {"1",
							"shuntPackStatus", 
							"16 16 1 1 1 1 1 1 1 1 8 16",
							"balanceVoltageTresholdRising",
							"balanceVoltageThresholdFalling",
							"sfCmuCanBusPowerStatus",
							"sfBmuSetupMode",
							"sfVehicleCommunicationsTimeout",
							"sfCmuCommunicationsTimeout",
							"sfMeasurementUntrusted",
							"sfCellOverTemperature",
							"sfCellUnderVoltage",
							"sfCellOverVoltage",
							"bmsCmuCount",
							"bmsBmuFirmwareBuildNumber",
							"cellTemperatureMargin",};
		//Store the key and array in the HashMap
		data.put("0x1fb", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntBatteryPackFanStatus", 
							"16 16 16 16",
							"fan0Speed",
							"fan1Speed",
							"12vCurrentConsumptionOfFansAndContactors",
							"12VCurrentConsumptionOfCmus"};
		//Store the key and array in the HashMap
		data.put("0x1fc", temp);
				
		//Setup the array to hold the contents of the packet 
		/*
		 * 
		 * 
		 * 
		 * 
		 * May need to check these flags - could be backwards!!
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		temp = new String[] {"1",
							"shuntExtendedBatteryPackStatus", 
							"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 16 8 8 16",
							"sfCmuCanBusPowerStatus", //Correct
							"sfBmuSetupMode", //Correct
							"sfVehicleCommunicationsTimeout",
							"sfCmuCommunicationsTimeout",
							"sfMeasurementUntrusted", //Correct
							"sfCellOverTemperature",
							"sfCellUnderVoltage", //Correct
							"sfCellOverVoltage",
							"unused",
							"unused",
							"unused",
							"sfCmuDetectedExtraCell",
							"sfContactorStuckOrNotEngaged",
							"sfCan12vSupplyLowAboutToShutDown",
							"sfSocMeasurementNotValid",
							"sfPackIsolationTestFailure",
							"unused",
							"bmuhardwareVersion",
							"bmuModelId",
							"unused"};
		//Store the key and array in the HashMap
		data.put("0x1fd", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved", 
							"64",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1fe", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved", 
							"64",
							"bin"};
		//Store the key and array in the HashMap
		data.put("0x1ff", temp);
				
		//Setup the array to hold the contents of the packet 
		temp = new String[] {"1",
							"shuntReserved", 
							"64",
							"bin"};				
		//Store the key and array in the HashMap
		data.put("0x1ff", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
				
				//Setup the array to hold the contents of the packet 
				temp = new String[] {"1",
									"shuntChargerControlInformation", 
									"16 16 16 16",
									"chargingCellVoltageError",
									"cellTemperatureMargin",
									"dischargingCellVoltageError",
									"totalPackCapacity"};
				//Store the key and array in the HashMap
				data.put("0x1f6", temp);
		
		
		//...Debugging
		if (J_DEBUG)
		{
			Log.Log ( "Begin log Contents" , Surveillance.LOG_HIDEBUG  );
			Iterator iterator = data.keySet().iterator();  
			while (iterator.hasNext()) 
			{
			   String key = iterator.next().toString();
			   String value = data.get(key)[1];
			   Log.Log( key + " " + value , Surveillance.LOG_HIDEBUG );
			}
			Log.Log ( "End log Contents" , Surveillance.LOG_HIDEBUG );
		}

	}
}

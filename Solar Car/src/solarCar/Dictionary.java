package solarCar;

import java.util.HashMap;

public class Dictionary 
{
	public HashMap<String, String[][]> data;
	
	public Dictionary()
	{
		data = new HashMap<>();
		String temp[][] = {{"canEthernetBridge", "16 48"}, 
							{"currentCANBitrate"},
							{"MACAddress"}};
		data.put("0x000", temp);
		
		temp = new String[][] {{"shuntBase", "4 32"}, 
							{"tritiumID"},
							{"serialNumber"}};
		data.put("0x100", temp);
		
	}
	
}

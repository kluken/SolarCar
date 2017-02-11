package solarCar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Daniel Stratti 18577857.
 * Generic Class to build a Dictionary from a CSV text file
 * Each line of the CSV file describes the structure of each packet.
 *
 */
public class DictionaryCreator {
	//private Scanner readInput;
	private File inputFile;
	public HashMap<String, String[]> data = new HashMap<String, String[]>();
	
	/**
	 * Constructor
	 * @param csvToCreate
	 */
	public DictionaryCreator() throws IOException{
		this.inputFile = "solarTest.txt";
		createHashMap();
	}
	
	/**
	 * Builds Hash map from text file.
	 */
	private void createHashMap() throws IOException {
	  	Scanner readInput = new Scanner(inputFile);
	  	// Read the file while it has another token
		while (readInput.hasNext()) {
			// Get and seperate ID from file
			String id = readInput.next();
			id = id.replaceAll(",", "");
			
			// Get packet structure
			String temp = readInput.nextLine();
			String[] structure = temp.split(",");
			System.out.println("id " + id);
			
			for (int i = 0; i < structure.length; i++) {
				structure[i] = structure[i].trim();
				System.out.print(structure[i] + ", ");
			}
			System.out.print("\n");
			data.put(id, structure);
		}
		// Close the reading file
		readInput.close();
	}
	
	
	/**
	 * Sort Text file Alpha numerically and save to file.
	 * @throws IOException
	 */
	public void sortAndSaveFile() throws IOException {
		// TODO ask if overwirte, or save as new file
		
		ArrayList<String> content = new ArrayList<String>();
		Iterator<String> iterator = data.keySet().iterator(); 
			
		// Cycle through Hash Map
		while (iterator.hasNext()) {
		  // Set key and value string
		  String key = iterator.next().toString();
		  String value = "";
		  
		  for (int i = 0; i < data.get(key).length; i++) {
	   		if (i < data.get(key).length-1) {
	   			value += data.get(key)[i] + ", ";
	   		} else {
	   			value += data.get(key)[i];
	   		}
		  }
		  content.add(key + ", " + value);
		}
		
		Collections.sort(content);
		
		// Create print writer and Iterator 
		PrintWriter outputFile = new PrintWriter(inputFile);
		
		// Cycle through Hash Map
		for (String pStructuer : content) {
	   		outputFile.println(pStructuer);
		}
		outputFile.close();
	}
}

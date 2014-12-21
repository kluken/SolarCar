package solarCar;

import javax.swing.Spring;

public class network {
	/**
	 * Type: Boolean
	 * Info: Flag used to determine TCP or UDP CONNECTION
	 */
	private boolean socketType = false;
	private int mode = 0; // 0 CLOSED | 1 OPEN UDP | 2 OPEN TCP |
	private short port = 4876;
	private String ip = "239.255.60.60";
	
	public int initlise ( ) { 
	

		//...successful creation
		return 0;
	}
	
	public int destroy ( ) {
		//...Clean up the sockets
		
		//...success clean up
		return 0;
	}
	
	public int recieve ( ) {
		int size = 0;
		
		//...Try socket
		
		//...return how much data has been recieved
		return size; 
	}
	
	//....Override
	public boolean OverrideIP ( String newIp ) {
		//...is the string empty?
		if (newIp == null) return false;
		
		//...ADV - Valid IP? AAA.BBB.CCC.DDD
		
		
		ip = newIp;
		return true;		
	}
	
	public boolean OverridePort ( short newPort ) {
		if (newPort<1 || newPort>65400) 
			return false;
		port = newPort;
		//...success
		return true;
	}
} 

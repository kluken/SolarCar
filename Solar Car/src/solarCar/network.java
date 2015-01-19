package solarCar;
import sun.net.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.*;
import java.util.Queue;

import javax.swing.*;

public class network {
	/**
	 * Type: Boolean
	 * Info: Flag used to determine TCP or UDP CONNECTION
	 */
	
	private boolean J_DEBUG = true;
	static private boolean locked = false;
	
	//...Network packet buffer
	private Queue <DatagramPacket> packetQueue = null;
	//...Network timing
	
	
	//...NETWORK VARIABLES
	private byte socketType = 'U'; /// U = UDP | T = TCP
	private int mode = 0; // 0 CLOSED | 1 OPEN UDP | 2 OPEN TCP |
	private short port = 4876;
	private String ip = "239.255.60.60";
	MulticastSocket sock =  null;
	InetAddress address = null;
	
	//...DEBUG STATS?
	private int packetsIn,inboundSize,packetCount; //...Stats for counting
		
	//...DEBUG window
	JFrame netWindow = null;
    JLabel pIn, inSize, pCount;
    
    //...Dictionary
    private Dictionary dic = new Dictionary();
	
	public int initlise ( ) { 	
		
		if (locked) return -1; ///...Already init;
		locked = true;
		debugOut ("INITLISING NETWORK");
		///...Socket Connection
		try {
			if (socketType == 'U' ) {		
				///UDP MULTICAST
				sock = new MulticastSocket(port);
				address = InetAddress.getByName(ip);
				sock.joinGroup(address);	
			}
			
			///...DEBUG?
			if (J_DEBUG) 
				debugInit();
			
			debugOut ("SOCKET CREATION UDP MULTICAST IP:" +ip + ":" + port );
		} catch (IOException e) {
			///Error has occurred. 
			debugOut ("SOCKET EXCEPTION!!");
			e.printStackTrace();	
		}

		//...successful creation
		return 0;
	}
	
	public int destroy ( ) {
		//...Clean up the sockets
		locked = false;
		debugOut ("NETWORK CLEANED UP");
		//...success clean up
		return 0;
	}
	
	//...Set type.
	public boolean NetworkModeTCP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			destroy();
			socketType = 'T';
			ret = initlise( )>=1;			
		}
		debugOut ( "Network mode changed : TCP MODE" );
		return ret;
	}
	
	public boolean NetworkModeUDP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			destroy();
			socketType = 'U';
			ret = initlise( )>=1;			
		}
		debugOut ( "Network mode changed : UDP MODE" );
		return ret;
	}
	
	
	
	public int recieve ( ) {
		int size = 0;
		long startTime = System.nanoTime(),timeNow=0,duration=0;
		timeNow = System.nanoTime();
		try {
		//...Try socket
			while (duration < 100 ) { //...100 Miliseconds / 10 tick rate
				
	            byte[] buf = null;
				DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
	            sock.receive(msgPacket);
	            
	            //...did we recieve data?
	            if ((size+=msgPacket.getLength())<=0) return 0; //..no data.
	            
	            ///....Handle packet system. 	
	            packetQueue.add( msgPacket );
	            
	            ///....Stats track
	            timeNow = System.nanoTime();
	            duration = (timeNow - startTime)/1000000;
	            packetCount++;
	            inboundSize+= msgPacket.getLength();
	            
			}	
        } catch (IOException ex) {
        	//...Input/Output exception; 
        	/*
        	 * 
        	 * 
        	 */

        }

		//...return how much data has been recieved
		return size; 
	}
	
	//....Override
	public boolean OverrideIP ( String newIp ) {
		//...is the string empty?
		if (newIp == null) return false;
		
		//...ADV - Valid IP? AAA.BBB.CCC.DDD
		debugOut ("IP OVERRIDE: " + ip + " to " + newIp );		
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
	
	//...DEBUGGING
	private boolean debugInit ( ) {
		//...No debug no stats
		if (!J_DEBUG) return true;
		
		debugOut ("Creating debug window");
		//1. Create the frame.
		netWindow = new JFrame("SOLAR CAR ");

		//2. Optional: What happens when the frame closes?	
		netWindow.setContentPane( createNetContentPane() );
		netWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		netWindow.setSize(256, 192);
	    

		//5. Show it.
		netWindow.setVisible(true);
		return J_DEBUG;
	}
	
    private JPanel createNetContentPane (){
    	debugOut ("Creating content pane");
        // We create a bottom JPanel to place everything on.
        JPanel netGUI = new JPanel();
        netGUI.setLayout(null);       

        pIn = new JLabel(packetsIn + " Incoming Packets / Second");
        pIn.setLocation(5, 5);
        pIn.setSize(256, 30);       
        pIn.setForeground(Color.blue);
        netGUI.add(pIn);
        
        pCount = new JLabel(packetCount + " Packets Counted");
        pCount.setLocation(5, 35);
        pCount.setSize(256, 30);        
        pCount.setForeground(Color.blue);
        netGUI.add(pCount);
        
        inSize = new JLabel(inboundSize + " Recv bytes / Second");
        inSize.setLocation(5, 65);
        inSize.setSize(256, 30);     
        inSize.setForeground(Color.blue);
        netGUI.add(inSize);
       
        netGUI.setOpaque(true);
        return netGUI;
    }
    
    /**
     * DEBUG UPDATE
     * 	The debug window is updated 
     * 	to the latest network infomation
     *  - Current data rate
     *  - Total data rate (Obsolete later)
     *  - current packet rate
     *  - total packets (Obsolete later )
     *  
     *  @return if success or not
     */
    private boolean debugUpdate ( ) {
    	//...Are we in debug mode
    	if (!J_DEBUG) return true;
    	
    	//...Update info
        pIn.setText(packetsIn + " Incoming Packets / Second");      
        pCount.setText(packetCount + " Packets Counted");       
        inSize.setText(inboundSize + " Recv bytes / Second");
    	
    	return true;    	
    }
    
    private void debugOut ( String str ) {
    	if (J_DEBUG)
    		System.out.println("[NET] " + str );
    }
	
    
    //...network update code
    public int update () {
    	int ret = 0,m=0;
    	String key = "";
    	
    	///....Check first
    	//try {
    		///...Packet
    		recieve();    			
    		//...Pull packets
    		
    		//...Pull data
    		if (dic.data.containsKey(key)){
    			  m =  Integer.parseInt(dic.data.get(key)[1]);
    			  switch (m) {
    			  case 0: //...MISC
    				  	
    				  break;
    			  default:
    				  debugOut("Unknown Motorway for packet!!");
    				  break;
    			  }
    		}else{
    			//..EXCEPTION!
    		}
    		//...Send DATA to class
    		
    	//}
    	
    	return ret;
    }
} 

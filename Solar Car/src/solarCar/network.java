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
	private short port = 4876;
	private String ip = "239.255.60.60";
	MulticastSocket sock =  null;
	InetAddress address = null;
	
	//...DEBUG STATS?
	private int packetsIn,inboundSize,packetCount,
		stat_packetsInSecond,stat_recvSecond; //...Stats for counting
	
	private long time_Now = 0,time_debugLast=0;
		
	//...DEBUG window
	JFrame netWindow = null;
    JLabel pIn, inSize, pCount;
    
    //...Dictionary
    private Dictionary dic = new Dictionary();
	
	public int initlise ( ) { 	
		
		//...setup stats
		stat_packetsInSecond = 0;
		stat_recvSecond = 0;
		
		if (SocketCreate()<0)return -100;
		
		///...DEBUG?
		if (J_DEBUG) 
			debugInit();			

		//...successful creation
		return 0;
	}
	
	private int SocketCreate () {
		if (locked) return -1; ///...Already init;
		locked = true;
		debugOut ("Creating network Socket");
		String sType = "";
		///...Socket Connection
		try {
			if (socketType == 'U' ) {		
				///UDP MULTICAST
				sock = new MulticastSocket(port);
				address = InetAddress.getByName(ip);
				sock.joinGroup(address);	
				sType = "UDP MULTICAST";
			}else{
				sType = "TCP CONNECT";
			}
			
			debugOut (sType + " IP:" +ip + ":" + port );
		} catch (IOException e) {
			///Error has occurred. 
			debugOut ("SOCKET EXCEPTION!!");
			return -1;
		}
		return 1;
	}
	private int SocketDestroy() {
		
		return 1;
	}
	
	public int destroy ( ) {
		//...Clean up the sockets
		locked = false;
		if (J_DEBUG) 
			debugClean();
		
		SocketDestroy();		
		debugOut ("NETWORK CLEANED UP");
		//...success clean up
		return 0;
	}
	
	//...Set type.
	public boolean NetworkModeTCP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			SocketDestroy();
			socketType = 'T';
			ret = SocketCreate( )>=1;			
		}
		debugOut ( "Network mode changed : TCP MODE" );
		return ret;
	}
	
	public boolean NetworkModeUDP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			SocketDestroy();
			socketType = 'U';
			ret = SocketCreate( )>=1;		
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
				
	            byte[] buf = new byte[1024];
				DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
	            sock.receive(msgPacket);
	            
	            //...did we recieve data?
	            if ((size+=msgPacket.getLength())<=0) return 0; //..no data.
	          
	            
	            ///....Handle packet system. 	
	            packetQueue.add( msgPacket );  // <--- ERRROR?    
	            
	            ///....Stats track
	            timeNow = System.nanoTime();
	            duration = (timeNow - startTime)/1000000;
	            packetCount++;packetsIn++;
	            inboundSize+= msgPacket.getLength();         
	            
	            
			}	
        } catch (IOException ex) {
        	//...Input/Output exception; 
        	/*
        	 * 
        	 * 
        	 */
        	debugOut ( "[RECEIVE] IO EXCEPTION");
        	
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
		netWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		netWindow.setSize(256, 192);	    

		//5. Show it.
		netWindow.setVisible(true);
		return J_DEBUG;
	}
	
	private boolean debugClean () {
		//...No debug no stats
		if (!J_DEBUG) return true;
		
		debugOut ("Destroying debug window");
		
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
    	
    	//...Stats    	
    	time_Now = System.nanoTime();
    	long d = (time_Now - time_debugLast ) / 1000000;
    	if (d > 1000) {
    		time_debugLast = System.nanoTime();
    		
    		//....update
    		stat_packetsInSecond = packetsIn;
    		stat_recvSecond = inboundSize;
    		//...reset
    		inboundSize = 0;
    		packetsIn = 0;
    	}
    	
    	//...Update info
        pIn.setText(this.stat_packetsInSecond + " Incoming Packets / Second");      
        pCount.setText(packetCount + " Packets Counted");       
        inSize.setText(this.stat_recvSecond + " Recv bytes / Second");
    	
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
    		
    	//...Debug update
    	debugUpdate();
    	
    	return ret;
    }
} 

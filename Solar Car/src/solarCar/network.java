package solarCar;
import sun.net.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.*;

import javax.swing.*;

public class network {
	/**
	 * Type: Boolean
	 * Info: Flag used to determine TCP or UDP CONNECTION
	 */
	
	private boolean J_DEBUG = true;
	static private boolean locked = false;
	
	//...Network packet buffer
	
	//...Network timing
	
	
	//...NETWORK VARIABLES
	private boolean socketType = false;
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
	
	public int initlise ( ) { 	
		
		if (locked) return -1; ///...Already init;
		locked = true;
		debugOut ("INITLISING NETWORK");
		///...Socket Connection
		try {
			sock = new MulticastSocket(port);
			address = InetAddress.getByName(ip);
			sock.joinGroup(address);	
			
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
	
	public int recieve ( ) {
		int size = 0;
		
		try {
		//...Try socket
			while (true) {
	            byte[] buf = null;
				DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
	            sock.receive(msgPacket);
	            
	            ///....Handle packet system. 	            
	            
			}	
        } catch (IOException ex) {

            ex.printStackTrace();

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
    	int ret = 0;
    	
    	///....Check first
    	try {
    		
    		
    	}
    	
    	return ret;
    }
} 

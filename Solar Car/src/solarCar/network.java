package solarCar;
import sun.net.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

public class network {
	/**
	 * Type: Boolean
	 * Info: Flag used to determine TCP or UDP CONNECTION
	 */
	
	static private boolean locked = false;
	Surveillance Log = new Surveillance( "NETWORK");
	
	//...Network packet buffer
	private Queue <netPacket> packetQueue;
	
	//...Network recieve thread
	Thread netThread = null;	
	
	//...NETWORK VARIABLES
	private byte socketType = 'U'; /// U = UDP | T = TCP
	private short port = 4876;
	private String ip = "239.255.60.60";
	MulticastSocket sock =  null;
	InetAddress address = null;
	private String state = "DISCONNECTED";
	
	//...DEBUG STATS?
	private int packetsIn,inboundSize,packetCount,
		stat_packetsInSecond,stat_recvSecond; //...Stats for counting
	
	private long time_Now = 0,time_debugLast=0,timeLastPacket=0,timeState=0,
			updateExBegin=0,updateExEnd=0,updateExTime=0,
			guiUpdateTlast=0;
		
	//...DEBUG window
	JFrame netWindow = null;
    JLabel pIn, inSize, pCount,pDataQueue;
    
    //...Dictionary
    private Dictionary dic = new Dictionary();
	
	public int initlise ( ) { 	
		
		//...setup stats
		stat_packetsInSecond = 0;
		stat_recvSecond = 0;
		
		packetQueue = new LinkedList<netPacket>();
		
		if (SocketCreate()<0)return -100;
		
		//...Create thread
		netThread = new Thread ( new networkThread () );
		netThread.start();
				
		//...successful creation
		return 0;
	}
	
	private int SocketCreate () {
		if (locked) return -1; ///...Already init;
		locked = true;
		Log.Log ("Creating network Socket");
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
			
			Log.Log (sType + " IP:" +ip + ":" + port );
		} catch (IOException e) {
			///Error has occurred. 
			Log.Log (" Socket create exception!");
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
		
		SocketDestroy();		
		Log.Log ("NETWORK CLEANED UP");
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
		Log.Log ( "Network mode changed : TCP MODE" );
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
		Log.Log ( "Network mode changed : UDP MODE" );
		return ret;
	}
	
	
	private void stateUpdate ( ) {
		//...Connection state check
		long timeNow = System.currentTimeMillis();
	    timeState = (timeNow - timeLastPacket);
        
        //...work out state
        if (timeState < 2000 ){
        	state = "CONNECTED";
        }else if ( timeState > 2000 && timeState < 5000 ){
        	state = "GHOSTING";
        }else if ( timeState > 5000 ) {
        	state = "DISCONNECTED";
        }
    }
	
	private class networkThread implements Runnable {
		public synchronized void run() {
			Log.Log("Thread online");
			
			int size = 0;
			long startTime = System.currentTimeMillis(),timeNow=0,duration=0;
			timeNow = System.currentTimeMillis();
			try {
			//...Try socket
				while (true ) { //...10 Miliseconds / 1000 / 10 = 100 tick rate
					
					//...State check
					
		            byte[] buf = new byte[1024];
					DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
		            sock.receive(msgPacket);
		            
		            //...did we recieve data?
		            if ((size+=msgPacket.getLength())>0)
		            {
		                timeLastPacket = System.currentTimeMillis();	            
			            netPacket newPacket = new netPacket( msgPacket.getData() );
			            
			            ///....Handle packet system. 	
			            packetQueue.add( newPacket );  // <--- ERRROR?    
			            
			            
			            ///....Stats track
			            timeNow = System.currentTimeMillis();
			            duration = (timeNow - startTime);
			            packetCount++;packetsIn++;
			            inboundSize+= msgPacket.getLength();
		            }
				}	
	        } catch (IOException ex) {
	        	//...Input/Output exception; 
	        	Log.Log ( "[RECEIVE THREAD] IO EXCEPTION");	        	
	        }

			//...return how much data has been recieved			
			Log.Log ( "Thread Offline" );
        }
	}
	
	//....Override
	public boolean OverrideIP ( String newIp ) {
		//...is the string empty?
		if (newIp == null) return false;
		
		//...ADV - Valid IP? AAA.BBB.CCC.DDD
		Log.Log ("IP OVERRIDE: " + ip + " to " + newIp );		
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
    private void statsUpdate ( ) {
    	    	
    	//...Stats    	
    	time_Now = System.currentTimeMillis();
    	long d = (time_Now - time_debugLast );
    	if (d > 500) {
    		time_debugLast = System.currentTimeMillis();
    		
    		//....update
    		stat_packetsInSecond = packetsIn;
    		stat_recvSecond = inboundSize;
    		
    		//...reset
    		inboundSize = 0;
    		packetsIn = 0;
    	} 	
    }

    
    //...Interface can call this 
    protected synchronized void netGuiUpdate ( final Interface interfaceThread ){
    	//...Update network related infomation:
    	long t = System.currentTimeMillis(),d=0;
    	d = (t - guiUpdateTlast );
    	if ( d > 30 )
    	{
	    	interfaceThread.display.getDefault().asyncExec(new Runnable() 
	    	{
	    		 public void run() {
	    			//...PER SECOND
	    		    	interfaceThread.txtNetDataRecv.setText( stat_recvSecond + " bytes" );
	    		    	interfaceThread.txtNetPacketsSecond.setText( stat_packetsInSecond + "");
	    		    	interfaceThread.txtNetConnectionState.setText( state );
	    		    	
	    		    	//...TOTAL
	    		    	interfaceThread.txtNetTotalPackets.setText ( packetsIn + "");
	    		    	interfaceThread.txtNetLoad.setText (updateExTime + "ms");
	    		 }
	    	});
	    	
	    	guiUpdateTlast = System.currentTimeMillis();
    	}
    }
	
    
    //...network update code
    public int update () {
    	updateExBegin = System.currentTimeMillis(); //update load execution counter
    	
    	//...Function setup
    	int ret = 0,m=0;
    	String key = "";
    	netPacket packet = null;
    	stateUpdate();
    	///....Check first
    	//try {			
    		//...Pull packets
    		while (!packetQueue.isEmpty()){
    			packet = packetQueue.poll();
    			key = packet.getKey ();
	    		//...Pull data
	    		if (dic.data.containsKey(key)){
	    			  m =  Integer.parseInt(dic.data.get(key)[1]);
	    			  switch (m) {
	    			  //.. 0x000 - 0x999
	    			  case 0: //...MISC
	    				  break;
	    			
	    			  case 1:	    				  
	    				  break;
	    				  
	    			  case 2:
	    				  break;
	    				  
	    			  case 3:	    				  
	    				  break;
	    				  
	    			  default:
	    				  Log.Log("Unknown Motorway for packet!!");
	    				  break;
	    			  }
	    		}else{
	    			//..EXCEPTION!
	    		}
    		}
    		
    	//}
    		
    	// update
    	stateUpdate();	//...Update connection state
    	statsUpdate();	//...Update stats for the GUI
    	
    	updateExEnd = System.currentTimeMillis(); //update load execution counter
    	updateExTime =( updateExEnd - updateExBegin );
    	return ret;
    }
} 

package solarCar;
import solarCar.common.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.swt.widgets.Display;





/**
 * 
 * @author Matt Richardson
 * 
 * @version 0.0.1
 * 
 * @info : Advance network;
 * 		Purpose of this class is to simplfy, while increase effectiveness of the network.
 * 		Network layer handers OSI Models layer 3 and 4. (TCP AND UDP) - technically TCP includes layer 5/6 (Session and presentation)
 * 
 * 		The network module supports three protocals
 * 		- UDP (Solar car CAN wireless bridge)
 * 		- TCP (Solar car CAN wireless bridge AND TCP SOCKS/TCP Tunnel/TCP Relay)
 * 
 * 		- RDPI (Relay Data Rasberry Pi, Custom protocal used. Designed for later version)
 * 			-	RDPI is maintained https://github.com/Mazzaa/SolAcePi
 * 
 * 			- Aims: 
 * 				Server <--> Client model;
 * 					TCP Client Server (Default listen: 44080)
 * 					UDP Discovery 	  (Deafult discovery: 44081)
 * 				- Fail over
 * 					- Multi Pi's running the same software can handle overflow of clients or take over as C&C 
 * 						incase where the main server crashes. ( Eg: Unexpected crash (2 Second recovery) )
 * 				- Backup Syn
 * 					- Records Solar car telemetry to local or offsite database
 * 				
 *
 */

public class advNetwork {
	
	//....Class variables	
	static private boolean locked = false;
	Surveillance Log = new Surveillance( "NETWORK" );
	
	//...Network packet buffer
	private Queue <netPacket> packetQueue;
	
	//...Network recieve thread
	Thread netThread = null;	
	
	//...NETWORK VARIABLES
	private short 	port = 4876;
	private String 	ip = "239.255.60.60";
	private String 	state = "DISCONNECTED";
	private char 	socketType = netSocket.SOCK_UDP_MULTICAST;
	
	//...Network socket 
	private netSocket sock;
	
	/*	Network statistics to watch:
	 * 	- Packet rate			- Data rate
	 * 	- Connection state		- Packet count
	 * 	- total usage
	 * 
	 * */
	//...Network statistics
	private double stat_PacketCount,stat_DataCount,stat_ThreadLoad;
	private statTrack stat_PacketRate = new statTrack(),stat_DataRate = new statTrack();
		
	//...Timer
	private advTimer  netTimer;	
	private advTimer  netThreadTimer;
	
    //...Dictionary
    private Dictionary dic = new Dictionary();
	
	private void statsReset ( ) {
		stat_PacketRate.clear();
		stat_DataRate.clear();
		stat_PacketCount=0;
		stat_DataCount=0;
		stat_ThreadLoad=0;
	}
	
	/**
	 * @return returns 1 if success, else negative error code
	 */
	public int initlise ( ) { 	
		int ret=0;
		statsReset();
		//...Create timers.
		netTimer =  new advTimer ();
		netThreadTimer = new advTimer();
		
		//...Create packet queue ( FIFO ) IN->OUT->
		packetQueue = new LinkedList<netPacket>();
		
		//..Create socket ( of type )
		sock = new netSocket ( socketType );
		ret = sock.connect( ip ,  port );
		assert ( ret > 0 );
		
		//...Create thread
		netThread = new Thread ( new advNetThread () );
		netThread.start();
		
		//...successful creation
		return 1;
	}
	
	/**
	 * @return returns if socket could be created
	 * 
	 * @info Create the socket accordingly.
	 * 		Generic sock creations based on socket type
	 * 
	 * */

	
	public int destroy ( ) {
		//...Clean up the sockets
		locked = false;
		sock.close(true);	
		Log.Log ("Network Destroyed" , Surveillance.LOG_INFO );
		//...success clean up
		return 0;
	}
	
	/*#######################
	 * 	Network thread
	 *#######################
	 * */
	
	private class advNetThread implements Runnable {
		public synchronized void run() {
			Log.Log("[THREAD] online" , Surveillance.LOG_ENTRY );			
			boolean run = true;
			netPacket packet = null;
			double delta = 0,t;
			
			byte[] data = new byte[netSocket.MAX_BUFFER];
			int len=0; 
			
			//...Thread performance
			long n,l;

			//...infinitive loop. Exits up error or interrupt
			while ( run ) {
				n = System.nanoTime();
				//...Check for data??
				len = sock.recv(data, len);
				if ( len > 0 ) {
					//...Packet it
					packet = new netPacket( data );
		            
		            ///....Handle packet system. 	
		            packetQueue.add( packet );  // <--- ERRROR?  
					
					//...statistical
					stat_DataRate.addMark(len);					stat_DataCount += len;
					stat_PacketRate.addMark();						stat_PacketCount++;
					packet = null; data[0]='\n';
				
				}
				else{
					//...No data. do something productive.
				}
							
				l = (long) netThreadTimer.timeNow();
				delta = (double)(l - n);
				stat_ThreadLoad = util.roundEx(netThreadTimer.nanoToMili( delta ),2);
			}
			
			//...return how much data has been received			
			Log.Log ( "[THREAD] Offline"  , Surveillance.LOG_ENTRY );
        }
	}
	
    //...Interface can call this 
    protected synchronized void netGuiUpdate ( final Interface interfaceThread ){
    	//...Update network related information:
    	
    	Display.getDefault().asyncExec(new Runnable() 
    	{
    		 public void run() {
    			//...PER SECOND
    		    	interfaceThread.txtNetDataRecv.setText( stat_DataRate.getRateV() + " bytes" );
    		    	interfaceThread.txtNetPacketsSecond.setText( stat_PacketRate.getRate() + "");
    		    	interfaceThread.txtNetConnectionState.setText( state );
    		    	
    		    	//...TOTAL
    		    	interfaceThread.txtNetTotalPackets.setText ( stat_PacketCount + "");
    		    	interfaceThread.txtNetLoad.setText ( stat_ThreadLoad + "ms");
    		 }
    	});
   
    }
    
    private double _guiResetTime;
    private void guiResetStats ( ){
    		//...Reset stat
    		stat_DataRate.update();
    		stat_PacketRate.update();    	
    }
    
    public int update () {
    	//...Function setup
    	int ret = 0,m=0;
    	String key = "";
    	netPacket packet = null;
    	    	
    	///....Check first
    	try {			
    		//...Pull packets
    		while (!packetQueue.isEmpty()){
    			packet = packetQueue.poll();
    			key = packet.getKey ();
	    		//...Pull data
	    		if (dic.data.containsKey(key)){
	    			  m =  Integer.parseInt(dic.data.get(key)[1]);
	    			  switch (m) {
	    			  //.. 0x000 - 0x999
	    			  case 0:	
	    			  		Main.pMisc.pushFromNetwork( packet );
	    			  		break;
	    			  case 1: 	
	    				  	Main.pBatteryPack.pushFromNetwork( packet );
	    				  	break;
	    			  case 2: 	
	    				  
	    				  break;
	    			  case 3: 
	    				  
	    				  break;
	    			 default:   Log.Log("");  break;
	    			  }
	    		}else{
	    			//...Unknown key for dictonary
	    			//Log.Log("Unknow packet: "+ key , Surveillance.LOG_WARNING );
	    			
	    		}
    		}
    		
    	}catch ( NullPointerException ex) {
    		ex.getStackTrace();
    	}
    		
    	// Update network GUI and stats
    

    	return ret;
    }
    
	
	/*#################
	 * 	NETWORK TOOLS
	 * ################
	 */
	
	//...Set type.
	public boolean NetworkModeTCP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			sock.close(true);
			sock.setType ( netSocket.SOCK_TCP );
			sock.connect(ip,port);
		}
		Log.Log ( "Network mode changed : TCP MODE" , Surveillance.LOG_INFO);
		return ret;
	}
	
	public boolean NetworkModeUDP () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			sock.close(true);
			sock.setType ( netSocket.SOCK_UDP_MULTICAST );
			sock.connect(ip,port);
		}
		Log.Log ( "Network mode changed : UDP MODE" , Surveillance.LOG_INFO);
		return ret;
	}
	
	public boolean NetworkModeRPI () {
		boolean ret = false;
		//...if network active, deactivate
		if (locked) {
			if (locked) {
				sock.close(true);
				sock.setType ( netSocket.SOCK_UDP_MULTICAST );
				sock.connect(ip,port);
				
				//...Call RPI API here
				//rpi.Connect ( sock );
				//rpi.SetMode ( rpi.Relay ); 
			}
		}
		Log.Log ( "Network mode changed : RDPI MODE" , Surveillance.LOG_INFO);
		return ret;
	}

	//....Override
	public boolean OverrideIP ( String newIp ) {
		//...is the string empty?
		if (newIp == null) return false;
		if (newIp == ip)return false;
		
		//...ADV - Valid IP? AAA.BBB.CCC.DDD
		Log.Log ("IP OVERRIDE: " + ip + " to " + newIp );		
		ip = newIp;
		return true;		
	}
	
	public boolean OverridePort ( String newPort ) {		
		return OverridePort (Short.parseShort(newPort));
	}
	public boolean OverridePort ( short newPort ) {
		if (newPort<1 || newPort>65400) 
			return false;
		port = newPort;
		//...success
		return true;
	}
	
    //...Get functions
	public String getIpAddr() 		{return ip;	}
	public String getPort() 		{return "" + port;	}
	public String getNetworkType() 	{return "" + socketType;	}

}

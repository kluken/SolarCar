package solarCar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;


/**
 * 
 * @author Matt Richardson
 *
 * @info : Named network sockets because of Java class Socket already exits.
 * 		Purpose of this class is to simplify socket creation for TCP and UDP connection.
 * 
 */
public class netSocket {
	
	private Surveillance Log = new Surveillance("SOCKET");
	
	/** SOCK_UDP - Socket type udp */
	protected static final char SOCK_UDP =  'U';			//...UDP CONNECTIONLESS
	protected static final char SOCK_UDP_MULTICAST = 'M';	//...UDP MULTICAST ADDRESS
	protected static final char SOCK_TCP =  'T';			//...TCP CONNECT
	protected static final char SOCK_TCP_LISTEN = 'L';		//...TCP LISTEN SOCK ( NOT SUPPORTED )
	protected static final char SOCK_NULL		= 'N';		//...Neutal state

	public static final int MAX_BUFFER = 1024;
	
	//...Private socket
	private char socketType;
	private String sockIp;
	private short sockPort;
	
	//...Network sockets
	//	UDP SOCKET
	DatagramSocket sockUdp;
	MulticastSocket sockUdpMC;
	InetAddress address;
	
	// TCP SOCKET
	Socket sockTcpClient;
	ServerSocket sockTcpServer;
	
	
	//#################################################################################################
	/**
	 * 
	 * @param type - if not supplied default sock TCP is created 
	 */
	netSocket ( Socket accept ){
		//...Accepted a socket
	}
	netSocket ( char type ) {
		socketType = type;
	}
	
	netSocket ( ) {
		//..Default socket is tcp
		socketType = SOCK_NULL;
	}
	
	/**
	 * 
	 * @param ipaddr -  Ip Address to connect to.
	 * @param portnum -  Port number to connect to 
	 * @return returns is success (1) else error -X <- Error code
	 * @throws  
	 */
	public int connect ( String ipaddr , short portnum ) {
		//...variables
		int ret = 0;
		
		//...Check sock state:
		if ( socketType == SOCK_NULL ) {
			Log.Log("[CONNECT] Socket is of unknown type!!!", Surveillance.LOG_WARNING );
			return -SOCK_NULL;
		}
		try {
			//...Socket create
			switch ( socketType ){
				case SOCK_UDP:
					//...If IP and port are provided. Send will use the multicast
					sockUdp = new DatagramSocket ( portnum );
	
				break;
				
				case SOCK_UDP_MULTICAST:
					sockUdpMC = new MulticastSocket( portnum ); // Multi-cast socket
					address = InetAddress.getByName( ipaddr );	// Get multicast address
					sockUdpMC.joinGroup(address);				// Connect to multicast
					
				break;
				
				case SOCK_TCP:
					
				break;
				
				case SOCK_TCP_LISTEN:
					sockTcpServer = new ServerSocket( portnum );
				break;
				
				default:					Log.Log("Unkown Sock type", Surveillance.LOG_WARNING);				break;
			}
		} catch (SocketException e) {
			//...Didnt work.
			Log.Log("[CONNECT] Socket exception, ex: "+e.getMessage() , Surveillance.LOG_ERROR );
			ret = -1;
		} catch (IOException e) {
			Log.Log("[CONNECT] Socket IO exception, ex: "+e.getMessage() , Surveillance.LOG_ERROR );
			ret = -2;
		}
		
		//...Assign socket ip and port
		sockIp = ipaddr;
		sockPort = portnum;
		
		//if ( ret<1)Log.Log(level)
		
		return ret;
	}
	
	/**
	 * 
	 * @param force - force connection close, doesn't wait for close
	 * @return returns code success(1) else negative for error.
	 */
	public int close ( boolean force ) {
		//...variables
		int ret = 0;
		
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:
				
			break;
			case SOCK_UDP_MULTICAST:
				
			break;
			case SOCK_TCP:
				
			break;
			case SOCK_TCP_LISTEN:
				
				
			break;
			case SOCK_NULL: 			Log.Log("[DISCONNECT] Socket is Null", Surveillance.LOG_WARNING);				break;		
			default:					Log.Log("[DISCONNECT] Unkown Sock type", Surveillance.LOG_WARNING);							break;
		}

		
		//if ( ret<1)Log.Log(level)
		
		return ret;
	}
	
	//...TCP Accept
	public netSocket accept( ){
		int ret=0; // -X error +X size
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:				Log.Log("[ACCEPT] Socket is UDP!!", Surveillance.LOG_WARNING);				break;
			case SOCK_UDP_MULTICAST:	Log.Log("[ACCEPT] Socket is UDP MULTICAST!!", Surveillance.LOG_WARNING);		break;
			case SOCK_TCP:				Log.Log("[ACCEPT] Socket is TCP CONNECT!!", Surveillance.LOG_WARNING);		break;
			case SOCK_TCP_LISTEN:
				//...Accept tcp connection
				
			break;
			
			default:					Log.Log("Unkown Sock type", Surveillance.LOG_WARNING);				break;
		}
		return null;
	}
	
	//...SEND
	public int listen ( byte[] data , int len , char ip , short port ){
		int ret=0; // -X error +X size
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:
				
			break;
			case SOCK_UDP_MULTICAST:
				
			break;
			case SOCK_TCP:
				
			break;
			case SOCK_TCP_LISTEN:
				
			break;
			
			default:					Log.Log("Unkown Sock type", Surveillance.LOG_WARNING);				break;
		}
		return ret;
	}
	
	
	//...SEND
	public int send ( byte[] data , int len , char ip , short port ){
		int ret=0; // -X error +X size
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:
				
			break;
			case SOCK_UDP_MULTICAST:
				
			break;
			case SOCK_TCP:
				
			break;
			case SOCK_TCP_LISTEN:
				
			break;
			
			default:					Log.Log("Unkown Sock type", Surveillance.LOG_WARNING);				break;
		}
		return ret;
	}
	public int send ( byte[] data , int len ){
		int ret=0; // -X error +X size
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:
				
			break;
			case SOCK_UDP_MULTICAST:
				
			break;
			case SOCK_TCP:
				
			break;
			case SOCK_TCP_LISTEN:
				Log.Log("[SEND] Socket is TCP Listen!!!", Surveillance.LOG_WARNING);
			break;
			
			default:					Log.Log("[SEND] Unkown Sock type", Surveillance.LOG_WARNING);				break;
		}
		return ret;
	}
	
	//...RECV
	public int recv ( byte[] data , int len ){
		int ret=0; // -X error +X size
		DatagramPacket rp = null;
		
		//...Socket create
		try {
			switch ( socketType ){
				//....UDP Recv
				case SOCK_UDP:	
					//...Udp
		            rp = new DatagramPacket(data, data.length);
					sockUdp.receive(rp);
					len = ret = rp.getLength();
					System.arraycopy(rp.getData(), 0, data, 0, len);
					
				case SOCK_UDP_MULTICAST:
					//...Udp
		            rp = new DatagramPacket(data, data.length);
					sockUdpMC.receive(rp);
					len = ret = rp.getLength();
					System.arraycopy(rp.getData(), 0, data, 0, len);
					
				break;	
				
				case SOCK_TCP:
					ret = -1;
					Log.Log("[RECV] Function not supported!", Surveillance.LOG_WARNING);	
				break;
				case SOCK_TCP_LISTEN:
					Log.Log("[RECV] Socket is TCP Listen!!!", Surveillance.LOG_WARNING);
				break;
				
				default:					Log.Log("Unkown Sock type", Surveillance.LOG_WARNING);				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ret = -1;
			Log.Log("[RECV] Sock IO Exception! : "+ e.getMessage() , Surveillance.LOG_WARNING);	
		} catch ( NullPointerException e ){
			ret = -2;
			Log.Log( "NullPointer Exception! : ", Surveillance.LOG_SEVERE );
			e.printStackTrace();
			Log.Log( " CRITICAL EXCEPTION! ");
			System.exit(-1);
		}
		return ret;
	}
		
	//...Set socket type
	public boolean setType ( char type ) {
		//...Check we are operational
		if ( socketType != SOCK_NULL ){
			Log.Log("[TYPE CHANGE] close socket before changing!!", Surveillance.LOG_WARNING );
			return false;
		}
		
		//...We are good
		socketType = type;
		return true;
	}
	
	//...Is Tools
	public boolean isTCP ( ) {
		return (socketType == SOCK_TCP || socketType == SOCK_TCP_LISTEN );
	}
	public boolean isUDP ( ) {
		return (socketType == SOCK_UDP || socketType == SOCK_UDP_MULTICAST );
	}
	
	//...Is connected
	public boolean isConnected ( ) {
		boolean ret=false; // -X error +X size
		//...Socket create
		switch ( socketType ){
			case SOCK_UDP:
				ret = true;
				Log.Log("[IS_CONNECTED] Socket is UDP Connectionless!!!", Surveillance.LOG_WARNING);
			break;
			case SOCK_UDP_MULTICAST:
				ret = sockUdp.isConnected();
			break;
			case SOCK_TCP:
				ret = sockTcpClient.isConnected();
			break;
			case SOCK_TCP_LISTEN:
				Log.Log("[IS_CONNECTED] Socket is TCP Listen!!!", Surveillance.LOG_WARNING);
			break;
			
			default:					Log.Log("[IS_CONNECTED] Unkown Sock type", Surveillance.LOG_WARNING);				break;
		}
		return ret;
	}
	

}

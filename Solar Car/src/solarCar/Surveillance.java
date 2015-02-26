package solarCar;

/*
 * Application monitoring
 * 
 * The purpose of this class is to log information of the application 
 *	which can be used for debugging or logging the execution of tasks.
 *	
 *	This is strictly in-house. Infomation obtained from the application is used
 *	by the IT crew for debug, bug or error handling.
 *		This application will require
 *		- Non-critical/critical call monitoring
 *		- Thread watching
 *		- Critical crash data dump
 *		- Events logging
 *		- Log email
 *		- update patching
 *
 * */

public class Surveillance {
	
	private static boolean J_DEBUG = true;
	private String owner = "";

	
	//...Debug Level
	/**
	 * Log Level Debugging
	 * 	LOG_SEVERE, severe errors that require program exit (e.g., in an application, you ran out of disk space).
	 *	LOG_ERROR, error messages that can't be recovered from but the program can continue to run (e.g., in a server application, client sent through bad data but other clients can continue to run).
	 *	LOG_WARNING, recoverable problem that you should be notified about (e.g., invalid value in a configuration file, so you fell back to the default).
	 *	LOG_INFO, informational messages.
	 *	LOG_ENTRY, log entry and exit to all functions.
	 *	LOG_PARM, log entry and exit to all functions with parameters passed and values returned (including global effects if any).
	 *	LOG_DEBUG, general debugging messages, basically useful information that can be output on a single line.
	 *	LOG_HIDEBUG, far more detailed debugging messages such as hex dumps of buffers.
	 * */
	public static final int LOG_SEVERE = 1;
	public static final int LOG_ERROR = 2;
	public static final int LOG_WARNING = 3;
	public static final int LOG_INFO = 4;
	public static final int LOG_ENTRY = 5;
	public static final int LOG_PARM = 6;
	public static final int LOG_DEBUG = 7;
	public static final int LOG_HIDEBUG = 8;
	
	private static int setLogLevel = LOG_DEBUG;
	
	//...Surveillance
	public Surveillance () {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		owner = stackTraceElements[1].getClassName();
	}
	
	public Surveillance (String myowner) {
		owner = myowner;
		register ( owner );		
	}
	
	private void register ( String myowner ) {
		//...Begin
		debugOut ( "Registed Logger" );
		
		//...Check for state:
		if (!J_DEBUG) {
			//...If File not open
			
			//...If file open then good
			
		}
	}
	
	///...Get the the log level type of string
	/*	Info: Get the Log Level of the application
	 *  
	 *  @Return: Type<String> RET: Type of log level: "LOG LEVEL" 
	 * */
	public String getLogLevelStr() {
		String ret="";
		switch (setLogLevel ){
			case LOG_SEVERE:	ret = "SERVE";						break;
			case LOG_ERROR:		ret = "ERROR";						break;
			case LOG_WARNING:	ret = "WARNING";					break;
			case LOG_INFO:		ret = "INFO";						break;
			case LOG_ENTRY:		ret = "ENTRY";						break;
			case LOG_PARM :		ret = "PARAMTERS";					break;
			case LOG_DEBUG :	ret = "DEBUG";						break;
			case LOG_HIDEBUG : 	ret = "HL DEBUG";					break;
			default: ret = "UNKNOWN"; break;
		}
		return ret;
	}
	
	public int getLogLevelInt() {
		return setLogLevel;
	}
		
	public boolean setTheLogLevel ( int level ) {
		//...Check bound
		if ( level < LOG_SEVERE || level > LOG_HIDEBUG ) {
			Log ("Level (" + level + ") not valid" , LOG_INFO );
			return false;
		}
		setLogLevel = level;
		Log ( "Log level changed to " + getLogLevelStr () , LOG_INFO );
		return true;
	}
	
	private void handleLog ( String str ){
    	if (J_DEBUG)
    		System.out.println( str );
    	else 
    		LoggIt ( str );
	}
	
	//...Debug log level
    public void debugOut ( String str , int log_level ) {
    	//...Check log level
    	if ( log_level > setLogLevel ) return;    	
    	
    	//...Logging
    	String line = "["+ owner +"]["+getLogLevelStr() +"] " + str ;
    	handleLog ( line );
    }
	//...Debug log level
    public void debugOut ( Object obj , int log_level ) {
    	//...Check log level
    	if ( log_level > setLogLevel ) return;    	
    	
    	//...Logging
    	String line = "["+ owner +"]["+getLogLevelStr() +"] OBJECT: " + obj ;
    	handleLog ( line );
    }
	
	
	//...Debugging
    public void debugOut ( String str ) {
    	debugOut ( str , this.LOG_DEBUG );
    }
    
    public void debugOut ( Object obj ) {
    	String line = "["+ owner +"] OBJECT: " + obj ;
    	handleLog ( line );
    }
    
    //....Basic Debugging
    public void Log ( String str ) {
    	debugOut ( str );
    }
    public void Log ( Object obj ) {
    	debugOut ( obj );
    }
    
    //...Specific debugging
    public void Log ( String str , int level ) {    	debugOut ( str , level );    }
    public void Log ( Object obj , int level ) {    	debugOut ( obj , level );    }
    
    
    private void LoggIt ( String line ) {
    	//...Debug check:
    	if (J_DEBUG)return;
    	
    	//...Check file:
    	if (!true)return;
    	
    	//...Write
    	
    }

	public void Error(String str) {
		// TODO Auto-generated method stub
		String line = "[ERROR: "+ owner +"] " + str ;
    	if (J_DEBUG)
    		System.out.println( line );
    	else 
    		LoggIt ( line );
	}
}

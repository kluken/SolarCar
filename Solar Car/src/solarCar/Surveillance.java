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
	
	//...Debugging
    public void debugOut ( String str ) {
    	String line = "["+ owner +"] " + str ;
    	if (J_DEBUG)
    		System.out.println( line );
    	else 
    		LoggIt ( line );
    }
    public void Log ( String str ) {
    	debugOut ( str );
    }
    
    private void LoggIt ( String line ) {
    	//...Debug check:
    	if (J_DEBUG)return;
    	
    	//...Check file:
    	if (!true)return;
    	
    	//...Write
    	
    }
}

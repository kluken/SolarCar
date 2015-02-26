package solarCar;

public class Main
{
	//...GENSIS
	protected static Interface window = null;	
	protected static network net = null;
	protected static Settings options = null;
	private static Surveillance Log = new Surveillance("MAIN");
	protected static LogOutput LogOut = null;
	
	public static void main(String[] args)
	{
		//...GENSIS
		Log.Log ("Initlization" , Log.LOG_ENTRY );
		window = new Interface();		
		net = new network();
		options = new Settings();
		LogOut =  new LogOutput();
		
		options.settingsLoad();
		window.initilise();
		net.initlise(); ///...Initlise network side:
		
		///...MAIN SECTION
		run();
		
		///...REVERLATIONS
		Log.Log ("Destroying" , Log.LOG_ENTRY );
		net.destroy();
		window.destroy();
		options.settingsSave();
		
		Log.Log (" Good Byte :)" , Log.LOG_ENTRY );
		System.exit(0);
		//...Successful end ...//
	}
	
	public static void run () {
		//#########	
		Log.Log ("Entry core run function");
		boolean exit = false;
		while (!exit ) {
			//...Check main window for close?
			if (net.update() < 0 )exit =true;	
			if (!window.update())exit =true;
			
			//...Call GUI UPDATES
			net.netGuiUpdate ( window );
		}
		Log.Log ("Exit core run function" , Log.LOG_ENTRY );
	}
	
	//...Application load
    protected synchronized void mainGuiUpdate ( ){
    	//...Update network related infomation:
    	window.display.getDefault().asyncExec(new Runnable() 
    	{
    		 public void run() {
    			//...CPU AND RAM USSAGE
    			
    		 }
    	});
    }

}

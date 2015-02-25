package solarCar;

public class Main
{
	//...GENSIS
	protected static Interface window = null;	
	protected static network net = null;
	protected static Settings options = null;
	private static Surveillance Log = new Surveillance("MAIN");
	
	public static void main(String[] args)
	{
		//...GENSIS
		Log.Log ("Calling Initlization functions");
		window = new Interface();		
		net = new network();
		options = new Settings();
		
		window.initilise();
		net.initlise(); ///...Initlise network side:
		
		///...MAIN SECTION
		run();
		
		///...REVERLATIONS
		Log.Log ("Calling destroy functions");
		net.destroy();
		window.destroy();
		Log.Log (" Good Byte :)");
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
		Log.Log ("Exit core run function");
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

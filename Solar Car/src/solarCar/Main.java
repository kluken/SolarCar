package solarCar;

public class Main
{
	//...GENSIS
	private static TestGui window = null;	
	private static network net = null;
	
	public static void main(String[] args)
	{
		
		//...GENSIS
		window = new TestGui();		
		net = new network();
		
		net.initlise(); ///...Initlise network side:
		
		///...MAIN SECTION
		run();
		
		///...REVERLATIONS
		net.destroy();
		System.exit(0);
		//...Successful end ...//
	}
	
	public static void run () {
		//#########
		boolean exit = false;
		while (!exit ) {
			//...Check main window for close?
			if (!window.isOnline())exit=true;
		}
	}

}

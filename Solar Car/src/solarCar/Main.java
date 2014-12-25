package solarCar;

public class Main
{

	public static void main(String[] args)
	{
		
		//...GENSIS
		Display test = new Display();
		network net = new network();
		test.createAndShowGUI();
		
		net.initlise(); ///...Initlise network side:
		
		///...MAIN SECTION
		
		
		///...REVERLATIONS
		net.destroy();
		
		//...Successful end ...//
	}

}

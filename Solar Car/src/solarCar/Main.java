package solarCar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

import solarCar.Hardware.*;
import solarCar.common.util;


public class Main
{
	//...GENSIS
	protected static Interface window = null;	
	protected static advNetwork net = null;
	protected static Settings options = null;
	private static Surveillance Log = new Surveillance("MAIN");
	protected static LogOutput LogOut = null;
		
	//...Hardware classes
	protected static BatteryPack pBatteryPack = null;
	protected static MiscData  pMisc = null;
	
	//...Thread Load
	private static double stat_ThreadLoad = 0.0f;
	private static advTimer mainThreadTimer;
	
	//...thread series data
    private static final double[] threadSeries = { 0.0, 0.38, 0.71, 0.92, 1.0, 0.92,
        0.71, 0.38, 0.0, -0.38, -0.71, -0.92, -1.0, -0.92, -0.71, -0.38 };
	
	
	public static void main(String[] args)
	{
		//...GENSIS
		Log.Log ("Initlization" , Surveillance.LOG_ENTRY );
		window = new Interface();		
		net = new advNetwork();
		options = new Settings();
		LogOut =  new LogOutput();
		mainThreadTimer = new advTimer(); 
		
		//...Hardware
		pBatteryPack = new BatteryPack();
		pMisc = new MiscData();
		
		//...Loading		
		options.settingsLoad();
		window.initilise();
		net.initlise();
		
		//createChart ( window.cmpsite_GraphLoad );
		
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
		//...Thread performance
		long n,l;double delta = 0;
		while (!exit ) {
			n = (long) mainThreadTimer.getTime();
			//...Check main window for close?
			if (net.update() < 0 )exit =true;	
			if (!window.update())exit =true;
			
			//...Call GUI UPDATES
			forceAllGuiUpdate( );
			
			//...Thread statistics
			l = (long) mainThreadTimer.getTime();
			delta = (double)(l - n);
			stat_ThreadLoad = util.roundEx(mainThreadTimer.nanoToMili( delta ),2);
		}
		Log.Log ("Exit core run function" , Log.LOG_ENTRY );
	}
	
	private static void forceAllGuiUpdate(){
		//...Call GUI UPDATES
		net.netGuiUpdate ( window );
		mainGuiUpdate( );
	}
	
	//...Application load
    protected synchronized static void mainGuiUpdate ( ){
    	//...Update network related infomation:
    	window.display.getDefault().asyncExec(new Runnable() 
    	{
    		 public void run() {
    			//...CPU AND RAM USSAGE
    			 window.txtMainThreadLoad.setText(stat_ThreadLoad+"");
    		 }
    	});
    }
    
    //...Make Chart for main thread.
    //cmpsite_GraphLoad
    protected synchronized static void createChart(final Composite parent) {   
        window.display.getDefault().asyncExec(new Runnable() 
    	{
    		 public void run() {
    			//...CPU AND RAM USSAGE
    		        // create a chart
    		        Chart chart = new Chart(parent, SWT.NONE);

    		        // set titles
    		        chart.getTitle().setText("Line Chart");
    		        chart.getAxisSet().getXAxis(0).getTitle().setText("Data Points");
    		        chart.getAxisSet().getYAxis(0).getTitle().setText("Amplitude");

    		        // create line series
    		        ILineSeries lineSeries = (ILineSeries) chart.getSeriesSet()
    		                .createSeries(SeriesType.LINE, "line series");
    		        lineSeries.setYSeries(threadSeries);

    		        // adjust the axis range
    		        chart.getAxisSet().adjustRange();
    		 }
    	});
    }

}

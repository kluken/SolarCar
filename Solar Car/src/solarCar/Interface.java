package solarCar;


/**
 * 	THIS CLASS REQUIRES SWT PLUGIN:
 * 	TO OBTAIN: 
 * 		https://www.eclipse.org/swt/tools.php
 * 
 * 	To import to Project explorer
 * 	Project(Solar Car)->Properties-> Java Build Path
 * 			-> Add External Jars.
 * 	Locate the SWT plugins. 
 *  C:\eclipse\plugins <- Default plugin.
 * 
 * 
 */
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Interface {
	
	private boolean J_DEBUG = true;
	Surveillance Log = new Surveillance("INTERFACE");

	//...Window shell - Protected
	protected Shell shlSolarCar; 
	
	//...Overview Elements
	protected Text txtCarSpeed;
	protected Text txtBatteryLevel;
	protected Text txtNetDataRecv;
	protected Text txtNetPacketsSecond;
	protected Text txtNetConnectionState;
	protected Text txt_CarDistanceTotal;
	protected Text txtNetTotalMegabytes;
	protected Text txtNetTotalPackets;
	protected Text txtNetLoad;
	protected Text txtOverBatteryHealth;
	protected Display display = null;
	
	//...GUI Threading
	Thread threadit = null;

	private class InterfaceThread implements Runnable {
		public synchronized void run() {
			Log.Log("Thread online");
			try {
				
				display = Display.getDefault();
				createContents();
				shlSolarCar.open();
				shlSolarCar.layout();
				
				//...updates the interface
				while (!shlSolarCar.isDisposed()) {
					if (!display.readAndDispatch()) {
						
						display.sleep();
					}
				}
			
			}catch (SWTException ex){
				Log.Log ( "Thread exception! | Cause: " + ex.getCause() + " \n\tMessage: " + ex.getMessage());
			}
			
			Log.Log ( "Thread Offline");
        }
	}
	
	/**
	 * Open the window.
	 */
	public void initilise() {
		//...Update thread - REQUIRED [CRITICAL]
		try {
			threadit = new Thread ( new InterfaceThread() );
			threadit.sleep(500);
			threadit.start();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Log.Log ( "Thread Interrupted ");
			e.printStackTrace();
		}	
	}
	
	public void destroy () {
		Log.Log ( "Interrupting Thread!");
		threadit.interrupt();
	}
	
	//...This may need to be threaded
	public boolean update () {
		if (threadit.isAlive()) {	
			//...Call the network
			
			return true;
		}
		return false;
	}
	
	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 * 
	 */
	protected void createContents() {
		
		//...Create window Shell
		shlSolarCar = new Shell();
		shlSolarCar.setMinimumSize(new Point(768, 512));
		shlSolarCar.setSize(768, 512);
		shlSolarCar.setText("Solar Car - LIGHT BENDER");
		
		//...Create window menu		
		Menu menu = new Menu(shlSolarCar, SWT.BAR);
		shlSolarCar.setMenuBar(menu);
		
		// Add menu items - File		
		MenuItem mntmApplication = new MenuItem(menu, SWT.CASCADE);
		mntmApplication.setText("Application");
		
		Menu menu_1 = new Menu(mntmApplication);
		mntmApplication.setMenu(menu_1);
		
		MenuItem mntmSettings = new MenuItem(menu_1, SWT.NONE);
		mntmSettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Log.Log("Opening OPTIONS", Log.LOG_INFO );
				Main.options.open();
			}
		});
		mntmSettings.setText("Settings");
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmLog = new MenuItem(menu, SWT.NONE);
		mntmLog.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				Log.Log("Opening log display", Log.LOG_INFO );
				Main.LogOut.open();
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				Log.Log("Opening log display", Log.LOG_INFO );
				Main.LogOut.open();
			}
		});
		mntmLog.setText("Log");
		
		//...Second Menu button - About
		MenuItem mntmAbout = new MenuItem(menu, SWT.CASCADE);
		mntmAbout.setText("About");
		
		Menu menu_2 = new Menu(mntmAbout);
		mntmAbout.setMenu(menu_2);
		
		MenuItem mntmHelp = new MenuItem(menu_2, SWT.NONE);
		mntmHelp.setText("Help");
		
		MenuItem mntmAbout_1 = new MenuItem(menu_2, SWT.NONE);
		mntmAbout_1.setText("About");
		
		//...Side navigation		
		Composite composite = new Composite(shlSolarCar, SWT.BORDER);
		composite.setTouchEnabled(true);
		composite.setBounds(0, 0, 168, 454);
		
		Label lblOverview = new Label(composite, SWT.NONE);
		lblOverview.setBounds(10, 10, 55, 15);
		lblOverview.setText("Overview");
		
		Button btnGeneralOverview = new Button(composite, SWT.CENTER);
		btnGeneralOverview.setBounds(20, 31, 128, 25);
		btnGeneralOverview.setText("General Overview");
		
		Label lblNetwork = new Label(composite, SWT.NONE);
		lblNetwork.setBounds(10, 363, 55, 15);
		lblNetwork.setText("Network");
		
		Button btnNetOverview = new Button(composite, SWT.NONE);
		btnNetOverview.setBounds(20, 384, 124, 25);
		btnNetOverview.setText("Net Overview");
		
		Button btnNetGraph = new Button(composite, SWT.NONE);
		btnNetGraph.setText("Net Graph");
		btnNetGraph.setBounds(20, 415, 124, 25);
		
		//########################################################
		// 				TAB SECTION								//
		TabFolder tabFolder = new TabFolder(shlSolarCar, SWT.NONE);
		tabFolder.setBounds(174, 10, 568, 434);
		
		TabItem tbtmOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmOverview.setText("Overview");
		
		Composite comp_overview = new Composite(tabFolder, SWT.NONE);
		tbtmOverview.setControl(comp_overview);
		
		Group grpSolarCar = new Group(comp_overview, SWT.NONE);
		grpSolarCar.setText("Solar Car");
		grpSolarCar.setBounds(0, 0, 528, 265);
		
		Label lblSpeedkmh = new Label(grpSolarCar, SWT.NONE);
		lblSpeedkmh.setBounds(10, 23, 78, 15);
		lblSpeedkmh.setText("Speed (Km/H):");
		
		txtCarSpeed = new Text(grpSolarCar, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtCarSpeed.setText("100km/h");
		txtCarSpeed.setBounds(116, 20, 76, 21);
		
		Label lblDistanceTravel = new Label(grpSolarCar, SWT.NONE);
		lblDistanceTravel.setBounds(10, 55, 100, 15);
		lblDistanceTravel.setText("Distance Travel");
		
		txt_CarDistanceTotal = new Text(grpSolarCar, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txt_CarDistanceTotal.setBounds(116, 52, 76, 21);
		
		Group grpOverviewBattery = new Group(grpSolarCar, SWT.NONE);
		grpOverviewBattery.setText("Battery");
		grpOverviewBattery.setBounds(336, 10, 182, 245);
		
		Label lblBattery = new Label(grpOverviewBattery, SWT.NONE);
		lblBattery.setBounds(10, 21, 82, 15);
		lblBattery.setText("Battery Level");
		
		txtBatteryLevel = new Text(grpOverviewBattery, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtBatteryLevel.setBounds(96, 18, 76, 21);
		txtBatteryLevel.setText("75%");
		
		ProgressBar progressBarBatteryLevel = new ProgressBar(grpOverviewBattery, SWT.BORDER | SWT.SMOOTH);
		progressBarBatteryLevel.setBounds(10, 42, 162, 17);
		
		Label lblHealth = new Label(grpOverviewBattery, SWT.NONE);
		lblHealth.setBounds(10, 65, 55, 15);
		lblHealth.setText("Health:");
		
		txtOverBatteryHealth = new Text(grpOverviewBattery, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtOverBatteryHealth.setText("GOOD");
		txtOverBatteryHealth.setBounds(96, 65, 76, 21);
		
		Group grpNetwork = new Group(comp_overview, SWT.NONE);
		grpNetwork.setText("Network");
		grpNetwork.setBounds(0, 271, 528, 125);
		
		Label lblDataRecv = new Label(grpNetwork, SWT.NONE);
		lblDataRecv.setBounds(92, 25, 128, 15);
		lblDataRecv.setText("Receiving/ Second");
		
		txtNetDataRecv = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtNetDataRecv.setText("--");
		txtNetDataRecv.setBounds(10, 22, 76, 21);
		
		txtNetPacketsSecond = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtNetPacketsSecond.setText("--");
		txtNetPacketsSecond.setBounds(10, 49, 76, 21);
		
		Label lblPacketsSecond = new Label(grpNetwork, SWT.NONE);
		lblPacketsSecond.setBounds(92, 52, 128, 15);
		lblPacketsSecond.setText("Packets / Second");
		
		Label lblStatus = new Label(grpNetwork, SWT.NONE);
		lblStatus.setBounds(10, 97, 55, 15);
		lblStatus.setText("Status: ");
		
		txtNetConnectionState = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY);
		txtNetConnectionState.setText("--");
		txtNetConnectionState.setBounds(92, 94, 101, 21);
		
		Label lblTotalBytes = new Label(grpNetwork, SWT.NONE);
		lblTotalBytes.setBounds(368, 25, 55, 15);
		lblTotalBytes.setText("Total Bytes:");
		
		txtNetTotalMegabytes = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY);
		txtNetTotalMegabytes.setText("--");
		txtNetTotalMegabytes.setBounds(442, 22, 76, 21);
		
		txtNetTotalPackets = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY);
		txtNetTotalPackets.setText("--");
		txtNetTotalPackets.setBounds(442, 49, 76, 21);
		
		Label lblTotalPackets = new Label(grpNetwork, SWT.NONE);
		lblTotalPackets.setBounds(347, 49, 76, 15);
		lblTotalPackets.setText("Total Packets");
		
		Label lblThreadLoad = new Label(grpNetwork, SWT.NONE);
		lblThreadLoad.setBounds(357, 100, 66, 15);
		lblThreadLoad.setText("Thread Load");
		
		txtNetLoad = new Text(grpNetwork, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtNetLoad.setText("--");
		txtNetLoad.setBounds(442, 94, 76, 21);
		
		//########################################################
		// 				NETWORK TAB SECTION								//
		
		TabItem tbtmNetOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmNetOverview.setText("Net Overview");
		
		Composite comp_netoverview = new Composite(tabFolder, SWT.NONE);
		tbtmNetOverview.setControl(comp_netoverview);

	}    
}

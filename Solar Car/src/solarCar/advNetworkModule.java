package solarCar;


//...SWT Imports
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
//...Config
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class advNetworkModule {
	
	private boolean J_DEBUG = true;
	Surveillance Log = new Surveillance("NET_GUI");

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
	
	public void initilise() {
		
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
	
	public boolean hookGUI (  ){
		//...Hook the contents
		return true;
	}
	
	protected Shell shlNetworkModule;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlNetworkModule.open();
		shlNetworkModule.layout();
		while (!shlNetworkModule.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlNetworkModule = new Shell();
		shlNetworkModule.setMinimumSize(new Point(256, 384));
		shlNetworkModule.setSize(603, 493);
		shlNetworkModule.setText("Settings");
				
		//########################################################
		// 				TAB SECTION								//
		TabFolder tabFolder = new TabFolder(shlNetworkModule, SWT.NONE);
		tabFolder.setBounds(10, 10, 568, 434);		
		
		TabItem tbtmNetOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmNetOverview.setText("Net Overview");
		
		Composite comp_overview = new Composite(tabFolder, SWT.NONE);
		tbtmNetOverview.setControl(comp_overview);
		
		Group grpNetworkStatistics = new Group(comp_overview, SWT.NONE);
		grpNetworkStatistics.setText("Network Statistics");
		grpNetworkStatistics.setBounds(10, 10, 278, 386);
		
		Group grpNetGraph = new Group(comp_overview, SWT.NONE);
		grpNetGraph.setText("Net Graph");
		grpNetGraph.setBounds(294, 182, 256, 214);
		
		Label lblRecv = new Label(grpNetGraph, SWT.NONE);
		lblRecv.setBounds(10, 22, 55, 15);
		lblRecv.setText("Recv");
		
		Label lblLatency = new Label(grpNetGraph, SWT.NONE);
		lblLatency.setBounds(10, 88, 55, 15);
		lblLatency.setText("Latency");
		
		Label lblThread = new Label(grpNetGraph, SWT.NONE);
		lblThread.setBounds(10, 154, 55, 15);
		lblThread.setText("Thread");
		
		Group grpNetworkControls = new Group(comp_overview, SWT.NONE);
		grpNetworkControls.setText("Network Controls");
		grpNetworkControls.setBounds(294, 10, 256, 166);
		
		Group grpThread = new Group(grpNetworkControls, SWT.NONE);
		grpThread.setText("Thread");
		grpThread.setBounds(10, 20, 236, 59);
		
		Button btnNetThreadStart = new Button(grpThread, SWT.NONE);
		btnNetThreadStart.setBounds(10, 20, 59, 25);
		btnNetThreadStart.setText("START");
		
		Button btnThreadStop = new Button(grpThread, SWT.NONE);
		btnThreadStop.setBounds(75, 20, 70, 25);
		btnThreadStop.setText("STOP");
		
		Button btnRestart = new Button(grpThread, SWT.NONE);
		btnRestart.setBounds(151, 20, 75, 25);
		btnRestart.setText("RESTART");
		
		//...Content
	}    
}

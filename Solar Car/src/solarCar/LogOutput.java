package solarCar;

//...SWT Imports
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
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
import java.util.ArrayList;
import java.util.Properties;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;

public class LogOutput {
	
	//...Logging
	private Surveillance Log = new Surveillance ( "LOG_OUTPUT" ); 

	protected Shell shlLogOutput;
	private Text txtLogSize;
	private List listLogDisplay;
	private Combo comboFilterLevel;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		setup();
		shlLogOutput.open();
		shlLogOutput.layout();
		
		
		
		while (!shlLogOutput.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void setup ( ){
		filledLogWindow(0);
		filledLogLevel ();
		
		
	}

	//...Fill out log display
	protected synchronized void filledLogLevel ( ){
		Display.getDefault().asyncExec(new Runnable() 
    	{
	    	public void run()
	    	{
				//...Basic fill log window
				for ( int i=0;i<Surveillance.LOG_HIDEBUG;i++){
					comboFilterLevel.add( Surveillance.getLogLevelStr(i) );				
				}
	    	}
    	});
	} 
    	
	
	//...Fill out log display
	protected synchronized void filledLogWindow ( int filterLevel ){
		Display.getDefault().asyncExec(new Runnable() 
    	{
	    	public void run()
	    	{
	    		if (listLogDisplay.isDisposed()) return;
				//...Basic fill log window
				ArrayList<?> tLog =  Surveillance.getLogs();
				
				for ( int i = 0; i<tLog.size();i++){
					//...Fill log
					listLogDisplay.add( (String) tLog.get(i) );
				}				
			
	    	}	    	
    	});	
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlLogOutput = new Shell();
		shlLogOutput.setMinimumSize(new Point(256, 384));
		shlLogOutput.setSize(500, 590);
		shlLogOutput.setText("Settings");
		
		Group grpFilters = new Group(shlLogOutput, SWT.NONE);
		grpFilters.setText("Filters");
		grpFilters.setBounds(10, 460, 464, 82);
		
		Label lblFilterLevel = new Label(grpFilters, SWT.NONE);
		lblFilterLevel.setBounds(10, 20, 56, 15);
		lblFilterLevel.setText("Filter Level");
		
		comboFilterLevel = new Combo(grpFilters, SWT.NONE);
		comboFilterLevel.setBounds(72, 12, 91, 23);
		
		Label lblLogSize = new Label(grpFilters, SWT.NONE);
		lblLogSize.setBounds(10, 57, 55, 15);
		lblLogSize.setText("Log size: ");
		
		txtLogSize = new Text(grpFilters, SWT.BORDER);
		txtLogSize.setBounds(72, 57, 76, 21);
		
		Button btnRefresh = new Button(grpFilters, SWT.NONE);
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Log.Log("Refresh Log", Surveillance.LOG_INFO );
				filledLogWindow(0);
			}
		});
		btnRefresh.setBounds(379, 47, 75, 25);
		btnRefresh.setText("Refresh");
		
		listLogDisplay = new List(shlLogOutput, SWT.BORDER |  SWT.V_SCROLL);
		listLogDisplay.setBounds(10, 10, 464, 444);
	    
	}
	
	public void destroy() {
		
	}
	
	
}

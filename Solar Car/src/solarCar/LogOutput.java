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
import java.util.Properties;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;

public class LogOutput {
	
	//...Logging
	private Surveillance Log = new Surveillance ( "LOG_OUTPUT" ); 

	protected Shell shlSettings;
	private Text txtLogSize;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSettings.open();
		shlSettings.layout();
		while (!shlSettings.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//...Log List
	
	//...Fill out log display
	protected void filledLogWindow ( int filterLevel ){
		//...Basic fill log window
		
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlSettings = new Shell();
		shlSettings.setMinimumSize(new Point(256, 384));
		shlSettings.setSize(500, 590);
		shlSettings.setText("Settings");
		
		Group grpFilters = new Group(shlSettings, SWT.NONE);
		grpFilters.setText("Filters");
		grpFilters.setBounds(10, 460, 464, 82);
		
		Label lblFilterLevel = new Label(grpFilters, SWT.NONE);
		lblFilterLevel.setBounds(10, 20, 56, 15);
		lblFilterLevel.setText("Filter Level");
		
		Combo comboFilterLevel = new Combo(grpFilters, SWT.NONE);
		comboFilterLevel.setBounds(72, 12, 91, 23);
		
		Label lblLogSize = new Label(grpFilters, SWT.NONE);
		lblLogSize.setBounds(10, 57, 55, 15);
		lblLogSize.setText("Log size: ");
		
		txtLogSize = new Text(grpFilters, SWT.BORDER);
		txtLogSize.setBounds(72, 57, 76, 21);
		
		List listLogDisplay = new List(shlSettings, SWT.BORDER);
		listLogDisplay.setBounds(10, 10, 464, 444);

	}
	
	public void destroy() {
		
	}
	
	//....Settings
	public boolean settingsSave ( ) {
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {
			output = new FileOutputStream("config.properties");

			// set the properties value
			
			//...Data base settings
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "solarcar");
			prop.setProperty("dbpassword", "solarcar");	
			
			//...Network settings
			prop.setProperty("netIpAddress", 	Main.net.getIpAddr() );
			prop.setProperty("netPort", 		Main.net.getPort() );
			prop.setProperty("netType", 		Main.net.getNetworkType() );
			
			// save properties to project root folder
			prop.store(output, null);
			
		
		} catch (IOException e) {
			Log.Log("IOException Saving Settings", Log.LOG_WARNING);
			return false;
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					Log.Log("IOException Closing Settings File", Log.LOG_WARNING);
					return false;
				}
			}
	 
		}
		
		//...Success
		return true;
	}
	
	public boolean settingsLoad ( ) {
		//...Save the settings
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream("config.properties");
	 
			// load a properties file
			prop.load(input);
	 
			//...Get database
			prop.getProperty("database");
			prop.getProperty("dbuser");
			prop.getProperty("dbpassword");
			
			//Network			
			Main.net.OverrideIP(prop.getProperty("netIpAddress"));
			Main.net.OverridePort(prop.getProperty("netPort" ));
			
			prop.getProperty("netType");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
}

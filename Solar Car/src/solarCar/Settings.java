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

public class Settings {
	
	//...Logging
	private Surveillance Log = new Surveillance ( "SETTINGS" ); 

	protected Shell shlSettings;
	private Text txtNetIP;
	private Text txtNetPort;
	private Text text;

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

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlSettings = new Shell();
		shlSettings.setMinimumSize(new Point(256, 384));
		shlSettings.setSize(450, 403);
		shlSettings.setText("Settings");
		
		Group grpNetwork = new Group(shlSettings, SWT.NONE);
		grpNetwork.setText("Network");
		grpNetwork.setBounds(10, 10, 414, 94);
		
		Label lblIp = new Label(grpNetwork, SWT.NONE);
		lblIp.setBounds(10, 22, 20, 15);
		lblIp.setText("IP:");
		
		Label lblPort = new Label(grpNetwork, SWT.NONE);
		lblPort.setBounds(190, 22, 31, 15);
		lblPort.setText("Port:");
		
		txtNetIP = new Text(grpNetwork, SWT.BORDER);
		txtNetIP.setText("239.255.60.60");
		txtNetIP.setToolTipText("fortmat: aaa.bbb.ccc.ddd");
		txtNetIP.setBounds(31, 19, 151, 21);
		
		txtNetPort = new Text(grpNetwork, SWT.BORDER);
		txtNetPort.setText("4875");
		txtNetPort.setBounds(223, 19, 76, 21);
		
		Label lblNetwork = new Label(grpNetwork, SWT.NONE);
		lblNetwork.setBounds(10, 58, 55, 15);
		lblNetwork.setText("Protocal:");
		
		Button btnNetProcUdp = new Button(grpNetwork, SWT.RADIO);
		btnNetProcUdp.setSelection(true);
		btnNetProcUdp.setBounds(68, 57, 90, 16);
		btnNetProcUdp.setText("UDP");
		
		Button btnNetProcTcp = new Button(grpNetwork, SWT.RADIO);
		btnNetProcTcp.setBounds(164, 57, 90, 16);
		btnNetProcTcp.setText("TCP");
		
		Button btnNetProcRpiExperimental = new Button(grpNetwork, SWT.RADIO);
		btnNetProcRpiExperimental.setEnabled(false);
		btnNetProcRpiExperimental.setToolTipText("Rasberry Pi Server (!! EXPERIMENTAL !!)");
		btnNetProcRpiExperimental.setBounds(260, 58, 144, 16);
		btnNetProcRpiExperimental.setText("RPI ( Experimental! )");
		
		Button btnApply = new Button(shlSettings, SWT.NONE);
		btnApply.setBounds(349, 330, 75, 25);
		btnApply.setText("Apply");
		
		Button btnSave = new Button(shlSettings, SWT.NONE);
		btnSave.setBounds(268, 330, 75, 25);
		btnSave.setText("Save");
		
		Group grpDataRecording = new Group(shlSettings, SWT.NONE);
		grpDataRecording.setText("Data Recording");
		grpDataRecording.setBounds(10, 110, 414, 76);
		
		Label lblRecordMethod = new Label(grpDataRecording, SWT.NONE);
		lblRecordMethod.setBounds(10, 23, 82, 16);
		lblRecordMethod.setText("Record Method:");
		
		Button btnDataRecSQL = new Button(grpDataRecording, SWT.RADIO);
		btnDataRecSQL.setToolTipText("Record Data to SQL Database");
		btnDataRecSQL.setBounds(98, 23, 93, 16);
		btnDataRecSQL.setText("SQL Database");
		
		Button btnFlatFile = new Button(grpDataRecording, SWT.RADIO);
		btnFlatFile.setBounds(197, 23, 90, 16);
		btnFlatFile.setText("Flat File");
		
		Button btnNone = new Button(grpDataRecording, SWT.RADIO);
		btnNone.setSelection(true);
		btnNone.setBounds(293, 23, 90, 16);
		btnNone.setText("None");
		
		Label lblLocation = new Label(grpDataRecording, SWT.NONE);
		lblLocation.setBounds(10, 51, 55, 15);
		lblLocation.setText("Location:");
		
		text = new Text(grpDataRecording, SWT.BORDER);
		text.setBounds(60, 48, 227, 21);
		
		Button btnSet = new Button(grpDataRecording, SWT.NONE);
		btnSet.setBounds(293, 44, 75, 25);
		btnSet.setText("Locate");
		
		Group grpSolarCar = new Group(shlSettings, SWT.NONE);
		grpSolarCar.setText("Solar Car");
		grpSolarCar.setBounds(10, 192, 414, 132);

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

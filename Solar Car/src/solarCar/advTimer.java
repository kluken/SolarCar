package solarCar;

/**
 * @author Matt Richardson
 *
 *	@Info : Delta time is used for information updating too keep constant values where lag may impede accuracy.
 *			Using delta time, update values can maintain a smooth value between updates.
 *			
 */

public class advTimer {
	
	//...Class variables
	private long lastTime,resolution,frequency;
	private double tickRate,delta;
	
	//...Static finals
	public static final long SECOND_TO_NANO = 100000;
	public static final long NANO_TO_SECOND = 1000000;
	
	//...setup
	private void create ( ){
		tickRate = 60;
		lastTime = getTime();
		frequency = 1;
		resolution = 1;
		delta = 0;
	}
	
	private long getTime() {
		return System.nanoTime();
	}
	
	//...Constructors
	advTimer (){
		create();
	}
	advTimer ( int rate ) {
		create();
		tickRate = rate;
	}
	
	//...Time now
	public double timeNow ( ) {
		long now = getTime();
		return now;//return (now*resolution/frequency);
	}
	
	public double SetResolution ( double res ) {
		//...Check
		if ( res <=0 || res > frequency ) {
			return -1;
		}else{
			resolution = (long)res;
			return 1;
		}
	}

	//...Get functions
	public double getResolution ( ) {
		return resolution;
	}
	public double getFrequency ( ) {
		return frequency;
	}
	

	//...Delta time calculator: 
	public double deltaTime () {
		//...Calculate delta time
		long now = getTime(),lt;
		lt = lastTime;
		lastTime = now;
		return ((lt - now));//*resolution/frequency);		
	}
	
	public double nanoToMili ( double delta ) {
		return delta / NANO_TO_SECOND;
	}
	
}

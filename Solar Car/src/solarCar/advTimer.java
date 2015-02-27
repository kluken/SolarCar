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
	
	//...setup
	private void create ( ){
		tickRate = 60D;
		lastTime = System.nanoTime();
		frequency = 1;
		resolution = 1000000;
		delta = 0;
	}
	
	//...Constructors
	advTimer (){
		create();
	}
	advTimer ( int rate ) {
		create();
		tickRate = rate;
	}
	
	//...Delta time calculator: 
	public double deltaTime () {
		//...Calculate delta time
		long now = System.nanoTime(),lt;
		lt = lastTime;
		lastTime = now;
		delta = (double)((now - lt)*resolution/frequency);
		
		//...return detla time.
		return delta;
	}
	
	

}

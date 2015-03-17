package solarCar.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import solarCar.advTimer;

public class statTrack {
	private static final String LOG_ARRAY_ZERO = "Length of array cannot be 0!";
	private int MAX_ELEMENTS = 256;
	private int MAX_TIME     = 1000; //...1000ms
    private Map<Long, Integer> list = null;
    private ArrayList<Long>Keys = null;
    private ArrayList<Integer>Values = null;
	
	public statTrack ( ) {
		list = new HashMap<Long, Integer>();
	    Keys = new ArrayList<Long>();
	    Values = new ArrayList<Integer>();
	}
	
	//...Tick marker
	public static long getTime ( ) {
		return System.currentTimeMillis();
	}
	
	//...Count
	public long getRate (  ) {
		update();
		return getCount();
	}	
	
	//...Count
	public long getRateV (  ) {
		//...Check index
		return getValeAll();
	}
	
	public void update ( ) {	
		//...Counters
		long c,t=getTime();
		//...Loop through Keys
		for ( int i=0; i<Keys.size();i++){
			c = (long)Keys.get(i)+MAX_TIME;	//...Get the value
			//...If Log is less than time. then remove.
			if ( c < t ){ 
				Keys.remove(i);
				Values.remove(i);
			}else{
				/*
				 * Theory: Array List is ordered.
				 * If reach an un-expired element. the rest are the same.
				 * */
				i = Keys.size();				
			}
		}		
	}
	
	public long getCount ( ) {
		return Keys.size();
	}
	
	public void addMark ( ) {
		//list.put(getTime() , 0 );
		Keys.add( getTime() );
		Values.add(0);
	}
	public void addMark ( int len ) {
		Keys.add( getTime() );
		Values.add(len);
	}
	
	public int getValue ( int key ) {
		return Values.get(Keys.indexOf(key));		
	}
	
	public int getValeAll ( ) {
		//...Counters
		long c,t=getTime();int v=0;
		//...Loop through Keys
		for ( int i=0; i<Keys.size();i++){
			c = (long)Keys.get(i)+MAX_TIME;	//...Get the value
			//...If Log is less than time. then remove.
			if ( c < t ){ 
				Keys.remove(i);
				Values.remove(i);
			}else{
				/*
				 * Theory: Array List is ordered.
				 * If reach an un-expired element. the rest are the same.
				 * */
				v+=Values.get(i);			
			}
		}	
		return v;		
	}
	
	public void clear() {
		list.clear();
	}
	
}

package solarCar.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import solarCar.advTimer;

public class statTrack {
	private static final String LOG_ARRAY_ZERO = "Length of array cannot be 0!";
	private int MAX_ELEMENTS = 256;
	private int MAX_TIME     = 1000; //...1000ms
    private Map<Long, Integer> list = null;
	
	public statTrack ( ) {
		list = new HashMap<Long, Integer>();
	}
	
	//...Tick marker
	private long getTime ( ) {
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
		update();
		return getValeAll();
	}
	
	public void update ( ) {
		//...Check index
		ArrayList<Long>keys = new  ArrayList<Long>(list.keySet());
		long c,t=getTime();
		for ( int i=keys.size()-1;i>=0;i--){
			c = (long)keys.get(i)+MAX_TIME;
			if ( c < t ){ list.remove(keys.get(i)); }
		}
	}
	
	public long getCount ( ) {
		return list.size();
	}
	
	public void addMark ( ) {
		list.put(getTime() , 0 );
	}
	public void addMark ( int len ) {
		list.put(getTime() , len );
	}
	
	public int getValue ( int key ) {
		return list.get(key);		
	}
	
	public int getValeAll ( ) {
		ArrayList<Long>keys = new  ArrayList<Long>(list.keySet());
		long c=0,t=getTime();int v=0;
		for ( int i=keys.size()-1;i>=0;i--){
			c = (long)keys.get(i);
			v+= list.get(c);
		}
		return v;
	}
	
	public void clear() {
		list.clear();
	}
	
}

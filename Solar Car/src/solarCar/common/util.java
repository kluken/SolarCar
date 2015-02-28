package solarCar.common;

public class util  {
	public static double roundEx ( double value , double num ) {
		return Math.round(value * 100.0) / (Math.pow(10, num ));
	}
}

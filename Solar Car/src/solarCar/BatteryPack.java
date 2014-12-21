package solarCar;

public class BatteryPack
{
	private boolean newData;
	private boolean error;
	private int capacityRemaining;
	private int drainRate;
	
	public BatteryPack()
	{
		newData = false;
		error = false;
		capacityRemaining = 0;
		drainRate = 0;
	}
	
	public void setNewDataFlag(boolean setFlag)
	{
		newData = setFlag;
	}
	
	public boolean getNewData()
	{
		return newData;
	}
	
	public void setError(boolean setFlag)
	{
		error = setFlag;
	}
	
	public boolean getError()
	{
		return error;
	}
	
	public void setCapacityRemaining( int newCapacity)
	{
		capacityRemaining = newCapacity;
	}
	
	public int getCapacityRemaining()
	{
		return capacityRemaining;
	}
	
	public void setDrainRate(int newDrainRate)
	{
		drainRate = newDrainRate;
	}
	
	public int getDrainRate()
	{
		return drainRate;
	}
	
}

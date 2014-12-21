package solarCar;

public class MotorController
{
	private boolean newData;
	private boolean error;
	private int speed;
	
	public MotorController()
	{
		newData = false;
		error = false;
		speed = 0;
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
	
	public void setSpeed(int newSpeed)
	{
		speed = newSpeed;
	}
	
	public int getSpeed()
	{
		return speed;
	}
}

package backend;

public class CarObject
{
	public int vehID;
	public String fromDirection;
	public String toDirection;
	public int arrivingTime;
	
	public CarObject(int v, String fd, String td, int at) {
		vehID = v;
		fromDirection = fd;
		toDirection = td;
		arrivingTime = at;
	}
	
	public CarObject()
	{
		
	}
	public void setVehID(int v)
	{
		vehID = v;
	}
	public int getVehID()
	{
		return vehID;
	}
	public void setFromDirection(String fd)
	{
		fromDirection = fd;
	}
	public String getFromDirection()
	{
		return fromDirection;
	}
	public void setToDirection(String td)
	{
		toDirection = td;
	}
	public String getToDirection()
	{
		return toDirection;
	}
	public void setArrivingTime(int at)
	{
		arrivingTime = at;
	}
	public int getArrivingTime()
	{
		return arrivingTime;
	}
}
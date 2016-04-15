package dataStructures;

public class CollisionObjects {

	Boolean isCollision;
	int collisionTime;
	public CollisionObjects(int collTime)
	{
		isCollision = false;
		collisionTime = collTime;
	}
	public CollisionObjects() {

	}
	public boolean getIsCollision()
	{
		return this.isCollision;
	}
	public int getCollisionTime()
	{
		return this.collisionTime;
	}
	public int updateCollisionTimeLeft()
	{
		return collisionTime -=600;
	}
	public int updateCollisionTimeStraight()
	{
		return collisionTime -= 500;
	}
	
	public void setisCollision(boolean val)
	{
		this.isCollision = val ;
	}
	public void setCollisionTime(int c)
	{
		this.collisionTime = c;
	}
}

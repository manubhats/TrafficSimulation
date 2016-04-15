package dataStructures;

import java.util.HashMap;

import dataStructures.CollisionObjects;


public class CollisionHashMap {
	
	//One HashMap for each direction
	//Direction of the Car : Straight
	public static HashMap<String, CollisionObjects> SNmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> NSmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> WEmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> EWmap = new HashMap<String, CollisionObjects>(0);
	
	//Direction of the Car : Left Turn
	public static HashMap<String, CollisionObjects> ESmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> NEmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> WNmap = new HashMap<String, CollisionObjects>(0);
	public static HashMap<String, CollisionObjects> SWmap = new HashMap<String, CollisionObjects>(0);

	//Straight
	public void initializeSNmap()
	{
		SNmap.put("EW", new CollisionObjects(1000));
		SNmap.put("WE", new CollisionObjects(2500));
		SNmap.put("NE", new CollisionObjects(2400));
		SNmap.put("ES", new CollisionObjects(1200));
	}
	
	
	public void initializeNSmap()
	{
		NSmap.put("EW", new CollisionObjects(2500));
		NSmap.put("SW", new CollisionObjects(2400));
		NSmap.put("WN", new CollisionObjects(1200));
		NSmap.put("WE", new CollisionObjects(1000));
	}

	
	public void initializeWEmap()
	{
		WEmap.put("NS", new CollisionObjects(1500));
		WEmap.put("SN", new CollisionObjects(2000));
		WEmap.put("ES", new CollisionObjects(2400));
		WEmap.put("SW", new CollisionObjects(1800));
	}
	public void initializeEW()
	{
		EWmap.put("SN", new CollisionObjects(1000));
		EWmap.put("NS", new CollisionObjects(2500));
		EWmap.put("NE", new CollisionObjects(1200));
		EWmap.put("WN", new CollisionObjects(2400));
	}
	//Left turn
	public void initializeSWmap()
	{
		SWmap.put("NS", new CollisionObjects(1500));
		SWmap.put("WE", new CollisionObjects(2000));
		SWmap.put("ES", new CollisionObjects(2400));
		SWmap.put("WN", new CollisionObjects(1800));
	}
	public void initializeES()
	{
		ESmap.put("SN", new CollisionObjects(1000));
		ESmap.put("WE", new CollisionObjects(2500));
		ESmap.put("NE", new CollisionObjects(1200));
		ESmap.put("SW", new CollisionObjects(2400));
	}
	public void initializeNE()
	{
		NEmap.put("EW", new CollisionObjects(1200));
		NEmap.put("WN", new CollisionObjects(1800));
		NEmap.put("SN", new CollisionObjects(2400));
		NEmap.put("ES", new CollisionObjects(1800));
	}
	public void initializeWN()
	{
		
		WNmap.put("NS", new CollisionObjects(2000));
		WNmap.put("EW", new CollisionObjects(1500));
		WNmap.put("SW", new CollisionObjects(2400));
		WNmap.put("NE", new CollisionObjects(1200));
	}
}
package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import dataStructures.CollisionHashMap;
import dataStructures.DirectionQueues;

enum LANE{LEFT, STRAIGHT, RIGHT};

public class masterClass
{
	public static HashMap<Integer, CarObject> carMap = new HashMap<Integer, CarObject>();
	
	public static void display()
	{
		 for (Integer key : carMap.keySet())
		 {
			 System.out.print("\tVeh ID = " + key);
			 System.out.print("\tFrom  = " + carMap.get(key).getFromDirection());
			 System.out.print("\tTo = " + carMap.get(key).getToDirection());
			 System.out.print("\tArriving time = " + carMap.get(key).getArrivingTime());
			 System.out.println();
		 }
	}

	public static void loadCarMapWithDefaultEntries()
	{
		//straight
		carMap.put(10000, new CarObject(10000,"N","S",999));
		carMap.put(10001, new CarObject(10001,"S","N",999));
		carMap.put(10002, new CarObject(10002,"E","W",999));
		carMap.put(10003, new CarObject(10003,"W","E",999));
		
		//left
		carMap.put(10004, new CarObject(10004,"N","E",999));
		carMap.put(10005, new CarObject(10005,"S","W",999));
		carMap.put(10006, new CarObject(10006,"W","N",999));
		carMap.put(10007, new CarObject(10007,"E","S",999));
	}
	
	
	
	public static void main(String[] args)
	{
		DirectionQueues d = new DirectionQueues();
		String csvFile = "/home/manubhat/workspace/Traffic_Simulation/input/input_1.csv";
		String line = "";
		String cvsSplitBy = ",";
		loadCarMapWithDefaultEntries();
		int vehID = 0;
		String fromDirection;
		String toDirection;
		int arrivingTime = 0;
		//Intialize Collision Hashmaps
		CollisionHashMap c = new CollisionHashMap();
		c.initializeES();
		c.initializeEW();
		c.initializeNE();
		c.initializeNSmap();
		c.initializeSNmap();
		c.initializeSWmap();
		c.initializeWEmap();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) 
			{
				String[] vehicle = line.split(cvsSplitBy);
				vehID = Integer.parseInt(vehicle[0]);
				fromDirection = vehicle[1];
				toDirection = vehicle[2];
				arrivingTime = Integer.parseInt(vehicle[3]);
				
				CarObject c1 = new CarObject(vehID, fromDirection, toDirection,arrivingTime);
				carMap.put(vehID, c1);
			}
			for (int key : carMap.keySet())
			{
				CarCreation car = new CarCreation(key);
			    car.threadStart();
			}
		}
		catch (IOException e)
		{
				e.printStackTrace();
		}
		
		display();		
	}
}


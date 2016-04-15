package backend;
import dataStructures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import dataStructures.CollisionHashMap;
import dataStructures.DirectionQueues;



public class Intersection
{
    static Timer leftTurnTimer, straightTimer;
    static int left_counterNE, left_counterSW, left_counterWN, left_counterES = 3000;
    
    static int straight_counterNS, straight_counterSN, straight_counterEW, straight_counterWE = 3000;
    static int topElementNS = 0, topElementSN = 0, topElementEW = 0, topElementWE = 0;
	static int topElementNE = 0, topElementSW = 0, topElementWN = 0, topElementES = 0;

  public static synchronized void checkCollisionHashMap(int minCar)
  {
	  String frmto = masterClass.carMap.get(minCar).getFromDirection()+masterClass.carMap.get(minCar).getToDirection()+"map";
	  
	  
	  if(frmto.equals("SNmap") && !DirectionQueues.SN.isEmpty())
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.SNmap.keySet())
		  {
			  if(CollisionHashMap.SNmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/6);
//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
//					  else
//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.SNmap.get(key).getIsCollision());
		  }
		  
		  if(Collections.frequency(myList, false) == CollisionHashMap.SNmap.size())
		  {
			  CollisionHashMap.EWmap.get("SN").setisCollision(true);
			  CollisionHashMap.EWmap.get("SN").updateCollisionTimeStraight();
			  
			  CollisionHashMap.ESmap.get("SN").setisCollision(true);
			  CollisionHashMap.ESmap.get("SN").updateCollisionTimeStraight();
			  
			  CollisionHashMap.NEmap.get("SN").setisCollision(true);
			  CollisionHashMap.NEmap.get("SN").updateCollisionTimeStraight();
			  
			  CollisionHashMap.WEmap.get("SN").setisCollision(true);
			  CollisionHashMap.WEmap.get("SN").updateCollisionTimeStraight();
			  
			  straight_counterSN -= 500;

			  if(straight_counterSN == 0)
			  {
				  DirectionQueues.SN.poll();
				  System.out.println("Car has passed intersection coming from South-->North");
				  straight_counterSN = 3000;
			  }
		  }
	  }
	  
	  else if(frmto.equals("EWmap") && !DirectionQueues.EW.isEmpty())
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.EWmap.keySet())
		  {
			  if(CollisionHashMap.EWmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/6);
//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
//					  else
//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.EWmap.get(key).getIsCollision());
		  }
		  
		  if(Collections.frequency(myList, false) == CollisionHashMap.SNmap.size())
		  {
			  CollisionHashMap.SNmap.get("EW").setisCollision(true);
			  CollisionHashMap.SNmap.get("EW").updateCollisionTimeStraight();
			  
			  CollisionHashMap.NSmap.get("EW").setisCollision(true);
			  CollisionHashMap.NSmap.get("EW").updateCollisionTimeStraight();
			  
			  CollisionHashMap.NEmap.get("EW").setisCollision(true);
			  CollisionHashMap.NEmap.get("EW").updateCollisionTimeStraight();
			  
			  CollisionHashMap.WNmap.get("EW").setisCollision(true);
			  CollisionHashMap.WNmap.get("EW").updateCollisionTimeStraight();
			  
			  straight_counterEW -= 500;
			  
			  if(straight_counterEW == 0)
			  {
				  DirectionQueues.EW.poll();
				  System.out.println("Car has passed intersection coming from East-->West");
				  straight_counterEW = 3000;
			  }
		  }
	  }
			
	  else if(frmto.equals("NSmap") && !DirectionQueues.NS.isEmpty())
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.NSmap.keySet())
		  {
			  if(CollisionHashMap.NSmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/6);
//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
//					  else
//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.NSmap.get(key).getIsCollision());
		  }
		  
		  if(Collections.frequency(myList, false) == CollisionHashMap.NSmap.size())
		  {
			  CollisionHashMap.SWmap.get("NS").setisCollision(true);
			  CollisionHashMap.SWmap.get("NS").updateCollisionTimeStraight();
			  
			  CollisionHashMap.EWmap.get("NS").setisCollision(true);
			  CollisionHashMap.EWmap.get("NS").updateCollisionTimeStraight();
			  
			  CollisionHashMap.WNmap.get("NS").setisCollision(true);
			  CollisionHashMap.WNmap.get("NS").updateCollisionTimeStraight();
			  
			  CollisionHashMap.WEmap.get("NS").setisCollision(true);
			  CollisionHashMap.WEmap.get("NS").updateCollisionTimeStraight();
			  
			  straight_counterNS -= 500;
			  
			  if(straight_counterNS == 0)
			  {
				  DirectionQueues.NS.poll();
				  System.out.println("Car has passed intersection coming from North-->South");
				  straight_counterNS = 3000;				  
			  }
		  } 
	  }
	  
	  else if(frmto.equals("WEmap") && !DirectionQueues.WE.isEmpty())
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.WEmap.keySet())
		  {
			  if(CollisionHashMap.WEmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/6);
		//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
		//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
		//					  else
		//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.WEmap.get(key).getIsCollision());
			  if(Collections.frequency(myList, false) == CollisionHashMap.WEmap.size())
			  {
				  CollisionHashMap.SNmap.get("WE").setisCollision(true);
				  CollisionHashMap.SNmap.get("WE").updateCollisionTimeStraight();
				
				  CollisionHashMap.SWmap.get("WE").setisCollision(true);
				  CollisionHashMap.SWmap.get("WE").updateCollisionTimeStraight();
				  
				  CollisionHashMap.ESmap.get("WE").setisCollision(true);
				  CollisionHashMap.ESmap.get("WE").updateCollisionTimeStraight();
				  
				  CollisionHashMap.NSmap.get("WE").setisCollision(true);
				  CollisionHashMap.NSmap.get("WE").updateCollisionTimeStraight();
				  
				  straight_counterWE -= 500;
				  
				  if(straight_counterWE == 0)
				  {
					  DirectionQueues.WE.poll();
					  System.out.println("Car has passed intersection coming from West-->East");
					  straight_counterWE = 3000;
				  }
			  }
		  }
	  }
  
  
	  
	  //LEFT TURNS
	  if(frmto.equals("SWmap"))
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.SWmap.keySet())
		  {
			  if(CollisionHashMap.SWmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/5);
		//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
		//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
		//					  else
		//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.SWmap.get(key).getIsCollision());
			  if(Collections.frequency(myList, false) == CollisionHashMap.SWmap.size())
			  {
				  CollisionHashMap.ESmap.get("SW").setisCollision(true);
				  CollisionHashMap.ESmap.get("SW").updateCollisionTimeLeft();
				
				  CollisionHashMap.NSmap.get("SW").setisCollision(true);
				  CollisionHashMap.NSmap.get("SW").updateCollisionTimeLeft();
				  
				  CollisionHashMap.WEmap.get("SW").setisCollision(true);
				  CollisionHashMap.WEmap.get("SW").updateCollisionTimeLeft();
				  
				  CollisionHashMap.WNmap.get("SW").setisCollision(true);
				  CollisionHashMap.WNmap.get("SW").updateCollisionTimeLeft();
				  
				  left_counterSW -= 600;
				  
				  if(left_counterSW == 0)
				  {
					  DirectionQueues.SW.poll();
					  System.out.println("Car has passed intersection coming from South-->West");
					  left_counterSW = 3000;
				  }
			  }
		  }
	  }
	  else if(frmto.equals("ESmap"))
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.ESmap.keySet())
		  {
			  if(CollisionHashMap.ESmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/5);
		//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
		//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
		//					  else
		//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.ESmap.get(key).getIsCollision());
			  if(Collections.frequency(myList, false) == CollisionHashMap.ESmap.size())
			  {
				  CollisionHashMap.SNmap.get("ES").setisCollision(true);
				  CollisionHashMap.SNmap.get("ES").updateCollisionTimeLeft();
				
				  CollisionHashMap.SWmap.get("ES").setisCollision(true);
				  CollisionHashMap.SWmap.get("ES").updateCollisionTimeLeft();
				  
				  CollisionHashMap.NEmap.get("ES").setisCollision(true);
				  CollisionHashMap.NEmap.get("ES").updateCollisionTimeLeft();
				  
				  CollisionHashMap.WEmap.get("ES").setisCollision(true);
				  CollisionHashMap.WEmap.get("ES").updateCollisionTimeLeft();
				  
				  left_counterSW -= 600;
				  
				  if(left_counterSW == 0)
				  {
					  DirectionQueues.SW.poll();
					  System.out.println("Car has passed intersection coming from South-->West");
					  left_counterSW = 3000;					  
				  }
			  }
		  }
	  }
	  if(frmto.equals("NEmap"))
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.SWmap.keySet())
		  {
			  if(CollisionHashMap.SWmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/5);
		//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
		//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
		//					  else
		//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.SWmap.get(key).getIsCollision());
			  if(Collections.frequency(myList, false) == CollisionHashMap.SWmap.size())
			  {
				  CollisionHashMap.SNmap.get("NE").setisCollision(true);
				  CollisionHashMap.SNmap.get("NE").updateCollisionTimeLeft();
				
				  CollisionHashMap.EWmap.get("NE").setisCollision(true);
				  CollisionHashMap.EWmap.get("NE").updateCollisionTimeLeft();
				  
				  CollisionHashMap.ESmap.get("NE").setisCollision(true);
				  CollisionHashMap.ESmap.get("NE").updateCollisionTimeLeft();
				  
				  CollisionHashMap.WNmap.get("NE").setisCollision(true);
				  CollisionHashMap.WNmap.get("NE").updateCollisionTimeLeft();
				  
				  left_counterSW -= 600;
				  
				  if(left_counterSW == 0)
				  {
					  DirectionQueues.SW.poll();
					  System.out.println("Car has passed intersection coming from South-->West");
					  left_counterSW = 3000;
				  }
			  }
		  }
	  }
	  else if(frmto.equals("WNmap"))
	  {
		  List<Boolean> myList = new ArrayList<Boolean>();
		  for (String key : CollisionHashMap.WNmap.keySet())
		  {
			  if(CollisionHashMap.WNmap.get(key).getIsCollision() == true)
			  {
				  try
				  {
					  Thread.currentThread().sleep(3000/5);
		//					  if(CollisionHashMap.SNmap.get(key).getCollisionTime()!= 0)
		//						  CollisionHashMap.SNmap.get(key).updateCollisionTimeStraight();
		//					  else
		//						  CollisionHashMap.SNmap.get(key).setisCollision(false);
				  }
				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  myList.add(CollisionHashMap.WNmap.get(key).getIsCollision());
			  if(Collections.frequency(myList, false) == CollisionHashMap.WNmap.size())
			  {
				  CollisionHashMap.SWmap.get("WN").setisCollision(true);
				  CollisionHashMap.SWmap.get("WN").updateCollisionTimeLeft();
				
				  CollisionHashMap.EWmap.get("WN").setisCollision(true);
				  CollisionHashMap.EWmap.get("WN").updateCollisionTimeLeft();
				  
				  CollisionHashMap.NSmap.get("WN").setisCollision(true);
				  CollisionHashMap.NSmap.get("SW").updateCollisionTimeLeft();
				  
				  CollisionHashMap.NEmap.get("WN").setisCollision(true);
				  CollisionHashMap.NEmap.get("WN").updateCollisionTimeLeft();
				  
				  left_counterWN -= 600;
				  
				  if(left_counterWN == 0)
				  {
					  DirectionQueues.WN.poll();
					  System.out.println("Car has passed intersection coming from West-->North");
					  left_counterWN = 3000;
				  }
			  }
		  }
	  }
  }
	
	public static void navigate()
    {
    	int delay = 0;
    	
    	/*-----------While taking a Left Turn-----------*/
        int leftTurnPeriod = (3000/5);
        leftTurnTimer = new Timer();
        leftTurnTimer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
            	if(DirectionQueues.NE.isEmpty() && DirectionQueues.SW.isEmpty() && DirectionQueues.WN.isEmpty() && DirectionQueues.ES.isEmpty())
            	{
            		leftTurnTimer.cancel();
            		return;
            	}
        			
            	int minCar = 0;
            	System.out.println("Timer 1");
       
            	topElementNE = DirectionQueues.NE.element();
            	topElementSW = DirectionQueues.SW.element();
            	topElementWN = DirectionQueues.WN.element();
            	topElementES = DirectionQueues.ES.element();
            	
            	HashMap<Integer, Integer> abc = new HashMap<Integer, Integer>();
            	abc.put(topElementNE, masterClass.carMap.get(topElementNE).getArrivingTime());
            	abc.put(topElementSW, masterClass.carMap.get(topElementSW).getArrivingTime());
            	abc.put(topElementWN, masterClass.carMap.get(topElementWN).getArrivingTime());
            	abc.put(topElementES, masterClass.carMap.get(topElementES).getArrivingTime());
            	
            	int [] arrTimes = {masterClass.carMap.get(topElementNE).getArrivingTime(), masterClass.carMap.get(topElementSW).getArrivingTime(), 
            			masterClass.carMap.get(topElementWN).getArrivingTime(), masterClass.carMap.get(topElementES).getArrivingTime()};
            	Arrays.sort(arrTimes);
            	
            	for (Entry<Integer, Integer> entry : abc.entrySet()) {
                    if (entry.getValue().equals(arrTimes[0])) {
                    	minCar = entry.getKey();
                    }
            	}
	           
                System.out.println("Smallest Direction (LEFT)= "+ minCar);
                
                //call synchronized method to check collision hashmap
                /*-----------FETCH FROM THE COLLISION MAP-----------*/
                checkCollisionHashMap(minCar);
            }
        }, delay, leftTurnPeriod);
        
	  
        /*-----------For moving Straight-----------*/
        int straightPeriod = (3000/6);
        straightTimer = new Timer();
        straightTimer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
            	if(DirectionQueues.NS.isEmpty() && DirectionQueues.SN.isEmpty() && DirectionQueues.WE.isEmpty() && DirectionQueues.EW.isEmpty())
            	{
            		straightTimer.cancel();
            		return;
            	}
        			
            	System.out.println("Timer 2");
            	int minCar = 0;
            	
        		topElementNS = DirectionQueues.NS.element();            		
        		topElementSN = DirectionQueues.SN.element();					
				topElementEW = DirectionQueues.EW.element();	               
                topElementWE = DirectionQueues.WE.element();

                HashMap<Integer, Integer> abc = new HashMap<Integer, Integer>();
            	abc.put(topElementNS, masterClass.carMap.get(topElementNS).getArrivingTime());
            	abc.put(topElementSN, masterClass.carMap.get(topElementSN).getArrivingTime());
            	abc.put(topElementEW, masterClass.carMap.get(topElementEW).getArrivingTime());
            	abc.put(topElementWE, masterClass.carMap.get(topElementWE).getArrivingTime());
            	
            	int [] arrTimes = {masterClass.carMap.get(topElementNS).getArrivingTime(), masterClass.carMap.get(topElementSN).getArrivingTime(), 
            			masterClass.carMap.get(topElementEW).getArrivingTime(), masterClass.carMap.get(topElementWE).getArrivingTime()};
            	Arrays.sort(arrTimes);
            	
            	for (Entry<Integer, Integer> entry : abc.entrySet())
            	{
                    if (entry.getValue().equals(arrTimes[0]))
                    {
                    	minCar = entry.getKey();
                    }
            	}
            	System.out.println("Smallest Direction (STRAIGHT)= "+minCar);
            	checkCollisionHashMap(minCar);
            }
        }, delay, straightPeriod);
    }
}
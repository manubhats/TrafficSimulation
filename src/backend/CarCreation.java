package backend;


import dataStructures.DirectionQueues;

public class CarCreation implements Runnable
{
	private Thread t;
	private int vehID;
	
	
	CarCreation(int name)
	{
		vehID = name;
	}
	
	public void run()
	{
		System.out.println("Running car: " +  Thread.currentThread().getName() );
	    	 switch(masterClass.carMap.get(vehID).getFromDirection())
	    	 {
	    	 	case "N": 	switch(masterClass.carMap.get(vehID).getToDirection())
	    	 					{
	    	 						case "S":	//Straight Lane
	    	 										if(DirectionQueues.NS.element() == 10000)
	    	 											DirectionQueues.NS.remove();
	    	 										DirectionQueues.NS.add(vehID);
	    	 										System.out.println("Added to NS queue");
	    	 										//Intersection.NorthToSouth();
	    	 										break;
	    	 						case "E":	//Left Lane
	    	 										if(DirectionQueues.NE.element() == 10004)
	    	 											DirectionQueues.NE.remove();
	    	 										DirectionQueues.NE.add(vehID);
	    	 										System.out.println("Added to NE queue");
	    	 										break;
	    	 						case "W":	//Free Right turn
	    	 										break;
	    	 					}
	    	 					break;
	    	 					
	    	 	case "S": 	switch(masterClass.carMap.get(vehID).getToDirection())
								{
									case "N":	//Straight Lane
													if(DirectionQueues.SN.element() == 10001)
														DirectionQueues.SN.remove();
													DirectionQueues.SN.add(vehID);
													System.out.println("Added to SN queue");
													break;
									case "W":	//Left Lane
													if(DirectionQueues.SW.element() == 10005)
														DirectionQueues.SW.remove();
													DirectionQueues.SW.add(vehID);
													System.out.println("Added to SW queue");
													break;
									case "E":	//Free Right Lane
													break;
								}
								break;
								
	    	 	case "E": 	switch(masterClass.carMap.get(vehID).getToDirection())
								{
									case "W":	//Straight Lane
													if(DirectionQueues.EW.element() == 10002)
														DirectionQueues.EW.remove();
													DirectionQueues.EW.add(vehID);
													System.out.println("Added to EW queue");
													break;
									case "S":	//Left Lane
													if(DirectionQueues.ES.element() == 10007)
														DirectionQueues.ES.remove();
													DirectionQueues.ES.add(vehID);
													System.out.println("Added to ES queue");
													break;
									case "N":	//Free Right turn
													break;
								}
								break;
								
	    	 	case "W": 	switch(masterClass.carMap.get(vehID).getToDirection())
								{
									case "E":	//Straight Lane
													if(DirectionQueues.WE.element() == 10003)
														DirectionQueues.WE.remove();
													DirectionQueues.WE.add(vehID);
													System.out.println("Added to WE queue");
													break;
									case "N":	//Left Lane
													if(DirectionQueues.WN.element() == 10006)
														DirectionQueues.WN.remove();
													DirectionQueues.WN.add(vehID);
													System.out.println("Added to WN queue");
													break;
									case "S":	//Free Right turn
													break;
								}
								break;
	    	 }
	    	 
	    	 Intersection.navigate();
	    	     
	}
	public void threadStart()
	{
	      if (t == null)
	      {
	         t = new Thread (this);
	         t.run();
	         try
	         {
				t.join();
	         }
	         catch (InterruptedException e)
	         {
	        	 e.printStackTrace();
			}
	      }
	}
	
}
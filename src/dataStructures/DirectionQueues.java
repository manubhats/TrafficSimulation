package dataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class DirectionQueues
{
	
	
	public static Queue<Integer> NS = new LinkedList<Integer>();
	public static Queue<Integer> SN = new LinkedList<Integer>();
	public static Queue<Integer> EW = new LinkedList<Integer>();
	public static Queue<Integer> WE = new LinkedList<Integer>();
	 
	
	//Left Lanes
	public static Queue<Integer> NE = new LinkedList<Integer>();
	public static Queue<Integer> SW = new LinkedList<Integer>();
	public static Queue<Integer> ES = new LinkedList<Integer>();
	public static Queue<Integer> WN = new LinkedList<Integer>();
	
	/*Initialize all the Queues to zero*/
	public DirectionQueues() {		
		//Straight
		DirectionQueues.NS.add(10000);
		DirectionQueues.SN.add(10001);
		DirectionQueues.EW.add(10002);
		DirectionQueues.WE.add(10003);
		//left
		DirectionQueues.NE.add(10004);
		DirectionQueues.SW.add(10005);
		DirectionQueues.WN.add(10006);
		DirectionQueues.ES.add(10007);
	}
	
	public static void displayQueues(Queue<?> q)
	{
		Iterator<?> iterator = q.iterator();
		while(iterator.hasNext())
		{
		  Integer element = (Integer)iterator.next();
		  System.out.println("---------"+element);
		}
	}
}
package others;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {
	public static void main(String[] args) {
		Queue oqueue=new LinkedList();

	    oqueue.add("1");
	    oqueue.add("2");
	    oqueue.add("3");
	    oqueue.add("4");
	    oqueue.add("5");
	    
	    listQueueElements(oqueue);
	    popQueueElements(oqueue);
	    listQueueElements(oqueue);
	}
	
	private static void listQueueElements(Queue oqueue) {
		if(oqueue == null || oqueue.size() == 0) {
			System.out.println("The queue is empty");
			return;
		}
	    Iterator itr=oqueue.iterator();

	    System.out.println("Initial Size of Queue :"+oqueue.size());
	    while(itr.hasNext())
	    {
	        String iteratorValue=(String)itr.next();
	        System.out.println("Queue Next Value :"+iteratorValue);
	    }
	}
	
	private static void popQueueElements(Queue oqueue) {
		if(oqueue == null || oqueue.size() == 0) {
			System.out.println("The queue is empty");
			return;
		}
		
		while (!oqueue.isEmpty()) {
			System.out.println("the element being removed : "+oqueue.peek());
			oqueue.remove();
		}
	}
}
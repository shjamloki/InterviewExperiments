package org.sj.java.multithread.experiments;

import java.util.Vector;

/**
 * This program is to understand wait and notify using the following use case.
 * There is a public toilet service provider and users are using the toilet but only 
 * one toilet is available and keys are available at ToiletServiceProvider. So every
 * user first check with ToiletServiceProver if the keys are available and Toilets is
 * available to use than It take key and use Toilet otherwise wait in the queue. In 
 * out example we have two consumers and continuously go in to the queue mode after using
 * it. We could see from the output that if both consumers goes back to the queue than JVM can
 * give chance to any of the consumer for next turn. It does not maintain FIFO logic.
 * 
 * This program can be extended to many scenarios now. e.g. There are multiple service provider handling 
 * a shared Toilet resource. There are many Toilet resources. 
 * 
 * With this example it is also clear why wait and notify methods are in Object class and why sleep class in
 * Thread class.
 * @author sjamloki
 *
 */
public class ToiletServiceProvider  {
	 
    static final int MAXKEYS = 1;
    private Vector<String> keysAvailable = new Vector<String>();
    
    public ToiletServiceProvider(){
    	keysAvailable.addElement(new java.util.Date().toString());
    }
 
    public void run() {
        try {
            while (true)
            {
            	submitKeys();
                System.out.println("Sleeping .."+Thread.currentThread().getName());
                //Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }
 
    public synchronized void submitKeys() throws InterruptedException {
        while (keysAvailable.size() == MAXKEYS) {
        	System.out.println("All keys are already available.  ");
            wait();
        }
        keysAvailable.addElement(new java.util.Date().toString());
        System.out.println(Thread.currentThread().getName()+" Used Toilet ");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }
 
    // Called by Consumer
    public synchronized String getKeys() throws InterruptedException {
        notify();
        while (keysAvailable.size() == 0) {
        	System.out.println("All keys are used. Please wait. Mr. "+Thread.currentThread().getName());
            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        String message = (String) keysAvailable.firstElement();
        System.out.println(Thread.currentThread().getName()+" will be using Toilet");
        keysAvailable.removeElement(message);
        return message;
    }
    public static void main(String args[]) {
		  ToiletServiceProvider producer = new ToiletServiceProvider();
	        
	        new ToiletConsumer(producer,"consumer1").start();
	        new ToiletConsumer(producer,"consumer2").start();
	    }
}
 
class ToiletConsumer extends Thread {
 
    ToiletServiceProvider producer;
 
    ToiletConsumer(ToiletServiceProvider p,String name) {
    	super(name);
        producer = p;
    }
   
    @Override
    public void run() {
        try {
            while (true)
        	{
                String message = producer.getKeys();
                System.out.println("Got key for toilet: Using it now " + Thread.currentThread().getName());
                sleep(5000);
                producer.submitKeys();
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
  
}

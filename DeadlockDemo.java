package threads;

public class DeadlockDemo {
	public static void main(String[] args) {
		final String resource1 = "pen";
		final String resource2 = "paper";
		
			//Thread 1 locks resource1
			Thread thread1 = new Thread()
			{
			    public void run() {
			    	synchronized(resource1) {
			    		System.out.println("Thread 1 Locked Resource 1: Pen");
			    				try {
			    					Thread.sleep(800);
			    				}
			    				catch(Exception e) {
			    					System.out.println(e.getMessage());
			    				}
			    				
			    				synchronized (resource2) {
			    					System.out.println("Wants to lock resource 2 : Paper");
			    				}
			    	
			    	}
		    }
	};
			//Thread 2 locks resource 2
			Thread thread2 = new Thread()
			{
			    public void run() {
			    	synchronized(resource2) {
			    		System.out.println("Thread 2 Locked Resource 2: Paper");
			    				try {
			    					Thread.sleep(100);
			    				}
			    				catch(Exception e) {
			    					System.out.println(e.getMessage());
			    				}
			    				
			    				synchronized (resource1) {
			    					System.out.println("Wants to lock resource 1: Pen");
			    				}
			    	
			    	}
		    }
	};
	thread1.start();
			
	
//		try {
//			thread1.join();
//		}
//		
//		catch(InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
//		
  	thread2.start();
		
	
	}


	}



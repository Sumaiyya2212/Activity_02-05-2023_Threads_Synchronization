package threads;

//shared object
class Printdata2
{
	synchronized static void multi(int n)//static synchronized method
	{
		//System.out.println(Thread.currentThread().getName()+"Outside the synchronized block");
		synchronized(Printdata2.class)//synchronized block
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println(n+"*"+i+"="+n*i);
				try
				{
					Thread.sleep(400);
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}//end of synchronized block
	}
}

class Printdata3
{
	synchronized static void addition(int a,int b)
	{
		synchronized(Printdata2.class)
		{
			System.out.println("Addition:"+(a+b));
			try
			{
				Thread.sleep(400);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
public class SyncDemo2 {
	public static void main(String[] args) {
		
					Printdata2 pd2=new Printdata2();
					Printdata3 pd3=new Printdata3();
					
					//Anonymous class
					Thread t1=new Thread()
							{
								public void run()
								{
									pd2.multi(2);
								}
							};
							Thread t2=new Thread()
									{
									public void run()
									{
										pd2.multi(3);
									}
									};
							Thread t3=new Thread()
									{
									public void run()
									{
										pd3.addition(4, 3);
									}
									};
							Thread t4=new Thread()
									{
									public void run()
									{
										pd3.addition(43, 36);
									}
									};
									
									t1.start();
									t2.start();
									t3.start();
									t4.start();
				}

	}



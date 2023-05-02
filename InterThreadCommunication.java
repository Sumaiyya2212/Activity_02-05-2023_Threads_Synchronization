package threads;

class Account{
	//Initial account balance
	int balance = 50000;
	
	//Synchronized withdraw method
	synchronized void withdraw(int amount) {
		System.out.println("Start Withdrawing...");
		if(this.balance<amount) {
			System.out.println("Insufficient Balance : Please make a Deposit");
			try {
				wait();
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		this.balance=balance-amount;
		System.out.println("Rs. "+amount+" has been withdraw successfully");
		
	}
	
	//Synchronized deposit method
	synchronized void deposit(int amount) {
		System.out.println("Starting deposit...");
		this.balance=balance+amount;
		System.out.println("Rs. "+amount+" has been deposited successfuly");
        notify();
	}
	
	//synchronized method to display balance
	synchronized void display(){
		try {
			wait(500);
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Balance is :"+balance);
		
	}
}
public class InterThreadCommunication {

	public static void main(String[] args) {
      
		Account ac = new Account();//declaring object for account class
		//declaration of anonymous class 
		new Thread()
		{
			public void run()
			{
				ac.withdraw(60000);
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				ac.display();
			}
		}.start();
		
		
		new Thread()
		{
			public void run()
			{
				ac.deposit(15000);
			}
		}.start();
     	

	}

}

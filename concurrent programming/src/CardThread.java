/**
 * This is the class that manages a single card and using a thread
 * 
 * @author Alfonso Leone
 * @version 1.0
 *
 */


public class CardThread extends Thread
{
	BankAccount account;
	int localBalance = 0;
	
	
	/**
	 * A constructor for a new card thread
	 * 
	 * @param account	takes in an existing account in which to make transactions
	 */
	public CardThread(BankAccount account) 
	{
		this.account = account;
	}

	/**
	 * This is an overriding of the run method from the Tread class.
	 * In this method there is the critical section which can be accessed only
	 * from one thread at time using the synchronized method that takes
	 * an account as a monitor in order to keep the account balance reliable.
	 * At the end of the 20 random transactions this thread will print out
	 * its local balance.
	 * 
	 */
	public void run() 
	{
		for (int i = 0; i < 20; i++)
		{
			int value = (int) (Math.random() * 10);
			if (Math.random() > 0.5) 
			{
				synchronized (account) {
					account.withdraw(value);
					account.addTransaction(Transaction.WITHDRAWAL, value, getId());
					this.localBalance = this.localBalance + value;				
				}
			}

			else {
				synchronized (account) {					
					account.deposit(value);
					account.addTransaction(Transaction.DEPOSIT, value, getId());
					this.localBalance = this.localBalance - value;					
				}

			}

			try {
				sleep(200);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

		} // end of for
		System.out.println("THREAD " + (getId()-9) + " local balance: " + localBalance);

	} // end of run()

} // end of CardThread class
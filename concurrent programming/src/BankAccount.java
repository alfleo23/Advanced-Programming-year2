import java.util.ArrayList;

/**
* The purpose of this class is to create and manage a Bank Account.
* 
* @author Alfonso Leone
* @version 1.0
*/

public class BankAccount 
{
	ArrayList<Transaction> transactions;
	int balance;
	
/**
 * This is the Bank Account constructor which takes an initial balance as parameter
 * and then creates a new ArrayList of transactions
 * 
 * @param aBalance	initial balance
 */
	public BankAccount(int aBalance)
	{
		this.balance = aBalance;
		transactions = new ArrayList<Transaction>();
	}
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * This is the method used to withdraw. Before withdrawing it checks if there
	 * is money to withdraw and if not it makes the thread asking for withdraw to wait
	 * 
	 * @param amount	how much money to withdraw
	 */
	public void withdraw(int amount) {
		if (balance - amount < 0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		balance = balance - amount;
	}

	/**
	 * This is the method used to deposit. After depositing money it notifies all
	 * the possible waiting threads that there is money to withdraw.
	 * 
	 * @param amount	how much money to deposit
	 */
	public void deposit(int amount) {
		balance = balance + amount;
		notifyAll();
	}
	
	/**
	 * This method creates an instance of a Transaction class and
	 * stores it inside the ArrayList transactions. This method also stores the
	 * actual value of balance when the transaction is just made from a thread.
	 * 
	 * @param type	it can be a Transaction.WITHDRAWAL or Transaction.DEPOSIT
	 * @param value	how much money to deposit or withdraw
	 * @param threadId	the Id of the thread responsible for the transaction
	 */
	public void addTransaction(int type, int value, long threadId)
	{
		transactions.add(new Transaction(type, value, balance, threadId));
	}
	
	/**
	 * This is a simple method which prints out all the instances of Transaction
	 * stored inside the ArrayList transactions. There is an IF statement to determine whether
	 * the value of the transaction has to be printed below the deposit or withdrawal column.
	 */
	public void printTransactions() throws InterruptedException {
		System.out.println("Transaction" + "\t" + "Withdrawal" + "\t" + "Deposit" + "\t\t" + "Balance");
		System.out.println("");
		
		for(int i = 0; i < transactions.size(); i++)
		{
			Transaction t = transactions.get(i);
			if(t.getType() == Transaction.WITHDRAWAL) 
			{
				System.out.print(i+1 + " ");
				System.out.println("("+(t.getThreadId()-9)+")" + "\t\t" + t.getValue() + "\t\t" + "" + "\t\t" + t.getAccountBalance());
				Thread.sleep(200);
			}
			else
			{
				System.out.print(i+1 + " ");
				System.out.println("("+(t.getThreadId()-9)+")" + "\t\t" + "" + "\t\t" + t.getValue()  + "\t\t" + t.getAccountBalance());
				Thread.sleep(200);

			}
		}
		
	}

}
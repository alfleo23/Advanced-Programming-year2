
/**
 * This is a class that represents a transaction and its details
 * 
 * @author Alfonso Leone
 * @version 1.0
 *
 */

public class Transaction
{
	public static final int WITHDRAWAL = 0;
	public static final int DEPOSIT = 1;
	
	int type, value, accountBalance;
	long threadId;
	
	/**
	 * This is the constructor for a transaction
	 * 
	 * @param type	the type of the transaction(in this case WITHDRAWAL or DEPOSIT)
	 * @param value	how much money for the transaction
	 * @param accountBalance	the current balance when the transaction was made
	 * @param threadId	the Id of the thread responsible for the transaction
	 * 
	 */
	public Transaction(int type, int value, int accountBalance, long threadId)
	{
		this.type = type;
		this.value = value;
		this.accountBalance = accountBalance;
		this.threadId = threadId;
	}
	
	public int getType()
	{return type;}
	
	public int getValue()
	{return value;}
	
	public int getAccountBalance()
	{return accountBalance;}
	
	public long getThreadId()
	{return threadId;}
	
}
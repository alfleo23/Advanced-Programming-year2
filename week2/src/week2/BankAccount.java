package week2;

public class BankAccount
{
	private double balance;
	
	
	// constructors
	public BankAccount()
	{
		this.balance = 0;
	}
	
	public BankAccount(double balance)
	{
		this.balance = balance;
	}
	
	
	
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	
	public void withdraw(double amount)
	{
		balance = balance - amount;
	}
	
	public void getBalance()
	{
		System.out.println("your balance is: "+ balance);
	}

}

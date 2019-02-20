/**
 * This class contains the main method
 * 
 * @author Alfonso Leone
 * @version 1.0
 */

public class MyAccount
{
	/**
	 * After validating the input from the user this main method creates the number of threads 
	 * specified from the user and links them with the same account. Then the threads all start calling the start method
	 * and finally after called the join method to allow all the threads to finish their operations
	 * the program prints out the a list of all the stored transaction.
	 * 
	 * @param args	It takes only two integer numbers. the first one is the number of cards sharing the account and the second one is the initial account balance
	 *
	 */
	public static void main(String[] args) {
		
		if (args.length != 2) 
		{
			System.err.println("Please enter only the number of cards and the initial balance !");
			System.exit(0);
		}

		int accountBalance = 0;
		int howManyAccounts = 0;
		
		try {
			howManyAccounts = Integer.parseInt(args[0]);
			accountBalance = Integer.parseInt(args[1]);			
		} catch (NumberFormatException e) {
			
			System.err.println("Enter only integer numbers please !");
			System.exit(0);
		}
	
		BankAccount account = new BankAccount(accountBalance);
		CardThread[] cardsArray = new CardThread[howManyAccounts];

		for (int i = 0; i < cardsArray.length; i++)
		{
			cardsArray[i] = new CardThread(account);
		}

		for (int i = 0; i < cardsArray.length; i++)
		{
			cardsArray[i].start();
		}
		
		for (CardThread card: cardsArray)
		{
			try {
				card.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("");
		System.out.println("COMPLETE !!"); 
		System.out.println(" ");
		try {
			account.printTransactions();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	} // end of main

}

package week1;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args)
	{
		double amount=0;
		double percent;
		
		System.out.println("Please enter an amount: ");
		Scanner aScanner = new Scanner(System.in);
		amount =aScanner.nextFloat();
		char control;

		System.out.println("Please enter an account type s=Saver, d=Deposit, c=Child, l=Long");
		control = aScanner.next().charAt(0);
		
		switch (control)
		{
		case 's':
			percent = (amount * 3)/100;
			amount = amount + percent;
			System.out.println("Value after one year is " + amount);
			break;
		case 'd':
			percent = (amount * 0.5)/100;
			amount = amount + percent;
			System.out.println("Value after one year is " + amount);
			break;
		case 'c':
			percent = (amount * 1.5)/100;
			amount = amount + percent;
			System.out.println("Value after one year is " + amount);
			break;
		case 'l':
			percent = (amount * 4)/100;
			amount = amount + percent;
			System.out.println("Value after one year is " + amount);
			break;
		default :
			System.out.println("invalid character entered");
		}
		
     } // end of main
	
	
	} // end of class



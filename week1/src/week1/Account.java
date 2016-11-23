package week1;

public class Account {

	public static void main(String[] args) 
	{
		double bankBalance = -1000.56;
		boolean isMarried = false;
		int age = 63;
		boolean isPensionable = age > 60; // isPensionable is true
		boolean isOverdrawn = bankBalance < 0; // isOverdrawn is true
		System.out.println(!(isPensionable && isMarried) && isOverdrawn);
		System.out.println(!(isPensionable && isMarried || isOverdrawn));
	} // end of main

} // end of class

package week1;

import java.util.Scanner;
public class Exercise1 {
		
	public static void main(String[] args) {
			int number, sum, greaterNumber;
			Scanner sc = new Scanner(System.in);
			char charControl;
			sum =0;
			greaterNumber = 0;
			do
			{
				System.out.println("Please enter a number to sum: ");
				number =sc.nextInt();
				if (number > 0 && number <= 100)
				{
					sum = sum + number;
					if (number > greaterNumber)
					{
						greaterNumber = number;
					}
				}
				else
				{
					System.out.println("invalid number !!");
				}
				System.out.println("do you want to enter another number? Y/N");
				sc = new Scanner(System.in);
				charControl = sc.next().charAt(0);
				
			} while (charControl == 'y');
			
			System.out.println("sum = " + sum);
			System.out.println("greater number entered was = "+ number);

		}
	
}


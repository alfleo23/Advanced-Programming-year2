/**
 * Created by alfonsoleone on 01/10/18.
 */

public class Main
{
	public static void main(String[] args)
	{
		//System.out.println();("Hello World");
		//FizzBuzz();
		//SquareGrid();
		DiagonalGrid();
	}

	public static void FizzBuzz()
	{
		for(int i = 1; i <= 200; i++)
		{
			if( (i % 5 == 0) && (i % 3 == 0) )
				System.out.println("FizzBuzz");
			else if(i % 5 == 0)
				System.out.println("Buzz");
			else if(i % 3 == 0)
				System.out.println("Fizz");
			else
				System.out.println(i);
		}
	}

	public static void SquareGrid()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void DiagonalGrid()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10-i; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}


}
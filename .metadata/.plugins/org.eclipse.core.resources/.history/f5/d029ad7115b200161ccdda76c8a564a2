package week2;

public class PolySolve {

	private double a;
	private double b;
	private double c;
	
	public PolySolve(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public static void display(PolySolve any)
	{
		if (any.a == 0)
		{
			double result = aIsZero(any.b, any.c);
			System.out.println("the polynome is " + (int) any.b + "x + " + (int) any.c + " = 0");
			System.out.println("");
			System.out.println("x = " + result);
		}
		else
		{
			double x1 = positiveRootFinder(any.a, any.b, any.c);
			double x2 = negativeRootFinder(any.a, any.b, any.c);
			System.out.println("the polynome is " + (int) any.a + "x² + " + (int) any.b + "x + " + (int) any.c + " = 0");
			System.out.println("");
			System.out.println("x1 is: " + x1);
			System.out.println("x2 is: " + x2);
		}

	}
	
	
	
	public static double positiveRootFinder(double a, double b, double c)
	{
			double squareRoot = Math.sqrt(Math.pow(b, 2) - 4*a*c) ;
			double positiveX = (-b + squareRoot) / (2*a);
			return positiveX;
			
	}
	
	public static double negativeRootFinder(double a, double b, double c)
	{
			double squareRoot = Math.sqrt(Math.pow(b, 2) - 4*a*c) ;
			double negativeX = (-b - squareRoot) / (2*a);
			return negativeX;		
	}
	
	public static double aIsZero(double b, double c)
	{
		double x = -1 * (c/b);
		return x;
	}
	

}


//Double.isNan()

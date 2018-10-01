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
	
	public void display()
	{
		if (a == 0)
		{
			double result = aIsZero(b, c);
			System.out.println("the polynome is " + (int) b + "x + " + (int) c + " = 0");
			System.out.println("");
			System.out.println("x = " + result);
		}
		else
		{
			double x1 = positiveRootFinder(a, b, c);
			double x2 = negativeRootFinder(a, b, c);
			System.out.println("the polynome is " + (int) a + "x² + " + (int) b + "x + " + (int) c + " = 0");
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

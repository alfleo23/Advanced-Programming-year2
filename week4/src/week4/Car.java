package week4;

public class Car implements Vehicle
{
	private int age;
	
	public Car (int anAge)
	{
		this.age = anAge;
	}
	
	
	
	public int TaxValue()
	{
		int taxValue = 25 * this.age;
		return taxValue;
	}
	
	public String VehicleType()
	{
		String s = "Car";
		return s;
	}

}

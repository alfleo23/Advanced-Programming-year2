package week4;

public class MotorBike implements Vehicle
{
	private int age;
	
	public MotorBike (int anAge)
	{
		this.age = anAge;
	}
	
	public int TaxValue()
	{
		int taxValue = 15 * this.age;
		return taxValue;
	}
	
	public String VehicleType()
	{
		String s = "MotorBike";
		return s;
	}

}

package week4;

public class ControllerEx2 {

	public static void main(String[] args)
	{
		Car car1 = new Car(5);
		MotorBike moto1 = new MotorBike(5);
		
		System.out.println("car1 is a " + car1.VehicleType());
		System.out.println("Tax " + car1.TaxValue());
		
		System.out.println("moto1 is a " + moto1.VehicleType());
		System.out.println("Tax " + moto1.TaxValue());
	}

}

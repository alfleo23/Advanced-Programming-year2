package week3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerEx2 {

	public static void main(String[] args)
	{
		Person newPerson = new Person("jack", "123 Manchester", 725272, "jake@gmail.com");
		System.out.println(newPerson.toString());
		
		Employee empl1 = new Employee("Bill", "334 Leeds", 746468, "Bill@fastweb.com");
		empl1.setDepartment("Sales");
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			empl1.setStartDate(dateformat.parse("12/06/2012") );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(empl1.toString() );
		
		Student2 stud1 = new Student2("Billy", "2 Ossory Street", 345678990, "noreligion@mee.de", true );
		System.out.println(stud1.toString() );
		
	}

}

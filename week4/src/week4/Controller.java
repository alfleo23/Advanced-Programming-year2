package week4;

import java.util.Arrays;

public class Controller {

	public static void main(String[] args)
	{
		Person[] persons = new Person [3];
		
		persons[0] = new Person("Alex", "White", 32);
		persons[1] = new Person("Matt", "Berry", 28);
		persons[2] = new Person("Beth", "Prest", 18);
		
		for (int i=0; i<3; i++)
		{
			 Person person = persons[i];
			 String lastName = person.getLastName();
			 String firstName = person.getFirstName();
			 int age = person.getAge();
			 System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}
		
		Arrays.sort(persons);

		 System.out.println();
		 System.out.println("Sorted by age");
		 for (int i=0; i<3; i++) 
		 {
			 Person person = persons[i];
			 String lastName = person.getLastName();
			 String firstName = person.getFirstName();
			 int age = person.getAge();
			 System.out.println(lastName + ", " + firstName + ". Age:" + age);
		 }
	}

}

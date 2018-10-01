package week2;

public class Person
{
	private int age;
	private String name;
	private Object Person;
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public Person(Person aPerson)
	{
		this(aPerson.getName(), aPerson.getAge());
	}
	
	
	public static Person newInstance(Person aPerson)
	{
		return new Person (aPerson.getName(), aPerson.getAge());
	}
	
	
	
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age  = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return "Name = "+this.getName()+" Age = "+this.getAge();
	}
}

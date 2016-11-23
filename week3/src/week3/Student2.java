package week3;

public class Student2 extends Person
{
	private boolean enrolled;
	
	public Student2(String name, String address, int phone, String email, Boolean isEnrolled )
	{
		super(name, address, phone, email);
		this.setEnrolled(isEnrolled);
	}
	
	public boolean getEnrolled()
	{
		return enrolled;
	}
	
	public void setEnrolled(boolean enrolled)
	{
		this.enrolled = enrolled;
	}
	
	public String toString()
	{
		return "Student Status: " + super.getName()+" Enrolled: "+ this.getEnrolled()+" Email:" +super.getEmail();
	}
}		

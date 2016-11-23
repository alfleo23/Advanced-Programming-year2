package week3;

public class Student 
{
	private String name;
	private int stuNumber;
	
	public Student(String aName, int aStuNumber)
	{
		this.name = aName;
		if (errorChecking())
		{
			this.stuNumber = aStuNumber;
		}
		
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNum()
	{
		return stuNumber;
	}
	
	public boolean errorChecking()
	{
		if (getNum() < 1 || getNum() > 10000)
		{return true;}
		else
		{return false;}
	}
	
	
	
	
} // end of class

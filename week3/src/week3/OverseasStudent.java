package week3;

public class OverseasStudent extends Student
{
	private String homeCountry;
	private String[] possibleCountries = {"Spain", "Nigeria", "France", "Germany"};
	
	public OverseasStudent(String name, int stuNumber, String homeCountry)
	{
		super(name,stuNumber);
		this.homeCountry = homeCountry;
	}
	
	public String getCountry()
	{
		return homeCountry;
	}
	
	public boolean checkCountry()
	{
		for (int i = 0; i < possibleCountries.length; i++)
		{
			if (possibleCountries[i].toUpperCase().equals(getCountry().toUpperCase()) )
			{
				return false;
			}
		}
		
		return true;
	}
} // end of class

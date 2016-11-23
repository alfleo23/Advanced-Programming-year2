
public class Person 
{
	private String name;
	private char gender;
	private String natInsNo;
	private String dob;
	private String Address;
	private String Postcode;
	
	public Person(String name, char gender, String nin, String dob, String address, String postcode)
	{
		this.name = name;
		this.gender = gender;
		this.natInsNo = nin;
		this.dob = dob;
		this.Address = address;
		this.Postcode = postcode;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getNatInsNo() {
		return natInsNo;
	}

	public void setNatInsNo(String natInsNo) {
		this.natInsNo = natInsNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String postcode) {
		Postcode = postcode;
	}
	
	//Test
	
	
}


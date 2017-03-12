/**
 * This is a class that defines a person
 *
 * @author Alfonso Leone
 * @version 1.0
 */

public class Person
{
	private String name;
	private String gender;
	private String dob;
	private String address;
	private String postcode;

	/**
	 * this is a blank constructor that will allow us to manually set a person properties
	 * later on in the development
	 */
	public Person()
	{}

	/**
	 * Person constructor
	 *
	 * @param name
	 * @param gender
	 * @param dob date of birth
	 * @param address
	 * @param postcode
	 */
	public Person(String name, String gender, String dob, String address, String postcode)
	{
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.postcode = postcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


}

/**
 * this is a class that defines an employee and inherits from Person
 *
 * @author Alfonso Leone
 * @version 1.0
 */

public class Employee extends Person
{
	private String nin;
	private String salary;
	private String jobTitle;
	private String startDate;
	private String email;

	/**
	 *
	 * @param name
	 * @param gender
	 * @param dob
	 * @param address
	 * @param postcode
	 * @param nin
	 * @param salary
	 * @param jobTitle
	 * @param startDate
	 * @param email
	 */
	public Employee(String name, String gender, String dob, String address, String postcode, String nin, String salary, String jobTitle, String startDate, String email)
	{
		super(name, gender, dob, address, postcode);
		this.salary = salary;
		this.nin = nin;
		this.startDate = startDate;
		this.jobTitle = jobTitle;
		this.email = email;
	}

	/**
	 * a blank Employee constructor that will allow us to manually set
	 * an employee properties later on in the development
	 */
	public Employee()
	{
		super();
	}

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
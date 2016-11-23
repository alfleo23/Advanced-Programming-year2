
public class Employee extends Person
{
	private String id;
	private String salary;
	private String startDate;
	private String title;
	private String email;
	
	public Employee(String id, String name, char gender, String nin, String dob, String address, String postcode, String salary, String startdate, String title, String email)
	{
		super(name, gender, nin, dob,address,postcode);
		this.id = id;
		this.salary = salary;
		this.startDate = startdate;
		this.title = title;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

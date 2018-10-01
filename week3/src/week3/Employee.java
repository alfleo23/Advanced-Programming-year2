package week3;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Person
{
	 private String department;
	 private double salary;
	 private Date startDate;
	 private SimpleDateFormat dateformat;
	
	 public Employee(String name, String address, int phone, String email)
	 {
		 super(name, address, phone, email);
		 dateformat = new SimpleDateFormat("dd/MM/yyyy");
	 }

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String toString()
	{
		 return "Employee Name: " + super.getName()
		 + ", Start Date: "+dateformat.format(this.getStartDate())
		 +", Department: " + this.getDepartment() + ".";
	}

}

package adv_progr_assignment;
// Alfonso Leone 15002679

/**
 * this is a class that defines an employee and inherits from Person
 *
 * @author Alfonso Leone
 * @version 1.0
 */

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Employee extends Person
{
	private int id;
	private String salary;
	private String startDate;
	private String title;
	private String email;

	/**
	 * Employee constructor
	 *
	 * @param name
	 * @param gender
	 * @param nin
	 * @param dob
	 * @param address
	 * @param postcode
	 * @param salary
	 * @param startdate
	 * @param title
	 * @param email
	 */
	public Employee(String name, char gender, String nin, String dob, String address, String postcode, String salary, String startdate, String title, String email)
	{
		super(name, gender, nin, dob,address,postcode);
		this.salary = salary;
		this.startDate = startdate;
		this.title = title;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getJobTitle() {
		return title;
	}

	public void setJobTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
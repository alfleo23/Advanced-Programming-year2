package adv_progr_assignment;

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
	
	public Employee(int id, String name, char gender, String nin, String dob, String address, String postcode, String salary, String startdate, String title, String email)
	{
		super(name, gender, nin, dob,address,postcode);
		this.id = id;
		this.salary = salary;
		this.startDate = startdate;
		this.title = title;
		this.email = email;
	}
	
	public Employee(int id, String name, char gender, String nin, String dob, String address, String postcode, String salary, String startdate, String title, String email, ImageIcon anImage)
	{
		super(name, gender, nin, dob, address, postcode, anImage);
		this.id = id;
		this.salary = salary;
		this.startDate = startdate;
		this.title = title;
		this.email = email;
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
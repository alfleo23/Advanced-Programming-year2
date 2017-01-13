package adv_progr_assignment;
// Alfonso Leone 15002679

/**
 * This is a class that defines a person
 *
 * @author Alfonso Leone
 * @version 1.0
 */

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Person 
{
	private String name;
	private char gender;
	private String natInsNo;
	private String dob;
	private String Address;
	private String Postcode;
	private ImageIcon employeeImage;

	/**
	 * this is a blank constructor that will allow us to manually set a person properties
	 * later on in the development
	 */
	public Person()
	{}

	/**
	 * Person constructor without an image
	 *
	 * @param name
	 * @param gender
	 * @param nin national insurance number
	 * @param dob date of birth
	 * @param address
	 * @param postcode
	 */
	public Person(String name, char gender, String nin, String dob, String address, String postcode)
	{
		this.name = name;
		this.gender = gender;
		this.natInsNo = nin;
		this.dob = dob;
		this.Address = address;
		this.Postcode = postcode;	
	}

	/**
	 * Person constructor with an image
	 *
	 * @param name
	 * @param gender
	 * @param nin
	 * @param dob
	 * @param address
	 * @param postcode
	 * @param anImage the person image
	 */
	public Person(String name, char gender, String nin, String dob, String address, String postcode, ImageIcon anImage)
	{
		this.name = name;
		this.gender = gender;
		this.natInsNo = nin;
		this.dob = dob;
		this.Address = address;
		this.Postcode = postcode;
		this.employeeImage = anImage;
	}

	public ImageIcon getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(ImageIcon employeeImage) {
		this.employeeImage = employeeImage;
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
package adv_progr_assignment;
// Alfonso Leone 15002679

/**
 * The EmployeeDAO class is the data access object (DAO) that provides an
 * interface to the SQLite database
 *
 * @author Alfonso Leone
 * @version 1.0
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EmployeeDAO {
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultset = null;

	/**
	 * gets the connection from the database
	 * @return a connection from the database
	 */
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:empdb.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	/**
	 * Selects all the employees in the database and returns an Employee list with all the employees
	 * @return an ArrayList of Employee instances
	 * @throws SQLException
	 */
	public ArrayList<Employee> selectAllEmployees() throws SQLException
	{

		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		String query = "SELECT * FROM employees;";
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {

				Employee emp = new Employee();
				emp.setId(resultset.getInt("ID"));
				emp.setName(resultset.getString("Name"));
				emp.setGender(resultset.getString("Gender").charAt(0));
				emp.setDob(resultset.getString("DOB"));
				emp.setAddress(resultset.getString("Address"));
				emp.setPostcode(resultset.getString("Postcode"));
				emp.setNatInsNo(resultset.getString("NIN"));
				emp.setJobTitle(resultset.getString("JobTitle"));
				emp.setStartDate(resultset.getString("StartDate"));
				emp.setSalary(resultset.getString("Salary"));
				emp.setEmail(resultset.getString("Email"));
				try {
					emp.setEmployeeImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultset.getBytes("Image"))));
				}
				catch (NullPointerException e){}
				employees.add(emp);
				System.out.println("added");
			}


			System.out.println(" ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return employees;
	}

	/**
	 * Inserts an employee in the database
	 * @param anEmployee
	 * @return true if the operation succeed, false otherwise
	 */
	public static boolean insertEmployee(Employee anEmployee)
	{
		try {
			//int id = anEmployee.getId();
			String name = anEmployee.getName();
			char gender = anEmployee.getGender();
			String dob = anEmployee.getDob();
			String address = anEmployee.getAddress();
			String postcode = anEmployee.getPostcode();
			String nin = anEmployee.getNatInsNo();
			String jobTitle = anEmployee.getJobTitle();
			String startDate = anEmployee.getStartDate();
			String salary = anEmployee.getSalary();
			String email = anEmployee.getEmail();

			Class.forName("org.sqlite.JDBC");
			connection = getDBConnection();
			connection.setAutoCommit(false);
			System.out.println("Insert operation -database successfully opened");
			PreparedStatement s;
			s = connection.prepareStatement("INSERT INTO employees (Name,Gender,Dob,Address,Postcode,NIN,JobTitle,StartDate,Salary,Email) VALUES (?,?,?,?,?,?,?,?,?,?)");
			s.setString(1, name);
			s.setString(2, String.valueOf(gender));
			s.setString(3, dob);
			s.setString(4, address);
			s.setString(5, postcode);
			s.setString(6, nin);
			s.setString(7, jobTitle);
			s.setString(8, startDate);
			s.setString(9, salary);
			s.setString(10, email);
			s.execute();
			s.close();
			connection.commit();
			connection.close();
			System.out.println("Records successfully created");
			System.out.println("");
			return true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}

	}

	/**
	 * Selects an employee from the database by name and returns a string with
	 * all the employee information
	 * @param aName
	 * @return a string made of property separated by the character '-'
	 * @throws SQLException
	 */
	public String selectEmployeeByName(String aName) throws SQLException
	{
		String query = "SELECT * FROM employees WHERE Name = '" + aName + "'; ";
		String result = null;
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				String id = Integer.toString(resultset.getInt("ID"));
				String name = resultset.getString("Name");
				String gender = Character.toString(resultset.getString("Gender").charAt(0));
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				String nin = resultset.getString("NIN");
				String jobtitle = resultset.getString("JobTitle");
				String startdate = resultset.getString("StartDate");
				String salary = resultset.getString("Salary");
				String email = resultset.getString("Email");
				result = id + "-" + name + "-" + gender + "-" + dob + "-" + address + "-" + postcode + "-" + nin + "-" + jobtitle + "-" + startdate + "-" + salary + "-" + email;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
			System.out.println("");
		}
		return result;

	}

	/**
	 * Selects an employee image from the database. It has to be used with the method
	 * selectEmployeeByName in order to get all the employee information and the image
	 * @param aName
	 * @return an employee image
	 * @throws SQLException
	 */
	public ImageIcon selectEmployeeImageByName(String aName) throws SQLException
	{
		ImageIcon employeeImage =  null;

		String query = "SELECT * FROM employees WHERE Name = '" + aName + "'; ";
		try
		{
				connection = getDBConnection();
				statement = connection.createStatement();
				System.out.println(query);
				resultset = statement.executeQuery(query);
			while (resultset.next())
			{
				try
				{
					employeeImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultset.getBytes("Image")));
				}
				catch (NullPointerException e) {}
			}

			return employeeImage;
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return employeeImage;

	}

	/**
	 * Update the information of an employee at a given id
	 * @param anEmployee
	 * @param anID
	 * @return true if the operation succeeds false otherwise
	 */
	public static boolean insertEmployeeAtID(Employee anEmployee, String anID)
	{
		try {
			String name = anEmployee.getName();
			char gender = anEmployee.getGender();
			String dob = anEmployee.getDob();
			String address = anEmployee.getAddress();
			String postcode = anEmployee.getPostcode();
			String nin = anEmployee.getNatInsNo();
			String jobTitle = anEmployee.getJobTitle();
			String startDate = anEmployee.getStartDate();
			String salary = anEmployee.getSalary();
			String email = anEmployee.getEmail();

			Class.forName("org.sqlite.JDBC");
			connection = getDBConnection();
			connection.setAutoCommit(false);
			System.out.println("Update operation -database successfully opened");
			PreparedStatement s;
			s = connection.prepareStatement("UPDATE employees SET Name = ?, Gender = ?, DOB = ?, Address = ?, Postcode = ?, NIN = ?, JobTitle = ?, StartDate = ?, Salary = ?, email = ? WHERE ID = ?");
			s.setString(1, name);
			s.setString(2, String.valueOf(gender));
			s.setString(3, dob);
			s.setString(4, address);
			s.setString(5, postcode);
			s.setString(6, nin);
			s.setString(7, jobTitle);
			s.setString(8, startDate);
			s.setString(9, salary);
			s.setString(10, email);
			s.setString(11, anID);
			s.executeUpdate();
			s.close();
			connection.commit();
			connection.close();
			System.out.println("Records successfully updated");
			System.out.println("");
			return true;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}

	}

	/**
	 * Deletes an employee at a specific given id
	 * @param id
	 * @return true if the operation succeeds false otherwise
	 */
	public static boolean deleteEmployeeById(String id)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = getDBConnection();
			connection.setAutoCommit(false);
			System.out.println("Insert operation -database successfully opened");
			PreparedStatement s;
			s = connection.prepareStatement("DELETE FROM employees WHERE ID = ?");
			s.setString(1, id);
			s.executeUpdate();
			s.close();
			connection.commit();
			connection.close();

			return true;

		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}


	}

	
	
}  // end of class
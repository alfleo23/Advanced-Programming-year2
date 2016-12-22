package adv_progr_assignment;

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

	public ArrayList<Employee> selectAllEmployees() throws SQLException {

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

	public static void insertEmployee(Employee anEmployee)
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
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records successfully created");
		System.out.println("");
	}

	public static void selectEmployeeByName(String aName) throws SQLException {
		String query = "SELECT * FROM employees WHERE Name = '"+aName+"'; ";
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				System.out.print(resultset.getString("ID") + "\t");
				System.out.print(resultset.getString("name") + "\t");
				System.out.print(resultset.getString("address") + "\t");
				System.out.println(resultset.getString("postcode") + "\t");
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

	}


	public static void insertEmployeeAtID(Employee anEmployee, String anID)
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
			Class.forName("org.sqlite.JDBC");
			connection = getDBConnection();
			connection.setAutoCommit(false);
			System.out.println("Update operation -database successfully opened");
			PreparedStatement s;


		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records successfully updated");
		System.out.println("");
	}

	
	
}  // end of class
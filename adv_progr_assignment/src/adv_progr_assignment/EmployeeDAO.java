package adv_progr_assignment;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				int id = resultset.getInt("ID");
				String name = resultset.getString("Name");
				char gender = resultset.getString("Gender").charAt(0);
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				String nin = resultset.getString("NIN");
				String jobTitle = resultset.getString("JobTitle");
				String startDate = resultset.getString("StartDate");
				String salary = resultset.getString("Salary");
				String email = resultset.getString("Email");
				ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(resultset.getBytes("Image")));
				Employee emp = new Employee(id, name, gender, nin, dob, address, postcode, salary, startDate, jobTitle, email, image);
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
	
	
	public static void insertEmployee(Employee anEmployee)
	{
		try {
			int id = anEmployee.getId();
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
			connection = DriverManager
					.getConnection("jdbc:sqlite:empdb.sqlite");
			connection.setAutoCommit(false);
			System.out
					.println("Insert operation -database successfully opened");
			statement = connection.createStatement();
			String sql = "INSERT INTO employees (ID,Name,Gender,Dob,Address,Postcode,NIN,JobTitle,StartDate,Salary,Email)"
					+ "VALUES ('"+id+"','"+name+"','"+gender+"','"+dob+"',"
							+ "'"+address+"','"+postcode+"','"+nin+"','"+jobTitle+"',"
									+ "'"+startDate+"','"+salary+"','"+email+"');";
			statement.executeUpdate(sql);
			statement.close();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records successfully created");
		System.out.println("");
	}
	
	
//	public static void insertEmployeeAtID(Employee anEmployee, String anID)
//	{
//		try {
//			String id = anEmployee.getId();
//			String name = anEmployee.getName();
//			char gender = anEmployee.getGender();
//			String dob = anEmployee.getDob();
//			String address = anEmployee.getAddress();
//			String postcode = anEmployee.getPostcode();
//			String nin = anEmployee.getNatInsNo();
//			String jobTitle = anEmployee.getTitle();
//			String startDate = anEmployee.getStartDate();
//			String salary = anEmployee.getSalary();
//			String email = anEmployee.getEmail();
//			
//			Class.forName("org.sqlite.JDBC");
//			connection = DriverManager
//					.getConnection("jdbc:sqlite:empdb.sqlite");
//			connection.setAutoCommit(false);
//			System.out
//					.println("Insert operation -database successfully opened");
//			statement = connection.createStatement();
//			String sql = "UPDATE employees SET Name = '"+name+"', 
//					
//			statement.executeUpdate(sql);
//			statement.close();
//			connection.commit();
//			connection.close();
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
//		}
//		System.out.println("Records successfully created");
//		System.out.println("");
//	}

	
	
}  // end of class
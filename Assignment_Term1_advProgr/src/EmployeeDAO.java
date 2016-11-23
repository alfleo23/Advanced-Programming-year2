import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public static void selectAllEmployees() throws SQLException {
		String query = "SELECT * FROM employees;";
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
			String id = anEmployee.getId();
			String name = anEmployee.getName();
			char gender = anEmployee.getGender();
			String dob = anEmployee.getDob();
			String address = anEmployee.getAddress();
			String postcode = anEmployee.getPostcode();
			String nin = anEmployee.getNatInsNo();
			String jobTitle = anEmployee.getTitle();
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

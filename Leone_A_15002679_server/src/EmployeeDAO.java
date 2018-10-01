
import java.sql.*;
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
			String dbURL = "jdbc:sqlite:EmployeesDatabase.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public static ArrayList<Employee> showAllRecords() throws SQLException
	{

		ArrayList<Employee> employees = new ArrayList<Employee>();

		String query = "SELECT * FROM EMPLOYEE;";
		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {

				Employee emp = new Employee();
				emp.setName(resultset.getString("Name"));
				emp.setGender(resultset.getString("Gender"));
				emp.setDob(resultset.getString("DOB"));
				emp.setAddress(resultset.getString("Address"));
				emp.setPostcode(resultset.getString("PostCode"));
				emp.setNin(resultset.getString("NIN"));
				emp.setSalary(resultset.getString("Salary"));
				emp.setJobTitle(resultset.getString("JobTitle"));
				emp.setStartDate(resultset.getString("StartDate"));
				emp.setEmail(resultset.getString("Email"));
				employees.add(emp);
				System.out.println("Employee added to list");
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

	public static boolean insertEmployee(Employee emp) throws ClassNotFoundException, SQLException {
		
		try {
			String name = emp.getName();
			String gender = emp.getGender();
			String dob = emp.getDob();
			String address = emp.getAddress();
			String postcode = emp.getPostcode();
			String nin = emp.getNin();
			String salary = emp.getSalary();
			String jobTitle = emp.getJobTitle();
			String startDate = emp.getStartDate();
			String email = emp.getEmail();

			Class.forName("org.sqlite.JDBC");
			connection = getDBConnection();
			connection.setAutoCommit(false);
			System.out.println("Insert operation -database successfully opened");
			PreparedStatement s;
			s = connection.prepareStatement("INSERT INTO Employee (Name, Gender, DOB, Address, PostCode, NIN, Salary, JobTitle, StartDate, Email) VALUES (?,?,?,?,?,?,?,?,?,?)");
			s.setString(1, name);
			s.setString(2, gender);
			s.setString(3, dob);
			s.setString(4, address);
			s.setString(5, postcode);
			s.setString(6, nin);
			s.setString(7, salary);
			s.setString(8, jobTitle);
			s.setString(9, startDate);
			s.setString(10, email);
			s.execute();
			s.close();
			connection.commit();
			connection.close();
			System.out.println("Record successfully created");
			System.out.println("");
			return true;
		}catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
	}

}
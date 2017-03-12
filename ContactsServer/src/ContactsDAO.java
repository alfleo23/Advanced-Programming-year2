/**
 * Created by alfonsoleone on 03/03/17.
 */
import java.sql.*;
import java.util.ArrayList;

public class ContactsDAO {

	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultset = null;

	private static Statement getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:ContactsTest.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			statement = dbConnection.createStatement();
			return statement;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return statement;
	}

	public static ArrayList<Contact> selectAllContacts() throws SQLException
	{

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		String query = "SELECT * FROM contacts;";
		try {
			statement = getConnection();
			System.out.println(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {

				Contact cont = new Contact();
				cont.setName(resultset.getString("Name"));
				cont.setEmail(resultset.getString("Email"));
				contacts.add(cont);
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
		return contacts;
	}


}

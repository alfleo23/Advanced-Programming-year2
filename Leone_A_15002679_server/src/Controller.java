import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alfonsoleone on 03/03/17.
 */
public class Controller {


	public static void main(String[] args) throws SQLException, IOException {

		Gson gson = new Gson();
		ArrayList<Employee> employeesInformation = EmployeeDAO.showAllRecords();
		//TODO create a new arraylist of employee every http request


		HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);
		server.createContext("/", new HttpHandler() {
			@Override
			public void handle(HttpExchange he) throws IOException {

				he.sendResponseHeaders(200, 0);
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
				String myJson = gson.toJson(employeesInformation);
				out.write(myJson);
				out.close();
			}
		});

		server.createContext("/add_emp", new HttpHandler() {
			@Override
			public void handle(HttpExchange he) throws IOException {

				he.sendResponseHeaders(200, 0);
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

				out.write("<html><head>" +
						"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\"/>" +
						"</head><body>" +
						"<h3>Add Employee Form</h3>");
				out.write("<form method=\"POST\" action=\"/process_emp\">\n" +
						"  Name:<br>\n" +
						"  <input type=\"text\" name=\"name\">\n" +
						"  <br><br>\n" +
						"  Gender:<br>\n" +
						"  <input type=\"text\" name=\"gender\">\n" +
						"  <br><br>\n" +
						"  Date of Birth:<br>\n" +
						"  <input type=\"text\" name=\"dob\">\n" +
						"  <br><br>\n" +
						"  Address:<br>\n" +
						"  <input type=\"text\" name=\"address\">\n" +
						"  <br><br>\n" +
						"  Postcode:<br>\n" +
						"  <input type=\"text\" name=\"postcode\">\n" +
						"  <br><br>\n" +
						"  NIN:<br>\n" +
						"  <input type=\"text\" name=\"nin\">\n" +
						"  <br><br>\n" +
						"  Salary:<br>\n" +
						"  <input type=\"text\" name=\"salary\">\n" +
						"  <br><br>\n" +
						"  Job Title:<br>\n" +
						"  <input type=\"text\" name=\"jobTitle\">\n" +
						"  <br><br>\n" +
						"  Start Date:<br>\n" +
						"  <input type=\"text\" name=\"startDate\">\n" +
						"  <br><br>\n" +
						"  Email:<br>\n" +
						"  <input type=\"text\" name=\"email\">\n" +
						"  <br><br>\n" +
						"  <input type=\"submit\" value=\"Submit\">\n" +
						"</form> ");
				out.write("</body></html>");
				out.close();

			}
		});

		server.createContext("/process_emp", new HttpHandler() {
			@Override
			public void handle(HttpExchange he) throws IOException {

				HashMap<String,String> post = new HashMap<String,String>();
				//read the request body
				BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
				String line = "";
				String request = "";
				while((line = in.readLine())!= null) {
					request = request + line;
				}

				System.out.println(request);
				//individual key=value pairs are delimited by ampersands.
				String[] pairs = request.split("&");
				for(int i=0; i<pairs.length; i++) {
					//each key=value pair is separated by an equals. Both halves require URL decoding.
					String pair = pairs[i];
					post.put(URLDecoder.decode(pair.split("=")[0],"UTF-8"),URLDecoder.decode(pair.split("=")[1],"UTF-8"));
				}

				String name = post.get("name");
				String gender = post.get("gender");
				String dob = post.get("dob");
				String address = post.get("address");
				String postcode = post.get("postcode");
				String nin = post.get("nin");
				String salary = post.get("salary");
				String jobTitle = post.get("jobTitle");
				String startDate = post.get("startDate");
				String email = post.get("email");

				Employee emp = new Employee(name, gender, dob, address, postcode, nin, salary, jobTitle, startDate, email);
				try {
					EmployeeDAO.insertEmployee(emp);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
				he.sendResponseHeaders(200, 0);
				out.write("Record successfully added :)");
				out.close();

			}
		});

		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("The server is up and running on port 8005");

	}


}

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alfonsoleone on 03/03/17.
 */
public class Controller {


	public static void main(String[] args) throws SQLException, IOException {

		Gson gson = new Gson();
		ArrayList<Contact> contacts = ContactsDAO.selectAllContacts();
//
//		for (Contact c:contacts) {
//			System.out.println("name: "+ c.getName() + " Email: "+ c.getEmail());
//		}

		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/", new HttpHandler() {
			@Override
			public void handle(HttpExchange he) throws IOException {

				he.sendResponseHeaders(200, 0);
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
//				for (Contact c: contacts) {
//					out.write("<html><head></head><body>");
//					out.write("name: " + c.getName() + " email: " + c.getEmail() +"<br>");
//					out.write("</body></html>");
//				}
				String myJson = gson.toJson(contacts);
				out.write("<html><head></head><body>");
				out.write(myJson);
				out.write("</body></html>");
				out.close();
			}
		});
		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("The server is up and running");

	}


}

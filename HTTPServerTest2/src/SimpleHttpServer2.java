import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
public class SimpleHttpServer2 {
	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/info", new InfoHandler());
		server.createContext("/get", new GetHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("The server is up and running on port 8000");
	}
	// http://localhost:8000/info
	static class InfoHandler implements HttpHandler {
		public void handle(HttpExchange httpExchange) throws IOException {
			String response = "Use /get?firstname=Alan&lastname=Crispin to see how to handle url parameters";
			SimpleHttpServer2.writeResponse(httpExchange, response.toString());
		}
	}
	// http://localhost:8000/get?fisrtname=Alan&lastname=Crispin
	static class GetHandler implements HttpHandler {
		public void handle(HttpExchange httpExchange) throws IOException {
			StringBuilder response = new StringBuilder();
			Map <String,String>parms =
					SimpleHttpServer2.queryToMap(httpExchange.getRequestURI().getQuery());
			response.append("<html><body>");
			response.append("Forename : " + parms.get("firstname") + "<br/>");
			response.append("Surname : " + parms.get("lastname") + "<br/>");
			response.append("</body></html>");
			SimpleHttpServer2.writeResponse(httpExchange, response.toString());
		}
	}
	public static void writeResponse(HttpExchange httpExchange, String response)
			throws IOException {
		httpExchange.sendResponseHeaders(200, response.length());
		OutputStream os = httpExchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	/**
	 * returns the URL parameters in a HashMap
	 * @param query (?) string parameters
	 * @return map
	 */
	public static Map<String, String> queryToMap(String query){
		Map<String, String> result = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=");
			if (pair.length>1) {
				result.put(pair[0], pair[1]);
			}else{
				result.put(pair[0], "");
			}
		}
		return result;
	}
}
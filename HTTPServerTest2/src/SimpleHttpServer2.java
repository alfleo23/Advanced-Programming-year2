import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;
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
			String response = "Use /get to download the file test.pdf from the specified path";
			SimpleHttpServer2.writeResponse(httpExchange, response.toString());
		}
	}

	// http://localhost:8000/get?fisrtname=Alan&lastname=Crispin
	static class GetHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			// Add the required response header for a PDF file
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/pdf");
			// provide a PDF file (you must specify your own path)
			File file = new File("/Users/alfonsoleone/Desktop/Task_2_Disk_Space_Drama.pdf");
			byte [] bytearray = new byte [(int)file.length()];
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(bytearray, 0, bytearray.length);
			//Send the response.
			t.sendResponseHeaders(200, file.length());
			OutputStream os = t.getResponseBody();
			os.write(bytearray,0,bytearray.length);
			os.close();
			bis.close();
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
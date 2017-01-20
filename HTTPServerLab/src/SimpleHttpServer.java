import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
/*
 * httpserver
*/
public class SimpleHttpServer {
	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/info", new MyHandler());
		server.setExecutor(null); // default implementation of threading
		server.start();
		System.out.println("The server is up and running on port 8000");
	}
	static class MyHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "Welcome to HttpServer";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
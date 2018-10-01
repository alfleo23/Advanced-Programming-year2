import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
public class Controller {
	public static void main(String[] args) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
			server.createContext("/", new HttpHandler() {
				@Override
				public void handle(HttpExchange he) throws IOException {
					//output HTML form
					he.sendResponseHeaders(200, 0);
					BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
					out.write("<html><head></head><body><form method=\"POST\" action=\"/calc\">");
					out.write("First Number:<input name=\"n1\"><br>");
					out.write("Second Number:<input name=\"n2\"><br>");
					out.write("<input type=\"submit\" value=\"Multiply\">");
					out.write("</form></body></html>");
					out.close();
				}
			});

			server.createContext("/calc",new HttpHandler() {
				//process data from the form
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
					//Should have a HashMap of posted data in our "post" variable. Now calculate
					int num1 = Integer.parseInt(post.get("n1"));
					int num2 = Integer.parseInt(post.get("n2"));
					int result = num1*num2;
					BufferedWriter out = new BufferedWriter(new
							OutputStreamWriter(he.getResponseBody()));
					out.write("Result = ");
					out.write(String.valueOf(result));
					he.sendResponseHeaders(200, 0); //HTTP 200 (OK)
					out.close();
				}
			});
//actually start the server
			server.start();
			System.out.println("The server is up and running on port 8000");
		}
		catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
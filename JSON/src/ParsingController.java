import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by alfonsoleone on 02/03/17.
 */
public class ParsingController {


	public static void main(String[] args) {
		String myJson = "[{\"name\":\"Mohammed Kaleem\",\"email\":\"m.kaleem@mmu.ac.uk\"},{\"name\":\"Alan Crispin\",\"email\":\"a.crispin@mmu.ac.uk\"},{\"name\":\"Keeley Crockket\",\"email\":\"k.crokket@mmu.ac.uk\"}]\r\n";
		JsonParser jsonParser = new JsonParser();
		System.out.println(myJson);
		JsonArray empsArray = jsonParser.parse(myJson).getAsJsonArray();
		System.out.println("json array size: "+empsArray.size());
		for (JsonElement je : empsArray) { // loop over the json array

			JsonObject emp = je.getAsJsonObject();
			String name = emp.get("name").getAsString();
			String email = emp.get("name").getAsString();
			System.out.println("Name:"+name + " email: " + email);
		}
	}
}

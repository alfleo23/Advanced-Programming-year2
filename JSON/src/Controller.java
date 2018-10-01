import com.google.gson.Gson;

import java.util.*;

/**
 * Created by alfonsoleone on 02/03/17.
 */
public class Controller {


	public static void main(String[] args) {
		Gson gson = new Gson();
		ArrayList<Contact> allContacts = new ArrayList<>();

		Contact kaleem = new Contact("Mohammed Kaleem", "m.kaleem@mmu.ac.uk");
		Contact alan = new Contact("Alan Crispin", "a.crispin@mmu.ac.uk");
		Contact keeley = new Contact("Keeley Crockket", "k.crokket@mmu.ac.uk");

		allContacts.add(kaleem);
		allContacts.add(alan);
		allContacts.add(keeley);


		String myJson = gson.toJson(allContacts);
		System.out.println(myJson);
	}
}

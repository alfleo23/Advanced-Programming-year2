/**
 * Created by alfonsoleone on 02/03/17.
 */
public class Contact {

	private String name;
	private String email;

	Contact(String aName, String anEmail){
		this.name = aName;
		this.email = anEmail;
	}

	Contact(){


	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

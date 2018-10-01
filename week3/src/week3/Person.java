package week3;

public class Person 
{
	 private String name;
	 private String address;
	 private int phoneNumber;
	 private String emailAddress;

	 public Person()
	 {
		 this.name = "unknown";
		 this.address = "unknown";
		 this.phoneNumber = 0000000;
		 this.emailAddress = "unknown";
	 }
	 public Person(String newName, String newAddress, int newPhoneNumber,
	 String newEmail)
	 {
		 this.name = newName;
		 this.address = newAddress;
		 this.phoneNumber = newPhoneNumber;
		 this.emailAddress = newEmail;
	 }
	 
	 
	 
	 public void setName(String newName)
	 {
		 this.name = newName;
	 }
	 
	 public String getName()
	 {
		 return this.name;
	 }
	 
	 public void setAddress(String newAddress)
	 {
		 this.address = newAddress;
	 }
	 
	 public String getAddress()
	 {
		 return this.address;
	 }
	 
	 public void setPhone(int newPhoneNumber)
	 {
		 this.phoneNumber = newPhoneNumber;
	 }
	 
	 public int getPhone()
	 {
		 return this.phoneNumber;
	 }
	 
	 public void setEmail(String newEmail)
	 {
		 this.emailAddress = newEmail;
	 }
	 
	 public String getEmail()
	 {
		 return this.emailAddress;
	 }
	 
	 public String toString()
	 {
		 return "Name :"+getName()+" Email: "+getEmail() + " phone:" + getPhone() + " address:" + getAddress();
	 }
}

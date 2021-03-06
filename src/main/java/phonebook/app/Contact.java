package phonebook.app;

public class Contact {

	private int contactID;
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;
	private int userID;

	public Contact(int contactID, String firstName, String lastName, String email, int phoneNumber, int userID) {
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userID = userID;
	}

	public Contact(int contactID, String firstName,int phoneNumber) {
		this.contactID = contactID;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
}

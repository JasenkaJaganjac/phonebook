package phonebook.app;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ContactDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();
	private Scanner input;

	public void addContact(User user) throws SQLException {

		String query = "INSERT INTO contactss(firstname, lastname, email,phoneNumber, userId) VALUES(?,?,?,?,?)";

		System.out.println("Enter firstname: ");
		String firstname = input.nextLine();

		System.out.println("Enter lastname: ");
		String lastname = input.nextLine();

		System.out.println("Enter email: ");
		String email = input.nextLine();

		System.out.println("Enter phoneNumber: ");
		String phoneNumber = input.nextLine();

		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, email);
			statement.setString(4, phoneNumber);
			statement.setInt(5, user.getUserID());

			statement.execute();
			System.out.println("Contact successufully added.");
		}
	}
	
	
	
	public void editContact(Contact contact) throws SQLException {
		String query = "UPDATE contact SET firstname = ?, lastname = ?, phoneNumber = ?,phoneNumber = ? WHERE contactId = ?";

		input = new Scanner(System.in);

		System.out.println("Enter new firstname: ");
		String newFirstname = input.nextLine();

		System.out.println("Enter new lastname: ");
		String newLastname = input.nextLine();

		System.out.println("Enter new email: ");
		String newEmail = input.nextLine();
		
		System.out.println("Enter new phone number: ");
		String newPhoneNumber = input.nextLine();

		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, newFirstname);
			statement.setString(2, newLastname);
			statement.setString(3, newEmail);
			statement.setString(4, newPhoneNumber);
			statement.setInt(5, contact.getContactID());

			statement.execute();

			System.out.println("Successfully updated.");
		}

	}
	
	public void deleteContact(Contact contact) throws SQLException {

		String query = "DELETE FROM contact WHERE contactId = ?";

		try (PreparedStatement statement = conn.prepareStatement(query)) {

			statement.setInt(1, contact.getContactID());

			statement.execute();

			System.out.println("contact deleted.");
		}
	}
	
}

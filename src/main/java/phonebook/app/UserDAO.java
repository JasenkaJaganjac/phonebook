package phonebook.app;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();
	private java.util.Scanner input;

	public void addUser() throws SQLException {
		String query = "INSERT INTO users (username,password) VALUES (?,?)";

		input = new Scanner(System.in);

		System.out.println("Enter username: ");
		String username = input.nextLine();

		System.out.println("Enter password: ");
		String password = input.nextLine();

		
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);
			

			statement.execute();
			System.out.println("Successfully registered!");
		}

	}
	
	public User logIn() throws SQLException {
		User user = new User();

		input = new java.util.Scanner(System.in);

		System.out.println("Enter username: ");
		String username = input.nextLine();

		System.out.println("Enter password: ");
		String password = input.nextLine();

		String query = "SELECT * FROM users WHERE username = ? AND password = ?";

		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			
				System.out.println("Successfully loged in!");
			}
		}

		return user;
	}
	
	
	
}

package phonebook.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhonebookTest {
	static Scanner input = new Scanner(System.in);

	public static int isInteger() {
		while (true) {
			try {
				return input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("pogresan unos.");
				input.nextInt();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		UserDAO userDAO=new UserDAO();
	
		
				int option = -1;
		do {
			System.out.println("Choose 1 , 2 or 0");
			System.out.println("1- log in 2 -  sign up  0 - EXIT ");
			option = isInteger();
			switch (option) {
			case 1:
				User user=userDAO.logIn();
				if (user.getUserID() != 0) {
					System.out.println("izaberi opcije");
					//userDAO.options(user);
				} else {
					System.out.println("Wrong username or password.");
				}
				break;
			
			
			case 2:
				userDAO.addUser();;
				break;
			case 0:
				ConnectionManager.getInstance().close();
				input.close();
				break;
			default:
				System.out.println("wrong input.");
			}
		} while (option != 0);

		
		
	}
	
	
}

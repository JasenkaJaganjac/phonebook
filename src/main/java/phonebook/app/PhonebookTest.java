package phonebook.app;

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

	public static void main(String[] args) {
		int option = -1;
		do {
			System.out.println("Choose 1 , 2 or 0");
			System.out.println("1- log in 2 -  sign up  0 - EXIT ");
			option = isInteger();
			switch (option) {
			case 1:
				logIn();
				break;
			case 2:
				signUp();
				break;
			case 0:
				break;
			default:
				System.out.println("wrong input.");
			}
		} while (option != 0);

		
		
	}
	
	//metode implemenirati
	public static void logIn() { }
	public static void signUp() { }

}

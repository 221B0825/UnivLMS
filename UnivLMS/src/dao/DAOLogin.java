package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAOLogin {
	private String userId;
	private String password;

	private void read(Scanner scanner) {
		this.userId = scanner.next();
		this.password = scanner.next();
	}

	public boolean authenticate(String userId, String password) throws FileNotFoundException, InvalidUserException {

//		Scanner scanner = new Scanner(new File("data//login.txt"));
		Scanner scanner = new Scanner(new File("login/login"));
		while (scanner.hasNext()) {
			this.read(scanner);
			if (this.userId.equals(userId) && this.password.equals(password)) {
				scanner.close();
				return true;

			}
		}
		scanner.close();
		InvalidUserException invalidUserException = new InvalidUserException();
		throw invalidUserException;

	}

	public class InvalidUserException extends Exception {

		public InvalidUserException() {
			super("잘못된 사용자 입니다.");
			System.out.println("잘못된 사용자 입니다.");
		}
	}

}

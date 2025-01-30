package view;
import java.io.FileNotFoundException;
import java.util.Scanner;

import control.CLogin;
import dao.DAOLogin.InvalidUserException;

public class VLogin {
	//components
	private CLogin cLogin;
	

	public VLogin() {
		this.cLogin = new CLogin();
		
	}

	public String authenticate() throws FileNotFoundException, InvalidUserException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("아이디: ");
		String userId = scanner.next();
		System.out.print("비밀번호: ");
		String password = scanner.next();
		
//		scanner.close();
		
		try {
			this.cLogin.authenticate(userId, password);
			return userId;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (InvalidUserException e) {
			e.printStackTrace();
			return null;
		}

	}
}

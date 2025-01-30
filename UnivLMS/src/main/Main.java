package main;
import java.io.FileNotFoundException;
import java.io.IOException;

import dao.DAOLogin.InvalidUserException;
import view.VLogin;
import view.VSugangSincheong;

public class Main {
	//components
	private VLogin vLogin;
	private VSugangSincheong vSugangSincheong;
	// Constructor
	public Main() {
		this.vLogin = new VLogin();
	}
	
	
	private void show() throws InvalidUserException, IOException {
		String userId = this.vLogin.authenticate();
		if(userId != null) {
		this.vSugangSincheong = new VSugangSincheong();	
		this.vSugangSincheong.show(userId);
		}
	}
	
	public static void main(String[] args) throws InvalidUserException, IOException {
		// memory allocation & invoke constructor
		Main main = new Main();
		main.show();

	}

}

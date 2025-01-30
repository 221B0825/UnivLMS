package control;
import java.io.FileNotFoundException;

import dao.DAOLogin;
import dao.DAOLogin.InvalidUserException;

public class CLogin {

	private DAOLogin daoLogin;

	public CLogin() {
		daoLogin = new DAOLogin();
	}

	// ELogin. - ELogin 안에 있는 Class 사용 시
	public boolean authenticate(String userId, String password)
			throws FileNotFoundException, InvalidUserException {
		
		boolean validUser = daoLogin.authenticate(userId,password);
		return validUser;

	}

}

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import ui.LoginMessageFailFrame;
import ui.LoginFrame;
import ui.LoginMessageSuccessFrame;
import ui.LogoutFrame;
import ui.MainFrame;

public class Main {
	// components
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	private LoginMessageSuccessFrame loginMessageSuccessFrame;
	private LoginMessageFailFrame loginMessageFailFrame;
	private LogoutFrame logoutFrame;
	
	private boolean validUser;
	private String userId;
	
	private ActionHandler actionHandler;
	private LoginActionHandler loginActionHandler;
	private LogoutButtonActionHandler logoutButtonActionHandler;
	private LogoutContinueActionHandler logoutContinueActionHandler;
	private LogoutCancelActionHandler logoutCancelActionHandler;

	// Constructor
	public Main() throws FileNotFoundException {
		this.actionHandler = new ActionHandler();
		this.loginActionHandler = new LoginActionHandler();
		this.logoutButtonActionHandler = new LogoutButtonActionHandler();
		this.logoutContinueActionHandler = new LogoutContinueActionHandler();
		this.logoutCancelActionHandler = new LogoutCancelActionHandler();

		this.loginFrame = new LoginFrame(this.actionHandler);
		this.loginMessageSuccessFrame = new LoginMessageSuccessFrame(this.loginActionHandler);
		this.loginMessageFailFrame = new LoginMessageFailFrame(this.loginActionHandler);
		this.logoutFrame = new LogoutFrame(this.logoutContinueActionHandler,this.logoutCancelActionHandler);
	}
	public static void main(String[] args) throws IOException {
		// memory allocation & invoke constructor
		Main main = new Main();
		main.loginShow();
	}
	private void loginShow() throws FileNotFoundException {
		this.loginFrame.setVisible(true);
	}

	private void mainShow(String userId) throws FileNotFoundException {
		this.mainFrame = new MainFrame(userId ,this.logoutButtonActionHandler);
		this.mainFrame.setVisible(true);
		this.mainFrame.refresh(userId);
		
	}

	private void logoutShow() {
		this.logoutFrame.setVisible(true);
	}


	// 로그인 성공/실패 창 띄우기
	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
				validUser = loginFrame.loginPanel.authenticate(event);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			if (validUser) {
				loginFrame.dispose();
				userId = loginFrame.loginPanel.getUserId();
				try {
					mainShow(userId);
					loginMessageSuccessFrame.setVisible(true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				loginMessageFailFrame.setVisible(true);
			}
		}
	}

	// 로그인 성공/실패 창 닫기
	class LoginActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (validUser) {
				loginMessageSuccessFrame.dispose();
			} else {
				loginMessageFailFrame.dispose();

			}
		}
	}
	// 로그아웃 창 띄우기
	class LogoutButtonActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			logoutShow();
		}
	}
	// 로그아웃 창 닫고 로그인 창 띄우기
	class LogoutContinueActionHandler implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.dispose();
			logoutFrame.dispose();
			try {
				loginShow();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	// 로그아웃 취소하기
	class LogoutCancelActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			logoutFrame.dispose();
		}
	}


}
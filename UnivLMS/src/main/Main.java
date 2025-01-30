package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import ui.LoginFailMessageFrame;
import ui.LoginFrame;
import ui.LoginSuccessMessageFrame;
import ui.MainFrame;

public class Main {
	// components
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	private LoginSuccessMessageFrame loginSuccessMessageFrame;
	private LoginFailMessageFrame loginFailMessageFrame;
	private boolean validUser;
	private ActionHandler actionHandler;
	private LoginActionHandler loginActionHandler;

	// Constructor
	public Main() throws FileNotFoundException {
		this.actionHandler = new ActionHandler();
		this.loginActionHandler = new LoginActionHandler();
		this.loginFrame = new LoginFrame(this.actionHandler);
		this.loginSuccessMessageFrame = new LoginSuccessMessageFrame(this.loginActionHandler);
		this.loginFailMessageFrame = new LoginFailMessageFrame(this.loginActionHandler);
		this.mainFrame = new MainFrame();
	}

	private void loginShow() throws FileNotFoundException {
		this.loginFrame.setVisible(true);
	}

	private void mainShow() {
		this.mainFrame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		// memory allocation & invoke constructor
		Main main = new Main();
		main.loginShow();
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			validUser = loginFrame.loginPanel.authenticate(event);
			if (validUser) {
				loginFrame.dispose();
				loginSuccessMessageFrame.setVisible(true);
			} else {
				loginFailMessageFrame.setVisible(true);
			}
		}
	}

	class LoginActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (validUser) {
				loginSuccessMessageFrame.dispose();
				mainShow();
			} else {
				loginFailMessageFrame.dispose();

			}
		}
	}
}
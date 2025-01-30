package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public LoginPanel loginPanel;

	public LoginFrame(ActionListener actionHandler) throws FileNotFoundException {

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setLocation(100, 200);
		this.setSize(590, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.loginPanel = new LoginPanel(actionHandler);
		this.add(this.loginPanel);

	}

}

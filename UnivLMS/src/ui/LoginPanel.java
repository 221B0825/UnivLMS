package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.CLogin;
import main.Main;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel textPanel;
	private JPanel textFieldPanel;
	private JPanel buttonPanel;
	private JTextField userTextField;
	private JPasswordField passwordField;

	private String userId;
	private String password;

	// private ActionHandler actionHandler;

	private void read(Scanner scanner) {
		this.userId = scanner.next();
		this.password = scanner.next();
	}

	public LoginPanel(ActionListener actionHandler) {
		this.textPanel = new JPanel();
		this.textFieldPanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		this.setPreferredSize(new Dimension(580, 480));
		this.setBackground(Color.WHITE);

		// textPanel 설정
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		textPanel.setPreferredSize(new Dimension(120, 350));
		textPanel.setBackground(Color.WHITE);

		JLabel userText = new JLabel("아이디");
		JLabel passwordText = new JLabel("비밀번호");

		Font textFont = new Font("맑은 고딕", Font.BOLD, 20);
		userText.setFont(textFont);
		passwordText.setFont(textFont);

		// 여백 설정
		JPanel textBlank = new JPanel();
		textBlank.setPreferredSize(new Dimension(120, 262));
		textBlank.setBackground(Color.WHITE);

		textPanel.add(textBlank);
		textPanel.add(userText);
		textPanel.add(passwordText);

		this.add(textPanel);

		// textFieldPanel 설정
		textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		textFieldPanel.setPreferredSize(new Dimension(270, 370));
		textFieldPanel.setBackground(Color.white);

		JLabel icon = new JLabel(new ImageIcon("image\\명지대학교.jpg"));
		userTextField = new JTextField();
		passwordField = new JPasswordField();

		// Enter키로 Login
		userTextField.registerKeyboardAction(actionHandler, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		passwordField.registerKeyboardAction(actionHandler, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);

		userTextField.setPreferredSize(new Dimension(240, 30));
		passwordField.setPreferredSize(new Dimension(240, 30));

		Font font = new Font("맑은 고딕", Font.PLAIN, 20);
		userTextField.setFont(font);
		passwordField.setFont(font);

		// 여백 설정
		JPanel textFieldBlank = new JPanel();
		textFieldBlank.setPreferredSize(new Dimension(120, 10));
		textFieldBlank.setBackground(Color.WHITE);

		textFieldPanel.add(icon);
		textFieldPanel.add(textFieldBlank);
		textFieldPanel.add(userTextField);
		textFieldPanel.add(passwordField);

		this.add(textFieldPanel);

		// buttonPanel 설정
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonPanel.setPreferredSize(new Dimension(110, 350));
		buttonPanel.setBackground(Color.WHITE);

		JButton loginButton = new JButton("login");
		loginButton.setPreferredSize(new Dimension(110, 65));
		loginButton.setBackground(new Color(1, 41, 102));
		loginButton.addActionListener(actionHandler);

		Font buttonFont = new Font("Harlow Solid Italic", Font.PLAIN, 30);
		loginButton.setFont(buttonFont);
		loginButton.setForeground(Color.WHITE);

		// 여백 설정
		JPanel buttonBlank = new JPanel();
		buttonBlank.setPreferredSize(new Dimension(120, 260));
		buttonBlank.setBackground(Color.WHITE);

		buttonPanel.add(buttonBlank);
		buttonPanel.add(loginButton);
		this.add(buttonPanel);

	}

	public boolean authenticate(ActionEvent event) {

		String userId = userTextField.getText();
		String password = passwordField.getText();
		try {
			Scanner scanner = new Scanner(new File("login//login"));
			while (scanner.hasNext()) {
				this.read(scanner);
				if (this.userId.equals(userId) && this.password.equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}

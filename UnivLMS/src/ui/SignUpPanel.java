package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

// File file = new File("sincheon"+userId);
// if(!(file.extists)) {
// file.createNewFile()
// }

public class SignUpPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton signUpButton;
	
	public SignUpPanel() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT,50,0));
		this.setPreferredSize(new Dimension(580, 70));
		this.setBackground(Color.WHITE);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 18);
		
		this.signUpButton = new JButton("회원가입");
		signUpButton.setPreferredSize(new Dimension(110, 50));
		signUpButton.setBackground(new Color(1, 41, 102));
		signUpButton.setFont(font);
		signUpButton.setForeground(Color.WHITE);
		
		this.add(signUpButton);
		
	}
}

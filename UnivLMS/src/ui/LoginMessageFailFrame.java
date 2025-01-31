package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginMessageFailFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel failText;
	private JLabel failIcon;
	private JButton button;

	public LoginMessageFailFrame(ActionListener loginActionHandler) {

		// Frame 설정
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setLocation(225, 225);
		this.setSize(330, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel();
		this.failText = new JLabel("로그인 실패");
		this.failIcon = new JLabel(new ImageIcon("image//경고.PNG"));
		this.button = new JButton("확인");

		Font font = new Font("맑은 고딕", Font.PLAIN, 15);
		failText.setFont(font);
		button.setFont(font);
		
		button.setBackground(new Color(1,41,102));
		button.setForeground(Color.WHITE);

		// Panel 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
		panel.setPreferredSize(new Dimension(330, 170));
		panel.setBackground(Color.WHITE);

		JPanel iconPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel blankPanel = new JPanel();

		// iconPanel 설정
		iconPanel.setPreferredSize(new Dimension(100, 160));
		iconPanel.setBackground(Color.WHITE);
		iconPanel.add(failIcon);

		// textPanel 설정
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		textPanel.setPreferredSize(new Dimension(120, 160));
		textPanel.setBackground(Color.WHITE);
		textPanel.add(failText);
		textPanel.add(button);

		// blankPanel 설정
		blankPanel.setPreferredSize(new Dimension(100, 160));
		blankPanel.setBackground(Color.CYAN);

		panel.add(iconPanel);
		panel.add(textPanel);
		panel.add(blankPanel);

		this.add(panel);

		button.addActionListener(loginActionHandler);

	}
}

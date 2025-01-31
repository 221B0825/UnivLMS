package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entity.ELecture;
import ui.MainFrame.SincheongDeleteActionHandler;

public class SincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton sincheongButton;
	private JButton deleteButton;
	private SincheongTable sincheongTable;

	public SincheongPanel(ActionListener sincheongActionHandler, ActionListener sincheongDeleteActionHandler) {
		
		//SincheongPanel 설정
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		this.setPreferredSize(new Dimension(460, 1000));
		this.setBackground(Color.WHITE);
		
		Color color = new Color(1, 41, 102);
		Font font = new Font("맑은 고딕", Font.PLAIN, 18);
		
		// -------------------------------------------------------------------------------------------------
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		textPanel.setPreferredSize(new Dimension(460, 30));
		textPanel.setBackground(Color.WHITE);
		
		JLabel sincheongLabel = new JLabel("신청 목록");
		sincheongLabel.setFont(font);
		textPanel.add(sincheongLabel);

		this.add(textPanel);
		
		// -------------------------------------------------------------------------------------------------
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane = new JScrollPane();
		this.sincheongTable = new SincheongTable();
		scrollpane.setPreferredSize(new Dimension(460, 700));
		scrollpane.setViewportView(this.sincheongTable);
		this.add(scrollpane);
		
		// -------------------------------------------------------------------------------------------------
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		buttonPanel.setPreferredSize(new Dimension(460, 40));
		buttonPanel.setBackground(Color.WHITE);

		this.sincheongButton = new JButton("신청");
		sincheongButton.setFont(font);
		sincheongButton.setBackground(color);
		sincheongButton.setForeground(Color.WHITE);
		sincheongButton.addActionListener(sincheongActionHandler);
		
		JPanel buttonBlank = new JPanel();
		buttonBlank.setPreferredSize(new Dimension(100, 40));
		buttonBlank.setBackground(Color.WHITE);

		this.deleteButton = new JButton("삭제");
		deleteButton.setFont(font);
		deleteButton.setBackground(color);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.addActionListener(sincheongDeleteActionHandler);
		
		
		buttonPanel.add(sincheongButton);
		buttonPanel.add(buttonBlank);
		buttonPanel.add(deleteButton);

		this.add(buttonPanel);

	}

	public void addSincheongSelection(String userId, Vector<ELecture> sincheongSelection) throws IOException {
		sincheongTable.addSincheong(userId,sincheongSelection);

	}
	public void deleteSincheongSelection(String userId) throws IOException {
		sincheongTable.deleteSincheong(userId);
	}

	public void refresh(String userId) throws FileNotFoundException {
		sincheongTable.refresh(userId);
		
	}

}

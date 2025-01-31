package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.ELecture;

public class DirectoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private DirectoryList campusList;
	private DirectoryList collegeList;
	private DirectoryList departmentList;
	private JButton logoutButton;
	private LectureTable lectureTable;

	private ListSelectionHandler listSelectionHandler;

	public DirectoryPanel(String userId, ActionListener logoutButtonActionHandler) {
		// DirectoryPanel 설정
		this.listSelectionHandler = new ListSelectionHandler();
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setPreferredSize(new Dimension(500, 1000));
		this.setBackground(Color.WHITE);

		Font font = new Font("맑은 고딕", Font.PLAIN, 18);
		Font buttonFont = new Font("Harlow Solid Italic", Font.PLAIN, 30);

		// -------------------------------------------------------------------------------------------------

		// logoutPanel 설정
		JPanel logoutPanel = new JPanel();
		logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		logoutPanel.setPreferredSize(new Dimension(500, 40));
		logoutPanel.setBackground(Color.WHITE);

		JLabel userText = new JLabel("반갑습니다, " + userId + "님");
		userText.setFont(font);
		logoutPanel.add(userText);

		JPanel textBlank = new JPanel();
		textBlank.setPreferredSize(new Dimension(10, 30));
		textBlank.setBackground(Color.WHITE);

		this.logoutButton = new JButton("logout");
		logoutButton.setPreferredSize(new Dimension(110, 40));
		logoutButton.setBackground(new Color(1, 41, 102));
		logoutButton.setFont(buttonFont);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.addActionListener(logoutButtonActionHandler);

		logoutPanel.add(textBlank);
		logoutPanel.add(logoutButton);

		this.add(logoutPanel);

		// -------------------------------------------------------------------------------------------------

		// 리스트 설정
		JScrollPane scrollpane = new JScrollPane();
		this.campusList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.campusList);
		scrollpane.setPreferredSize(new Dimension(100, 270));
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.collegeList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.collegeList);
		scrollpane.setPreferredSize(new Dimension(180, 270));
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.departmentList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.departmentList);
		scrollpane.setPreferredSize(new Dimension(180, 270));
		this.add(scrollpane);

		// -------------------------------------------------------------------------------------------------

		// 강의 목록
		JPanel blank = new JPanel();
		blank.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		blank.setPreferredSize(new Dimension(500, 30));
		blank.setBackground(Color.WHITE);

		JLabel lectureText = new JLabel("강의 목록");
		lectureText.setFont(font);
		blank.add(lectureText);

		this.add(blank);
		// -------------------------------------------------------------------------------------------------

		scrollpane = new JScrollPane();
		this.lectureTable = new LectureTable();
		scrollpane.setViewportView(this.lectureTable);
		this.add(scrollpane);

		this.refresh(null);

	}

	public void refresh(Object source) {
		try {
			if (source == null) {
				String fileName = this.campusList.refresh("root");
				fileName = this.collegeList.refresh(fileName);
				fileName = this.departmentList.refresh(fileName);
				this.lectureTable.refresh(fileName);

			} else if (source == campusList) {
				String fileName = this.campusList.getSelectedFileName();
				fileName = this.collegeList.refresh(fileName);
				fileName = this.departmentList.refresh(fileName);
				this.lectureTable.refresh(fileName);

			} else if (source == collegeList) {
				String fileName = this.collegeList.getSelectedFileName();
				fileName = this.departmentList.refresh(fileName);
				this.lectureTable.refresh(fileName);

			} else if (source == departmentList) {
				String fileName = this.departmentList.getSelectedFileName();
				this.lectureTable.refresh(fileName);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			refresh(event.getSource());
		}
	}

	public Vector<ELecture> lectureSelect() {
		return lectureTable.getSelectedLectures();
	}
}

package ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DirectoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private DirectoryList campusList;
	private DirectoryList collegeList;
	private DirectoryList departmentList;
	
	private LectureTable lectureTable;
	
	private ListSelectionHandler listSelectionHandler;

	public DirectoryPanel() {
//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.listSelectionHandler = new ListSelectionHandler();
		
		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER,10,10);
		this.setLayout(layoutManager);
		
		JScrollPane scrollpane = new JScrollPane();
		this.campusList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.campusList);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.collegeList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.collegeList);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.departmentList = new DirectoryList(this.listSelectionHandler);
		scrollpane.setViewportView(this.departmentList);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.lectureTable = new LectureTable();
		scrollpane.setViewportView(this.lectureTable);
		this.add(scrollpane);
		
		this.refresh(null);

	}

	public void refresh(Object source) {
		try {
		if(source == null) {
			String fileName = this.campusList.refresh("root");
			fileName = this.collegeList.refresh(fileName);
			fileName = this.departmentList.refresh(fileName);
			this.lectureTable.refresh(fileName);
			
		}
			else if (source == campusList) {
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
}

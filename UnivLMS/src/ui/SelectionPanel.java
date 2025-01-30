package ui;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionPanel extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private DirectoryPanel directorySelectionPanel;
	private LectureTable lectureSelection;
	private DirectoryList campus;
	private DirectoryList college;
	private DirectoryList department;
	private LectureTable lecture;
	private ListSelectionListener listSelectionListener;
	
	public SelectionPanel() {
		this.listSelectionListener = new ListSelectionHandler();
		this.lecture = new LectureTable();
		
		this.campus = new DirectoryList(this.listSelectionListener);
		this.add(this.campus);
		
		this.college = new DirectoryList(this.listSelectionListener);
		this.add(this.college);
		
		this.department = new DirectoryList(this.listSelectionListener);
		this.add(this.department);

//		this.departmentSelection = new DirectoryPanel();
//		this.add(this.departmentSelection);
//		
//		this.lectureSelection = new LectureTable();
//		this.add(this.lectureSelection);
	}
	
//	public void refresh(ListSelectionEvent event) {
//		try {
//			if()
//		}
//	}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
//			refresh(event);
		}
	}

}

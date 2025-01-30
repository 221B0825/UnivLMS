package ui;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import entity.ELecture;

public class LectureTable extends JTable {
	// attributes
	private static final long serialVersionUID = 1L;
	// model
	private DefaultTableModel tableModel;
	// service
	private CLecture cLecture;
	// data
	private Vector<ELecture> eLectures;

	public LectureTable() {
		// set attributes

		// set model
		String[] columnNames = { "강좌명", "담당 교수", "학점", "요일 및 시간", };

		this.tableModel = new DefaultTableModel(null, columnNames);
		this.setModel(this.tableModel);

		// service
		this.cLecture = new CLecture();

	}

	public Vector<ELecture> getSelectedLectures() {
		return null;
	}

	public void refresh(String fileName) throws FileNotFoundException {
		this.eLectures = this.cLecture.getItems("data\\" + fileName);

		this.tableModel.setRowCount(0);
		for (ELecture eLecture : eLectures) {
			Vector<String> row = new Vector<String>();
			row.add(eLecture.getName());
			row.add(eLecture.getProfessorName());
			row.add(eLecture.getCredit());
			row.add(eLecture.getTime());
			this.tableModel.addRow(row);
		}

		this.updateUI();

	}

}

package ui;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JTable;
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
		String[] columnNames = { "강좌 번호","강좌명", "담당 교수", "학점", "요일 및 시간", };

		// table 수정 불가능
		this.tableModel = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		this.setModel(this.tableModel);

		// service
		this.cLecture = new CLecture();

	}
	
	// -------------------------------------------------------------------------------------------------

	public void refresh(String fileName) throws FileNotFoundException {
		this.eLectures = this.cLecture.getItems("data\\" + fileName);
		this.tableModel.setRowCount(0);
		for (ELecture eLecture : eLectures) {
			Vector<String> row = new Vector<String>();
			row.add(eLecture.getNumber());
			row.add(eLecture.getName());
			row.add(eLecture.getProfessorName());
			row.add(eLecture.getCredit());
			row.add(eLecture.getTime());
			tableModel.addRow(row);
		}

		this.updateUI();
	}

	// -------------------------------------------------------------------------------------------------
	
	public Vector<ELecture> getSelectedLectures() {
		Vector<ELecture> selection = new Vector<ELecture>();
		for (int i = 0; i < this.getRowCount(); i++) {
			if (this.isRowSelected(i)) {
				selection.add(this.eLectures.get(i));
			}
		}
		return selection;
	}
}

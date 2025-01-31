package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ELecture;

public class SincheongTable extends JTable {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private Vector<ELecture> sincheongLecture;

	public SincheongTable() {
		String[] columnNames = { "강좌 번호", "강좌명", "담당 교수", "학점", "요일 및 시간", };

		this.tableModel = new DefaultTableModel(null, columnNames) {
			private static final long serialVersionUTD = 1L;

			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		this.setModel(this.tableModel);
		this.sincheongLecture = new Vector<ELecture>();

	}

	// -------------------------------------------------------------------------------------------------

	// 로그인 성공시 파일 불러오기
	public void refresh(String userId) throws FileNotFoundException {
		Vector<ELecture> refersh = new Vector<ELecture>();
		File file = new File("sincheong/sincheong" + userId);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			ELecture eLecture = new ELecture();
			eLecture.read(scanner);
			refersh.add(eLecture);
		}
		if (refersh != null) {
			for (ELecture eLecture : refersh) {
				Vector<String> row = new Vector<String>();
				row.add(eLecture.getNumber());
				row.add(eLecture.getName());
				row.add(eLecture.getProfessorName());
				row.add(eLecture.getCredit());
				row.add(eLecture.getTime());
				this.tableModel.addRow(row);

				this.sincheongLecture.add(eLecture);
			}
		}
		this.updateUI();
	}
	// -------------------------------------------------------------------------------------------------

	// 신청 선택
	public void addSincheong(String userId, Vector<ELecture> sincheongSelection) throws IOException {

		for (ELecture eLecture : sincheongSelection) {
			Vector<String> row = new Vector<String>();
			row.add(eLecture.getNumber());
			row.add(eLecture.getName());
			row.add(eLecture.getProfessorName());
			row.add(eLecture.getCredit());
			row.add(eLecture.getTime());
			this.tableModel.addRow(row);
			this.sincheongLecture.add(eLecture);
		}
		this.updateUI();
		rewrite(userId);
	}
	// -------------------------------------------------------------------------------------------------

	// 삭제 선택
	public void deleteSincheong(String userId) throws IOException {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			if (this.isRowSelected(i)) {
				this.tableModel.removeRow(i);
				this.sincheongLecture.remove(i);
			}
		}
		rewrite(userId);
	}
	// -------------------------------------------------------------------------------------------------

	// text에 다시 쓰기
	public void rewrite(String userId) throws IOException {
		Vector<ELecture> rewrite = new Vector<ELecture>();
		for (int i = 0; i <= tableModel.getRowCount() - 1; i++) {
			if (sincheongLecture.get(i) != null) {
				rewrite.add(sincheongLecture.get(i));
			}
		}
		File file = new File("sincheong/sincheong" + userId);
		FileWriter fileWriter = new FileWriter(file, false);

		for (int i = 0; i <= tableModel.getRowCount() - 1; i++) {
			String sincheong = rewrite.get(i).getNumber() + " " + rewrite.get(i).getName() + " "
					+ rewrite.get(i).getProfessorName() + " " + rewrite.get(i).getCredit() + " "
					+ rewrite.get(i).getTime();
			fileWriter.write(sincheong + "\r\n");
		}
		fileWriter.flush();

	}
}

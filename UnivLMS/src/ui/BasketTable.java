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

public class BasketTable extends JTable {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private Vector<ELecture> basketLecture;

	public BasketTable() {
		String[] columnNames = { "강좌 번호", "강좌명", "담당 교수", "학점", "요일 및 시간", };

		this.tableModel = new DefaultTableModel(null, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		this.setModel(this.tableModel);
		this.basketLecture = new Vector<ELecture>();

	}
	// -------------------------------------------------------------------------------------------------

	// 로그인 성공 시 파일 불러오기
	public void refresh(String userId) throws FileNotFoundException {
		Vector<ELecture> refersh = new Vector<ELecture>();
		File file = new File("basket/basket" + userId);
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

				this.basketLecture.add(eLecture);
			}
		}
		this.updateUI();
	}

	// -------------------------------------------------------------------------------------------------
//	public int calculation(String userId) throws FileNotFoundException {
//		Vector<ELecture> calculate = new Vector<ELecture>();
//		File file = new File("basket/basket" + userId);
//		Scanner scanner = new Scanner(file);
//
//		while (scanner.hasNext()) {
//			ELecture eLecture = new ELecture();
//			eLecture.read(scanner);
//			calculate.add(eLecture);
//		}
//		Vector <integer> sum = new Vector<integer>();
//		if (calculate != null) {
//			for (ELecture eLecture : calculate) {
//				sum.add(eLecture.getCredit());
//			}
//		}
//		int total = 0;
//		for (int i = 0; i <= sum.size(); i++) {
//			if(sum != null) {
//				total = total + sum.get(i);
//			}
//		}
//		return total;
//	}

	// -------------------------------------------------------------------------------------------------

	// 담기 선택
	public void addSelection(String userId, Vector<ELecture> selection) throws IOException {

		for (ELecture eLecture : selection) {
			Vector<String> row = new Vector<String>();
			row.add(eLecture.getNumber());
			row.add(eLecture.getName());
			row.add(eLecture.getProfessorName());
			row.add(eLecture.getCredit());
			row.add(eLecture.getTime());
			this.tableModel.addRow(row);
			this.basketLecture.add(eLecture);
		}
		this.updateUI();
		rewrite(userId);
	}

	// -------------------------------------------------------------------------------------------------

	// 삭제 선택
	public void deleteSelection(String userId) throws IOException {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			if (this.isRowSelected(i)) {
				this.tableModel.removeRow(i);
				this.basketLecture.remove(i);
			}
		}
		rewrite(userId);
	}

	// -------------------------------------------------------------------------------------------------

	// text에 다시 쓰기
	public void rewrite(String userId) throws IOException {
		Vector<ELecture> rewrite = new Vector<ELecture>();
		for (int i = 0; i <= tableModel.getRowCount() - 1; i++) {
			if (basketLecture.get(i) != null) {
				rewrite.add(basketLecture.get(i));
			}
		}

		File file = new File("basket/basket" + userId);
		FileWriter fileWriter = new FileWriter(file, false);

		for (int i = 0; i <= tableModel.getRowCount() - 1; i++) {
			String lecture = rewrite.get(i).getNumber() + " " + rewrite.get(i).getName() + " "
					+ rewrite.get(i).getProfessorName() + " " + rewrite.get(i).getCredit() + " "
					+ rewrite.get(i).getTime();
			fileWriter.write(lecture + "\r\n");
		}
		fileWriter.flush();
	}

	// -------------------------------------------------------------------------------------------------

	// 신청 버튼을 눌렀을 경우 sincheongTable로 넘겨주기 위함
	public Vector<ELecture> sincheongSelect() {
		Vector<ELecture> sincheongSelection = new Vector<ELecture>();
		for (int i = 0; i < this.getRowCount(); i++) {
			if (this.isRowSelected(i)) { // 만약 i번째를 선택했을 경우
				sincheongSelection.add(this.basketLecture.get(i));
			}
		}
		return sincheongSelection;
	}

}

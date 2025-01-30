package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import entity.ELecture;

public class VLectureSincheong {

	private CLecture cLecture;
	String answer;

	public VLectureSincheong() {
		this.cLecture = new CLecture();
	}

	public String show(String answer) {

		Vector<ELecture> items;
		try {
			items = this.cLecture.getItems(answer);

			System.out.println("담은 강좌에서 번호를 선택하세요");

			Scanner scanner = new Scanner(System.in);
			System.out.print("선택: ");
			int number = scanner.nextInt();
			int index;
			boolean found = false;

			for (index = 0; index < items.size() && !found; index++) {

				if (items.get(index).getNumber() == number) {
					found = true;
					answer = items.get(index).getNumber() + " " + items.get(index).getName() + " "
							+ items.get(index).getCredit() + " " + items.get(index).getTime() + " "
							+ items.get(index).getProfessorName();
				}
			}

			return answer;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import entity.ELecture;

public class VLecture {
	private CLecture cLecture;
	String result;
	
	public VLecture() {
		this.cLecture = new CLecture();
		
	}

	public String show(String fileName) {

		// get data from control
		Vector<ELecture> items;
		try {
			items = this.cLecture.getItems(fileName);
			// show items
			System.out.println("번호를 선택하세요");
			for (ELecture item : items) {
				System.out.println(item.getNumber() + " " + item.getName());
			}

			// get item number
			Scanner scanner = new Scanner(System.in);
			System.out.print("선택: ");
			int number = scanner.nextInt();
			int index;
			boolean found = false;

			for (index = 0; index < items.size() && !found; index++) {
				
				if (items.get(index).getNumber() == number) {
					found = true;
					result = items.get(index).getNumber()+" "+ items.get(index).getName()+" "+ items.get(index).getCredit()+" "+items.get(index).getTime()+" "+items.get(index).getProfessorName();
					System.out.println(result);
				}
			}
			
			// return hyperlink
			return result;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

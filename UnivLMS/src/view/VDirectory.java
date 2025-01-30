package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import control.CDirectory;
import entity.EDirectory;

public class VDirectory {

	private CDirectory cDirectory;

	public VDirectory() {
		this.cDirectory = new CDirectory();
	}

	public String show(String fileName) {
		// get data from control
		Vector<EDirectory> items;
		try {
			items = this.cDirectory.getItems(fileName);
			// show items
			System.out.println("번호를 선택하세요");
			for (EDirectory item : items) {
				System.out.println(item.getNumber() + " " + item.getName());
			}

			// get item number
			Scanner scanner = new Scanner(System.in);
			System.out.print("선택: ");
			int number = scanner.nextInt();
			
			int index = 0;
			boolean found = false;
			String result = null;
			
			for (index = 0; index < items.size() && !found; index++) {
				if (items.get(index).getNumber() == number) {
					found = true;
					result = items.get(index).getHyperLink();
				}
			}
			// scanner.close();

			// return hyperlink
			return result;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CSincheong;
import entity.ELecture;

public class VSincheong {

	private VLectureSincheong vLectureSincheong;
	private CSincheong cSincheong;
	String answer;

	public VSincheong() {
		this.vLectureSincheong = new VLectureSincheong();
	}

	public String show(String result, String userId) throws IOException {

		if (result != null) {
			answer = this.vLectureSincheong.show("data\\basket"+userId);
			
			Vector<ELecture> items = new Vector<ELecture>();
			File file = new File("data\\sincheong"+userId);
			FileWriter fw = new FileWriter(file, true);
			fw.write(answer+"\r\n");
			fw.flush();
		}
			
		return null;
	}

	public void list(String userId) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("data/basket" + userId));
		if (sc.hasNext()) {
			System.out.println("[현재 담은 강의 목록]");
			while (sc.hasNext()) {
				String list = sc.nextLine();
				System.out.println(list);
			}
		}

		sc = new Scanner(new File("data\\sincheong"+userId));
		if (sc.hasNext()) {
			System.out.println("[현재 신청 강의 목록]");
			while (sc.hasNext()) {
				String list = sc.nextLine();
				System.out.println(list);
			}
		}
	}

}

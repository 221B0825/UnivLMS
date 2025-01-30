package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import control.CBasket;

public class VBasket {

	private CBasket cBasket;

	public VBasket() {
		cBasket = new CBasket();
	}

	public void show(String result, String userId) throws IOException {
		
//		VSugangSincheong vSugangSincheong = new VSugangSincheong();
		
		if(result != null) {
		System.out.println("선택하신 강좌를 담습니다.");
		this.cBasket.show(result, userId);
		}
		else {
			System.out.println("올바른 숫자를 입력해주십시오.");
		}
		
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
	}

}

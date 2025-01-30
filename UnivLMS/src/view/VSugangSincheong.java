package view;

import java.io.FileNotFoundException;
import java.io.IOException;

import entity.ELecture;

public class VSugangSincheong {

	private VSugangInfo vSugangInfo;
	private VBasket vBasket;
	private VSincheong vSincheong;
	private VLectureSincheong vLectureSincheong;
	
	public VSugangSincheong() {
		this.vSugangInfo = new VSugangInfo();
		this.vBasket = new VBasket();
		this.vSincheong = new VSincheong();
		}

	public void show(String userId) throws IOException {
		System.out.println("환영합니다.");
		this.vBasket.list(userId);
		String result = this.vSugangInfo.show();
		this.vBasket.show(result,userId);
		
		this.vSincheong.list(userId);
		this.vSincheong.show(result,userId);
		this.vSincheong.list(userId);
		System.out.println("프로그램을 종료합니다.");
	}


}

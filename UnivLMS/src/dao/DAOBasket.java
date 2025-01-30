package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import entity.ELecture;

public class DAOBasket {

	public Vector<ELecture> show(String result, String userId) throws IOException {
		
		Vector<ELecture> items = new Vector<ELecture>();
		File file = new File("data/basket"+userId);
		FileWriter fw = new FileWriter(file, true);
		fw.write(result+"\r\n");
		fw.flush();
		return items;
		
	}
}

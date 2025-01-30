package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import entity.ELecture;

public class DAOSincheong {

	public Vector<ELecture> show(String answer, String userId) throws IOException {
		
		Vector<ELecture> items = new Vector<ELecture>();
		File file = new File("data\\sincheong"+userId);
		FileWriter fw = new FileWriter(file, true);
		fw.write(answer+"\r\n");
		fw.flush();
		return items;
	}

}

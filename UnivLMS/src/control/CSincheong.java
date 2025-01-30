package control;

import java.io.IOException;
import java.util.Vector;

import dao.DAOSincheong;
import entity.ELecture;

public class CSincheong {

	private DAOSincheong daoSincheong;

	public CSincheong() {
		this.daoSincheong = new DAOSincheong();
	}
	
	public Vector<ELecture> show(String answer, String userId) throws IOException {
		return this.daoSincheong.show(answer,userId);
		
	}

}

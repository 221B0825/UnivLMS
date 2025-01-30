package control;

import java.io.IOException;
import java.util.Vector;

import dao.DAOBasket;
import entity.ELecture;

public class CBasket {

	private DAOBasket daoBasket;
	
	public CBasket() {
		this.daoBasket = new DAOBasket();
	}
	
	public Vector<ELecture> show(String result, String userId) throws IOException {
		return this.daoBasket.show(result,userId);
		
	}

}

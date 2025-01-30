package control;
import java.io.FileNotFoundException;
import java.util.Vector;

import dao.DAODiretory;
import entity.EDirectory;

public class CDirectory {

	private DAODiretory daoDirectory;
	
	public CDirectory() {
		this.daoDirectory = new DAODiretory();
	}

	public Vector<EDirectory> getItems(String fileName) throws FileNotFoundException {
		return this.daoDirectory.getItems(fileName);

	}
}

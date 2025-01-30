package ui;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import entity.EDirectory;



public class DirectoryList extends JList<String> {
	private static final long serialVersionUID = 1L;
	
	private CDirectory cdirectory;
	private Vector<EDirectory> directories;
	private Vector<String> listData;
	
	public DirectoryList(ListSelectionListener listSelectionHandler) {
		
		this.setPreferredSize(new Dimension(100,200));
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.cdirectory = new CDirectory();
		this.listData = new Vector<String>();
		
		this.setListData(this.listData);
		this.addListSelectionListener(listSelectionHandler);
			
			
	}

	public String getSelectedFileName() {
		int selectedIndex = this.getSelectedIndex();
		return this.directories.get(selectedIndex).getHyperLink();
	}

	public String refresh(String fileName) throws FileNotFoundException {
		this.directories = this.cdirectory.getItems("data\\"+fileName);
		
		this.listData.clear();
		for(EDirectory eDirectory : directories) {
			this.listData.add(eDirectory.getName());
		}
		
		this.updateUI();
		this.setSelectedIndex(0);//무조건 첫번째 칸 선택함
		return this.directories.get(0).getHyperLink();
	}
	
}

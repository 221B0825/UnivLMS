package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.ELecture;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private DirectoryPanel directorySelectionPanel;
	private BasketPanel basketPanel;
	private SincheongPanel sincheongPanel;
	private String userId;

	private BasketActionHandler basketActionHandler;
	private BasketDeleteActionHandler basketDeleteActionHandler;
	private SincheongActionHandler sincheongActionHandler;
	private SincheongDeleteActionHandler sincheongDeleteActionHandler; 

	public MainFrame(String userId, ActionListener logoutButtonActionHandler) throws FileNotFoundException {

		this.userId = userId;
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setLocation(100, 100);
		setSize(1480, 880);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.basketActionHandler = new BasketActionHandler();
		this.basketDeleteActionHandler = new BasketDeleteActionHandler();
		this.sincheongActionHandler = new SincheongActionHandler();
		this.sincheongDeleteActionHandler = new SincheongDeleteActionHandler();

		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1480, 880));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		mainPanel.setBackground(Color.WHITE);
		
		this.directorySelectionPanel = new DirectoryPanel(userId, logoutButtonActionHandler);
		mainPanel.add(this.directorySelectionPanel);

		this.basketPanel = new BasketPanel(this.basketActionHandler, this.basketDeleteActionHandler);
		mainPanel.add(this.basketPanel);

		this.sincheongPanel = new SincheongPanel(this.sincheongActionHandler,this.sincheongDeleteActionHandler);
		mainPanel.add(this.sincheongPanel);

		this.add(mainPanel);
	}
	public void refresh(String userId) throws FileNotFoundException {
		basketPanel.refresh(userId);
		sincheongPanel.refresh(userId);
	}

	// 책가방 담기
	public void lectureSelect(String userId) throws IOException {
		Vector<ELecture> selection = this.directorySelectionPanel.lectureSelect();
		basketPanel.addSelection(userId,selection);
	}

	class BasketActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				lectureSelect(userId);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	// 책가방 삭제	
	class BasketDeleteActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				basketPanel.deleteSelection(userId);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// 신청 담기
	public void sincheongSelect() throws IOException {
		Vector<ELecture> sincheongSelection = this.basketPanel.sincheongSelect();
		sincheongPanel.addSincheongSelection(userId,sincheongSelection);

	}

	class SincheongActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				sincheongSelect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 신청 삭제
	class SincheongDeleteActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				sincheongPanel.deleteSincheongSelection(userId);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

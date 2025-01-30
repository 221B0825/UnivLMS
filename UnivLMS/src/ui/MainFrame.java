package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
//	private Dimension location;
	private SelectionPanel selectionPanel;
//	private Basket basket;
	private DirectoryPanel directorySelectionPanel;
	
	public MainFrame() {
		//attributes
		//this.location = new Dimension(100,200) - JFrame안에 setLocation이 이렇게 설정되어 있음
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10)); //아래 컴포넌트들을 설정함
		setLocation(100, 100);
		setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
//		this.selectionPanel = new SelectionPanel();
//		this.add(this.selectionPanel);
//		
//		this.basket = new Basket();
//		this.add(this.basket); //필요한 리소스를 전달

		this.directorySelectionPanel = new DirectoryPanel();
		this.add(this.directorySelectionPanel);
		
		
	}

}

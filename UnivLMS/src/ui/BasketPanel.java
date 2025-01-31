package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entity.ELecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private BasketTable basketTable;
	private JButton selectionButton;
	private JButton deleteButton;

	public BasketPanel(ActionListener basketActionHandler, ActionListener basketDeleteActionHandler) throws FileNotFoundException {

		// BasketPanel 설정
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		this.setPreferredSize(new Dimension(460, 1000));
		this.setBackground(Color.WHITE);
		
		Color color = new Color(1, 41, 102);
		Font font = new Font("맑은 고딕", Font.PLAIN, 18);

		// -------------------------------------------------------------------------------------------------

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		textPanel.setPreferredSize(new Dimension(460, 30));
		textPanel.setBackground(Color.WHITE);
		
		JLabel basketLabel = new JLabel("책가방");
		basketLabel.setFont(font);
		
		textPanel.add(basketLabel);

		this.add(textPanel);

		// -------------------------------------------------------------------------------------------------

		JScrollPane scrollpane = new JScrollPane();
		scrollpane = new JScrollPane();
		this.basketTable = new BasketTable();
		scrollpane.setViewportView(this.basketTable);
		scrollpane.setPreferredSize(new Dimension(460, 700));
		this.add(scrollpane);

		// -------------------------------------------------------------------------------------------------
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		buttonPanel.setPreferredSize(new Dimension(460, 40));
		buttonPanel.setBackground(Color.WHITE);

		this.selectionButton = new JButton("담기");
		selectionButton.setFont(font);
		selectionButton.setBackground(color);
		selectionButton.setForeground(Color.WHITE);
		selectionButton.addActionListener(basketActionHandler);
		
		JPanel buttonBlank = new JPanel();
		buttonBlank.setPreferredSize(new Dimension(100, 40));
		buttonBlank.setBackground(Color.WHITE);

		this.deleteButton = new JButton("삭제");
		deleteButton.setFont(font);
		deleteButton.setBackground(color);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.addActionListener(basketDeleteActionHandler);

		buttonPanel.add(selectionButton);
		buttonPanel.add(buttonBlank);
		buttonPanel.add(deleteButton);
		this.add(buttonPanel);
	
		
	}

	public void refresh(String userId) throws FileNotFoundException {
		basketTable.refresh(userId);
	}
	
	// 책가방에서 담기 선택
	public void addSelection(String userId, Vector<ELecture> selection) throws IOException {
		basketTable.addSelection(userId, selection);

	}

	// 책가방에서 삭제 선택
	public void deleteSelection(String userId) throws IOException {
		basketTable.deleteSelection(userId);
	}

	// 신청 목록으로 넘기기
	public Vector<ELecture> sincheongSelect() {
		return basketTable.sincheongSelect();
	}

}

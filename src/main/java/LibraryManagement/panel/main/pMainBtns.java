package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import LibraryManagement.BookCategoryManagement;
import LibraryManagement.BookInsert;
import LibraryManagement.BookManagement;
import LibraryManagement.MembManagement;
import LibraryManagement.RentScreen;
import LibraryManagement.ReturnScreen;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pMainBtns extends JPanel implements ActionListener {
	private JButton btnRent;
	private JButton btnReturn;
	private JButton btnMembInfo;
	private JButton btnBookInfo;
	private JButton btnBookCategory;

	/**
	 * Create the panel.
	 */
	public pMainBtns() {

		initialize();
	}
	private void initialize() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		btnRent = new JButton("대출하기");
		btnRent.addActionListener(this);
		add(btnRent);
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		add(btnReturn);
		
		btnMembInfo = new JButton("회원관리");
		btnMembInfo.addActionListener(this);
		add(btnMembInfo);
		
		btnBookInfo = new JButton("도서관리");
		btnBookInfo.addActionListener(this);
		add(btnBookInfo);
		
		btnBookCategory = new JButton("도서구분관리");
		btnBookCategory.addActionListener(this);
		add(btnBookCategory);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBookCategory) {
			actionPerformedBtnBookCategory(e);
		}
		if (e.getSource() == btnBookInfo) {
			actionPerformedBtnBookInfo(e);
		}
		if (e.getSource() == btnMembInfo) {
			actionPerformedBtnMembInfo(e);
		}
		if (e.getSource() == btnReturn) {
			actionPerformedBtnReturn(e);
		}
		if (e.getSource() == btnRent) {
			actionPerformedBtnRent(e);
		}
	}
	protected void actionPerformedBtnRent(ActionEvent e) {
		RentScreen frame = new RentScreen();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnReturn(ActionEvent e) {
		ReturnScreen frame = new ReturnScreen();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnMembInfo(ActionEvent e) {
		MembManagement frame = new MembManagement();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnBookInfo(ActionEvent e) {
		BookManagement frame = new BookManagement();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnBookCategory(ActionEvent e) {
		BookCategoryManagement frame = new BookCategoryManagement();
		frame.setVisible(true);
	}
}

package LibraryManagement.panel.rentScreen;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LibraryManagement.dto.BookInfo;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class pBookSearch extends JPanel implements ActionListener {
	private JTextField tfBookSearch;
	private JComboBox<String> cbBookSearchBy;
	private String tfString;
//	private MainService service;
	private pBookInfoTable pBookTable;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public pBookSearch() {
//		service = new MainService();
		pBookTable = new pBookInfoTable();
//		pBookTable.setService(service);
		initialize();
	}

	public pBookInfoTable getpBookTable() {
		return pBookTable;
	}

	public void setpBookTable(pBookInfoTable pBookTable) {
		this.pBookTable = pBookTable;
	}

	private void addData() {
		String[] searchKey = { "도서번호", "도서제목", "도서구분" };

		for (String s : searchKey) {
			cbBookSearchBy.addItem(s);
		}
	}

	private void initialize() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblBookSearch = new JLabel("빠른 도서 검색 :");
		lblBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookSearch.setFont(new Font("굴림", Font.PLAIN, 15));
		add(lblBookSearch);

		cbBookSearchBy = new JComboBox();
		cbBookSearchBy.addActionListener(this);

		addData();
		add(cbBookSearchBy);

		tfBookSearch = new JTextField();
		tfBookSearch.addActionListener(this);
		tfBookSearch.setColumns(20);
		add(tfBookSearch);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		add(btnSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbBookSearchBy) {
			actionPerformedCbBookSearchBy(e);
		}
		if (e.getSource() == btnSearch) {
			if (tfString.equals("도서번호")) {
				try {
					actionPerformedBtnSearchByNo(e);
				} catch (NullPointerException e1) {
					pBookTable.loadData();
				}
			}
			if (tfString.equals("도서제목")) {
				actionPerformedBtnSearchByTitle(e);
			}
			if (tfString.equals("도서구분")) {
				actionPerformedBtnSearchByCategory(e);
			}
		}
	}

	// 콤보박스 도서구부능로 선택후 검색
	private void actionPerformedBtnSearchByCategory(ActionEvent e) {
		String bookCategory = tfBookSearch.getText().trim();
		pBookTable.selectByCategoryList(bookCategory);
		pBookTable.setList();

	}

	// 콤보박스 도서제목으로 선택후 검색
	private void actionPerformedBtnSearchByTitle(ActionEvent e) {
		String bookTitle = tfBookSearch.getText().trim();
		pBookTable.selectByTitleList(bookTitle);
		pBookTable.setList();

	}

	// 콤보박스 도서번호로 선택후 검색
	private void actionPerformedBtnSearchByNo(ActionEvent e) {
		int bookNo = Integer.parseInt(tfBookSearch.getText().trim());
		
		pBookTable.selectByNoList(bookNo);
		pBookTable.setList();

	}

	protected void actionPerformedCbBookSearchBy(ActionEvent e) {
		tfString = cbBookSearchBy.getSelectedItem().toString();

	}

}

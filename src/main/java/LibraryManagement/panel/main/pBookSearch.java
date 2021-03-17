package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.service.MainService;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class pBookSearch extends JPanel implements ActionListener {
	private JTextField tfBookSearch;
	private JComboBox<String> cbBookSearchBy;
	private String tfString;
//	private MainService service;
	private BookInfoTablePanel pBookTable;

	/**
	 * Create the panel.
	 */
	public pBookSearch() {
//		service = new MainService();
		pBookTable = new BookInfoTablePanel();
//		pBookTable.setService(service);
		initialize();
	}

	public BookInfoTablePanel getpBookTable() {
		return pBookTable;
	}

	public void setpBookTable(BookInfoTablePanel pBookTable) {
		this.pBookTable = pBookTable;
	}

	private void addData() {
		String[] searchKey = { "도서번호", "도서제목", "도서구분" };

		for (String s : searchKey) {
			cbBookSearchBy.addItem(s);
		}
	}

	private void initialize() {
		setLayout(new GridLayout(0, 3, 5, 5));

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
		tfBookSearch.setColumns(10);
		add(tfBookSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbBookSearchBy) {
			actionPerformedCbBookSearchBy(e);
		}
		if (e.getSource() == tfBookSearch) {
			if (tfString.equals("도서번호")) {

				try {
					actionPerformedTfBookSearchByNo(e);
				} catch (NullPointerException e1) {
					pBookTable.initList();
					pBookTable.setList();
				}
			}
			if (tfString.equals("도서제목")) {
//				actionPerformedTfBookSearchByTitle(e);
			}
			if (tfString.equals("도서구분")) {
//				actionPerformedTfBookSearchByCategory(e);
			}
		}
	}

	// 콤보박스 도서구부능로 선택후 검색
	private void actionPerformedTfBookSearchByCategory(ActionEvent e) {

	}

	// 콤보박스 도서제목으로 선택후 검색
	private void actionPerformedTfBookSearchByTitle(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// 콤보박스 도서번호로 선택후 검색
	private void actionPerformedTfBookSearchByNo(ActionEvent e) {
		int bookNo = Integer.parseInt(tfBookSearch.getText().trim());
		System.out.println(bookNo);
		pBookTable.selectByNoList(bookNo);
		pBookTable.setList();

	}

	protected void actionPerformedCbBookSearchBy(ActionEvent e) {
		tfString = cbBookSearchBy.getSelectedItem().toString();

	}

}

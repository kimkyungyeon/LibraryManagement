package LibraryManagement.panel.bookmanagement;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class pBookSearch extends JPanel implements ActionListener {
	private JTextField tfBookSearch;
	private JComboBox<String> cbBookSearchBy;
	private String tfString;
	private BookInfoTablePanel pBookTable;

	/**
	 * Create the panel.
	 */
	public pBookSearch() {
		pBookTable = new BookInfoTablePanel();
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
				} catch (NumberFormatException e1) {
					if(tfBookSearch.getText().trim().equals("")) {
						pBookTable.loadData();
					}else {
						pBookTable.nullList();
						JOptionPane.showMessageDialog(null, "해당하는 도서가 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 도서가 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pBookTable.nullList();
				}
			}
			if (tfString.equals("도서제목")) {
				try {
					actionPerformedTfBookSearchByTitle(e);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 도서가 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pBookTable.nullList();
				}
			}
			if (tfString.equals("도서구분")) {
				try {
					actionPerformedTfBookSearchByCategory(e);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 도서가 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pBookTable.nullList();
				}
			}
		}
	}

	// 콤보박스 도서구부능로 선택후 검색
	private void actionPerformedTfBookSearchByCategory(ActionEvent e) {
		String bookCategory = tfBookSearch.getText().trim();
		pBookTable.selectByCategoryList(bookCategory);
		pBookTable.setList();

	}

	// 콤보박스 도서제목으로 선택후 검색
	private void actionPerformedTfBookSearchByTitle(ActionEvent e) {
		String bookTitle = tfBookSearch.getText().trim();
		pBookTable.selectByTitleList(bookTitle);
		pBookTable.setList();


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

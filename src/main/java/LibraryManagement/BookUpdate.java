package LibraryManagement;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.OptionalInt;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.panel.bookmanagement.BookInfoTablePanel;
import LibraryManagement.service.ReturnScreenService;

public class BookUpdate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfBookNo;
	private JTextField tfBookTitle;
	private JTextField tfTotalCount;
	private ReturnScreenService service;
	private JComboBox cbBookCategory;
	private JButton btnUpdate;
	private JButton btnClear;
	private BookInfoTablePanel bookTable;

	/**
	 * Create the frame.
	 */
	public BookUpdate() {
		service = new ReturnScreenService();
		initialize();
		addDataCmb();
	}

	public void setBookTable(BookInfoTablePanel bookTable) {
		this.bookTable = bookTable;
	}

	private void addDataCmb() {
		List<BookCategory> category = service.showBookCategoryAll();
		DefaultComboBoxModel<BookCategory> model = new DefaultComboBoxModel<BookCategory>(new Vector<>(category));
		cbBookCategory.setModel(model);
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "도서추가", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 20));
		setTitle("도서수정");

		JLabel lblBookNo = new JLabel("도서번호");

		lblBookNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookNo);

		tfBookNo = new JTextField();
		tfBookNo.setEditable(false);
		tfBookNo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookNo);
		tfBookNo.setColumns(10);

		JLabel lblBookTitle = new JLabel("도서제목");
		lblBookTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookTitle);

		tfBookTitle = new JTextField();
		tfBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookTitle);
		tfBookTitle.setColumns(10);

		JLabel lblBookCategory = new JLabel("도서구분");
		lblBookCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookCategory);

		cbBookCategory = new JComboBox();
		cbBookCategory.addActionListener(this);
		contentPane.add(cbBookCategory);

		JLabel lblTotalCount = new JLabel("도서권수");
		lblTotalCount.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblTotalCount);

		tfTotalCount = new JTextField();
		tfTotalCount.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfTotalCount);
		tfTotalCount.setColumns(10);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		btnUpdate = new JButton("수 정");
		btnUpdate.addActionListener(this);
		panel_1.add(btnUpdate);

		btnClear = new JButton("취 소");
		btnClear.addActionListener(this);
		panel_1.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnUpdate) {

			actionPerformedBtnUpdate(e);
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		BookInfo updateBook = getItem();
		service.modifyBookInfo(updateBook);
		bookTable.loadData();
		dispose();
	}

//	protected void actionPerformedBtnAdd(ActionEvent e) {
//		BookInfo addBookInfo = getItem();
//		service.addBookInfo(addBookInfo);
//		bookTable.loadData();
//		dispose();
//	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		clearTf();
	}

	private void clearTf() {
		tfBookTitle.setText("");
		tfTotalCount.setText("");
		cbBookCategory.setSelectedIndex(0);
	}

	// textfield,combobox에서 값을 받아서 추가하기 위한 새로운 BookInfo dto 생성
	public BookInfo getItem() {
		int bookNo = Integer.parseInt(tfBookNo.getText().trim());
		String bookTitle = tfBookTitle.getText().trim();
		boolean rentYN = true;
		BookCategory categoryNo = getBookCategory();
		int totalCount = Integer.parseInt(tfTotalCount.getText().trim());
		int count = totalCount;
		return new BookInfo(bookNo, bookTitle, rentYN, categoryNo, count, totalCount);
	}

	// 콤보박스에서 BookCategory dto 추출
	public BookCategory getBookCategory() {
		String categoryNo1 = cbBookCategory.getSelectedItem() + "";
		String a = categoryNo1.substring(categoryNo1.indexOf("(") + 1, categoryNo1.indexOf(")"));
		String c = categoryNo1.substring(0, categoryNo1.indexOf("("));
		int b = Integer.parseInt(a);
		BookCategory categoryNo = new BookCategory(b, c);

		return categoryNo;
	}

	public int getLastBookNo() {
//		System.out.println(service.showBookInfoAll());
		List<BookInfo> list = service.showBookInfoAll();

		OptionalInt maxBookNo = service.showBookInfoAll().parallelStream().mapToInt(BookInfo::getBookNo).max();
		int maxBookNo1 = maxBookNo.getAsInt() + 1;
		return maxBookNo1;
	}

	public void setItem(BookInfo bookInfo) {
		tfBookNo.setText(bookInfo.getBookNo() + "");
		tfBookTitle.setText(bookInfo.getBookTitle());
		System.out.println(bookInfo.getCategoryNo().getCategoryNo() - 1);
		cbBookCategory.setSelectedIndex(bookInfo.getCategoryNo().getCategoryNo() - 1);
		tfTotalCount.setText(bookInfo.getTotalcount() + "");
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

}

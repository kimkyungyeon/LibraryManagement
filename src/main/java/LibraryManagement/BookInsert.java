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

public class BookInsert extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfBookNo;
	private JTextField tfBookTitle;
	private JTextField tfTotalCount;
	private ReturnScreenService service;
	private JComboBox cbBookCategory;
	private JButton btnAdd;
	private JButton btnClear;
	private BookInfoTablePanel bookTable;

	/**
	 * Create the frame.
	 */
	public BookInsert() {
		service = new ReturnScreenService();
		initialize();
		getLastBookNo();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "도서추가", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 20));
		setTitle("도서추가");
		
		JLabel lblBookNo = new JLabel("도서번호");
		
		lblBookNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookNo);
		
		tfBookNo = new JTextField();
		tfBookNo.setEditable(false);
		tfBookNo.setText(getLastBookNo()+"");
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
		contentPane.add(cbBookCategory);
		
		JLabel lblTotalCount = new JLabel("도서 권수");
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
		
		btnAdd = new JButton("추 가");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);
		
		btnClear = new JButton("취 소");
		btnClear.addActionListener(this);
		panel_1.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		BookInfo addBookInfo = getItem();
		service.addBookInfo(addBookInfo);
		bookTable.loadData();
		dispose();
	}
	
	protected void actionPerformedBtnClear(ActionEvent e) {
		
	}
	
	public BookInfo getItem(){
		int bookNo = Integer.parseInt(tfBookNo.getText().trim());
		String bookTitle = tfBookTitle.getText().trim();
		boolean rentYN = true;
		BookCategory categoryNo = getBookCategory();
		int totalCount = Integer.parseInt(tfTotalCount.getText().trim());
		int count = totalCount;
		return new BookInfo(bookNo, bookTitle, rentYN, categoryNo, count, totalCount);
	}


	public BookCategory getBookCategory() {
		String categoryNo1 = cbBookCategory.getSelectedItem()+"";
		String a = categoryNo1.substring(categoryNo1.indexOf("(")+1, categoryNo1.indexOf(")"));
		String c = categoryNo1.substring(0, categoryNo1.indexOf("("));
		int b = Integer.parseInt(a);
		BookCategory categoryNo = new BookCategory(b,c);

		return categoryNo;
	}
	
	public int getLastBookNo() {
		System.out.println(service.showBookInfoAll());
		List<BookInfo> list = service.showBookInfoAll();
		
		OptionalInt maxBookNo = service.showBookInfoAll().parallelStream().mapToInt(BookInfo::getBookNo).max();
		int maxBookNo1 = maxBookNo.getAsInt()+1;
		return maxBookNo1;
	}
}

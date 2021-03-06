package LibraryManagement;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.OptionalInt;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.exception.FormatException;
import LibraryManagement.exception.InvalidCheckException;
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
		contentPane.setBorder(new TitledBorder(null, "λμμΆκ°", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 20));
		setTitle("λμμΆκ°");

		JLabel lblBookNo = new JLabel("λμλ²νΈ");

		lblBookNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookNo);

		tfBookNo = new JTextField();
		tfBookNo.setEditable(false);
		tfBookNo.setText(getLastBookNo() + "");
		tfBookNo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookNo);
		tfBookNo.setColumns(10);

		JLabel lblBookTitle = new JLabel("λμμ λͺ©");
		lblBookTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookTitle);

		tfBookTitle = new JTextField();
		tfBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookTitle);
		tfBookTitle.setColumns(10);

		JLabel lblBookCategory = new JLabel("λμκ΅¬λΆ");
		lblBookCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookCategory);

		cbBookCategory = new JComboBox();
		contentPane.add(cbBookCategory);

		JLabel lblTotalCount = new JLabel("λμκΆμ");
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

		btnAdd = new JButton("μΆ κ°");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);

		btnClear = new JButton("μ·¨ μ");
		btnClear.addActionListener(this);
		panel_1.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnAdd) {
			try {
			actionPerformedBtnAdd(e);
			} catch (FormatException e1) {
				JOptionPane.showMessageDialog(null, "νμμ΄ λ§μ§ μμ΅λλ€.", "μ€λ₯", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidCheckException e1) {
				JOptionPane.showMessageDialog(null, "κ³΅λ°±μ΄ μ‘΄μ¬ν©λλ€.", "μ€λ₯", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		BookInfo addBookInfo = getItem();
		service.addBookInfo(addBookInfo);
		bookTable.loadData();
		dispose();
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		clearTf();
	}

	private void clearTf() {
		tfBookTitle.setText("");
		tfTotalCount.setText("");
		cbBookCategory.setSelectedIndex(0);
	}

	// textfield,comboboxμμ κ°μ λ°μμ μΆκ°νκΈ° μν μλ‘μ΄ BookInfo dto μμ±
	public BookInfo getItem() {
		typeCheck();
		validCheck();
		int bookNo = Integer.parseInt(tfBookNo.getText().trim());
		String bookTitle = tfBookTitle.getText().trim();
		boolean rentYN = true;
		BookCategory categoryNo = getBookCategory();
		int totalCount = Integer.parseInt(tfTotalCount.getText().trim());
		int count = totalCount;
		return new BookInfo(bookNo, bookTitle, rentYN, categoryNo, count, totalCount);
	}

	// μ½€λ³΄λ°μ€μμ BookCategory dto μΆμΆ
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
		tfTotalCount.setText(bookInfo.getTotalcount() + "");
		cbBookCategory.setSelectedItem(bookInfo.getCategoryNo().getCategoryNo() + 1);
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public void typeCheck() {
		if (!(Pattern.matches("^[0-9]*$", tfTotalCount.getText().trim()))) {
			System.out.println(1);
			throw new FormatException();
		}
	}
	
	public void validCheck() {
		if(tfBookTitle.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
		if(tfTotalCount.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
	}
}

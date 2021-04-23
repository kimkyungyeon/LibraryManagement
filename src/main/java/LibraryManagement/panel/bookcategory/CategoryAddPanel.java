package LibraryManagement.panel.bookcategory;

import java.awt.GridLayout;
import java.util.List;
import java.util.OptionalInt;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.service.ReturnScreenService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryAddPanel extends JPanel implements ActionListener {

	private JTextField tfCategoryNo;
	private JTextField tfCategoryName;
	private ReturnScreenService service;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAdd;
	private BookCategoryTablePanel bcTable = new BookCategoryTablePanel();

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JTextField getTfCategoryNo() {
		return tfCategoryNo;
	}

	public JTextField getTfCategoryName() {
		return tfCategoryName;
	}

	public void setBcTable(BookCategoryTablePanel bcTable) {
		this.bcTable = bcTable;
	}

	public BookCategoryTablePanel getBcTable() {
		return bcTable;
	}

	/**
	 * Create the panel.
	 */
	public CategoryAddPanel() {
		service = new ReturnScreenService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblCategoryNo = new JLabel("도서구분 번호");
		lblCategoryNo.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblCategoryNo);

		tfCategoryNo = new JTextField();
		tfCategoryNo.setEditable(false);
		tfCategoryNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfCategoryNo.setText(getLastCategoryNo() + "");
		add(tfCategoryNo);
		tfCategoryNo.setColumns(10);

		JLabel lblCategoryName = new JLabel("도서구분명");
		lblCategoryName.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblCategoryName);

		tfCategoryName = new JTextField();
		tfCategoryName.setHorizontalAlignment(SwingConstants.CENTER);
		add(tfCategoryName);
		tfCategoryName.setColumns(10);

		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);
	}

	public int getLastCategoryNo() {
		List<BookCategory> list = service.showBookCategoryAll();

		OptionalInt maxCategoryNo = service.showBookCategoryAll().parallelStream().mapToInt(BookCategory::getCategoryNo)
				.max();
		int maxCategoryNo1 = maxCategoryNo.getAsInt() + 1;
		return maxCategoryNo1;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if(btnAdd.getText().equals("추가")) {
				actionPerformedBtnAdd(e);
			} else {
				actionPerformedBtnUpdate(e);
			}
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		BookCategory bc = getItem();
		service.modifyBookCategory(bc);
		bcTable.loadData();
		tfCategoryNo.setText(getLastCategoryNo() + "");
		tfCategoryName.setText("");
		btnAdd.setText("추가");
//		tfCategoryNo.setEditable(true);
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		BookCategory bc = getItem();
		service.addBookCategory(bc);
		bcTable.loadData();
		tfCategoryNo.setText(getLastCategoryNo() + "");
		tfCategoryName.setText("");
	}

	public BookCategory getItem() {
		int categoryNo = Integer.parseInt(tfCategoryNo.getText().trim());
		String bookCategory = tfCategoryName.getText().trim();
		return new BookCategory(categoryNo, bookCategory);
	}
}

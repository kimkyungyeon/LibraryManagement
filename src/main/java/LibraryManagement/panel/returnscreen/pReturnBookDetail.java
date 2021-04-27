package LibraryManagement.panel.returnscreen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.RentInfo;

public class pReturnBookDetail extends JPanel {
	private JTextField tfBookTitle;
	private JTextField tfBookNo;
	private JTextField tfBookCategory;

	/**
	 * Create the panel.
	 */
	public pReturnBookDetail() {

		initialize();
	}
	
	
	public JTextField getTfBookTitle() {
		return tfBookTitle;
	}


	public void setTfBookTitle(JTextField tfBookTitle) {
		this.tfBookTitle = tfBookTitle;
	}


	public JTextField getTfBookNo() {
		return tfBookNo;
	}


	public void setTfBookNo(JTextField tfBookNo) {
		this.tfBookNo = tfBookNo;
	}


	public JTextField getTfBookCategory() {
		return tfBookCategory;
	}


	public void setTfBookCategory(JTextField tfBookCategory) {
		this.tfBookCategory = tfBookCategory;
	}


	private void initialize() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "대여도서상세정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pBookTitle = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pBookTitle.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(pBookTitle);
		
		JLabel lblBookTitle = new JLabel("도서제목:");
		pBookTitle.add(lblBookTitle);
		
		tfBookTitle = new JTextField();
		tfBookTitle.setEditable(false);
		pBookTitle.add(tfBookTitle);
		tfBookTitle.setColumns(30);
		
		JPanel pBookNo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pBookNo.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(pBookNo);
		
		JLabel lblBookNo = new JLabel("도서번호:");
		pBookNo.add(lblBookNo);
		
		tfBookNo = new JTextField();
		tfBookNo.setEditable(false);
		pBookNo.add(tfBookNo);
		tfBookNo.setColumns(10);
		
		JPanel pBookCategory = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBookCategory.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(pBookCategory);
		
		JLabel lblBookCategory = new JLabel("도서구분:");
		pBookCategory.add(lblBookCategory);
		
		tfBookCategory = new JTextField();
		tfBookCategory.setEditable(false);
		pBookCategory.add(tfBookCategory);
		tfBookCategory.setColumns(10);
	}
	
	public RentInfo getBookNo() {
		int bookNo = Integer.parseInt(tfBookNo.getText().trim());
		BookInfo newBookInfo = new BookInfo(bookNo);
		return new RentInfo(newBookInfo);
	}

	public void clearTf() {
		tfBookTitle.setText("");
		tfBookNo.setText("");
		tfBookCategory.setText("");               
	}

}

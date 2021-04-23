package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.bookcategory.BookCategoryTablePanel;
import LibraryManagement.service.ReturnScreenService;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import LibraryManagement.panel.bookcategory.CategoryAddPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BookCategoryManagement extends JFrame implements MouseListener {

	private JPanel contentPane;
	private ReturnScreenService service;
	private BookCategoryTablePanel pCategoryTable;
	private CategoryAddPanel pCategoryAdd;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookCategoryManagement frame = new BookCategoryManagement();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookCategoryManagement() {
		service = new ReturnScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("도서구분 관리");
		contentPane.setBorder(new TitledBorder(null, "도서구분 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		pCategoryAdd = new CategoryAddPanel();
		contentPane.add(pCategoryAdd, BorderLayout.NORTH);
		
		pCategoryTable = new BookCategoryTablePanel();
		pCategoryTable.getTable().addMouseListener(this);
		pCategoryTable.setService(service);
		pCategoryTable.loadData();
		contentPane.add(pCategoryTable, BorderLayout.CENTER);
		
		pCategoryAdd.setBcTable(pCategoryTable);
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == pCategoryTable.getTable()) {
			mouseClickedPCategoryTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedPCategoryTable(MouseEvent e) {
		BookCategory updateCategory = getItem();
		pCategoryAdd.getTfCategoryName().setText(updateCategory.getBookCategory());
		pCategoryAdd.getTfCategoryNo().setText(updateCategory.getCategoryNo()+"");
		pCategoryAdd.getTfCategoryNo().setEditable(false);
		pCategoryAdd.getBtnAdd().setText("수정");
	}
	
	public BookCategory getItem() {
		int row = pCategoryTable.getTable().getSelectedRow();
		int categoryNo = (int) pCategoryTable.getTable().getValueAt(row, 0);
		String bookCategory = (String) pCategoryTable.getTable().getValueAt(row, 1);
		if(row == -1) {
			throw	new NotSelectedException();
		}
		return new BookCategory(categoryNo,bookCategory);
	}
}

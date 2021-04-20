package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LibraryManagement.panel.bookcategory.BookCategoryTablePanel;
import LibraryManagement.service.ReturnScreenService;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class BookCategoryManagement extends JFrame {

	private JPanel contentPane;
	private ReturnScreenService service;
	private BookCategoryTablePanel pCategoryTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCategoryManagement frame = new BookCategoryManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookCategoryManagement() {
		service = new ReturnScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pCategoryTable = new BookCategoryTablePanel();
		pCategoryTable.setService(service);
		pCategoryTable.loadData();
		contentPane.add(pCategoryTable, BorderLayout.CENTER);
		
		
		JPanel pBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추 가");
		pBtns.add(btnAdd);
	}

}

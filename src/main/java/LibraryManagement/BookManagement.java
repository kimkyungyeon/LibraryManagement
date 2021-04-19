package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.panel.bookmanagement.BookInfoTablePanel;
import LibraryManagement.panel.bookmanagement.pBookSearch;
import LibraryManagement.service.ReturnScreenService;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookManagement extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ReturnScreenService service;
	private JButton btnAdd;
	private JButton btnUpdate;
	private pBookSearch pBookSearch;
	private BookInfoTablePanel pBookInfoTablePanel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagement frame = new BookManagement();
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
	public BookManagement() {
		service = new ReturnScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("도서관리");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pBookSearch = new pBookSearch();
		contentPane.add(pBookSearch, BorderLayout.NORTH);
		
		pBookInfoTablePanel = pBookSearch.getpBookTable();
		pBookInfoTablePanel.setService(service);
		pBookInfoTablePanel.loadData();
		contentPane.add(pBookInfoTablePanel, BorderLayout.CENTER);
		
		
		
		JPanel pBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("도서추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnUpdate = new JButton("도서수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		BookInsert frame = new BookInsert();
		frame.setBookTable(pBookInfoTablePanel);
		frame.setVisible(true);
		
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {
	}
}

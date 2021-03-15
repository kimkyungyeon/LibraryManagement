package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.panel.main.BookInfoTablePanel;
import LibraryManagement.panel.main.pBookSearch;
import LibraryManagement.panel.main.pMainBtns;
import LibraryManagement.panel.main.pMembInfoTablePanel;
import LibraryManagement.panel.main.pMembSearch;
import LibraryManagement.service.BookInfoService;
import LibraryManagement.service.MembInfoService;
import LibraryManagement.service.RentInfoService;
import LibraryManagement.panel.main.RentInfoTablePanel;

public class LibraryManagementMain extends JFrame {

	private JPanel contentPane;
	private MembInfoService membService;
	private BookInfoService bookService;
	private RentInfoService rentService;
	private pMembInfoTablePanel pMembInfoTable;
	private BookInfoTablePanel pBookInfoTable;
	private pMembSearch pMainMembSearch;
	private RentInfoTablePanel pMainRentTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagementMain frame = new LibraryManagementMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pMembInfoTablePanel getpMembInfoTable() {
		return pMembInfoTable;
	}
	
	

	

	/**
	 * Create the frame.
	 */
	public LibraryManagementMain() {
		membService = new MembInfoService();
		bookService = new BookInfoService();
		rentService = new RentInfoService();
		initialize();

	}
	private void initialize() {
		setTitle("도서 관리 프로그램(메인)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pMainBtns pMainBtns = new pMainBtns();
		contentPane.add(pMainBtns, BorderLayout.NORTH);
		
		JPanel pMainSearch = new JPanel();
		contentPane.add(pMainSearch, BorderLayout.CENTER);
		pMainSearch.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		pMainSearch.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pMainMembSearch = new pMembSearch();
		
		pLeft.add(pMainMembSearch, BorderLayout.NORTH);
		
		pMembInfoTable = pMainMembSearch.getEx();
		pMembInfoTable.setService(membService);
//		pMembInfoTable.selectByNoList(12001);
//		pMembInfoTable.initList();
//		pMembInfoTable.setList();
		pMembInfoTable.loadData();
		pLeft.add(pMembInfoTable);
		
		
		JPanel pRight = new JPanel();
		pMainSearch.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		pBookSearch pMainBookSearch = new pBookSearch();
		pRight.add(pMainBookSearch, BorderLayout.NORTH);
		
		pBookInfoTable = new BookInfoTablePanel();
		pBookInfoTable.setService(bookService);
		pBookInfoTable.loadData();
		pRight.add(pBookInfoTable, BorderLayout.CENTER);
		
		
		
	
//		pMainRentTable = 
		pMainRentTable = new RentInfoTablePanel();
		pMainRentTable.setSerivce(rentService);
//		pMainRentTable.selectRentInfoByMembNo(membinfo);
		contentPane.add(pMainRentTable, BorderLayout.SOUTH);
	}

}

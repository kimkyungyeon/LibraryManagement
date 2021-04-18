package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.panel.main.BookInfoTablePanel;
import LibraryManagement.panel.main.RentInfoTablePanel;
import LibraryManagement.panel.main.pBookSearch;
import LibraryManagement.panel.main.pMainBtns;
import LibraryManagement.panel.main.pMembInfoTablePanel;
import LibraryManagement.panel.main.pMembSearch;
import LibraryManagement.service.MainService;

public class LibraryManagementMain extends JFrame {

	private JPanel contentPane;
	private MainService service;
	private pMembInfoTablePanel pMembInfoTable;
	private BookInfoTablePanel pBookInfoTable;
	private pMembSearch pMainMembSearch;
	private RentInfoTablePanel pMainRentTable;
	private pBookSearch pMainBookSearch;
//	private static LibraryManagementMain frame;
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

//	public pMembInfoTablePanel getpMembInfoTable() {
//		return pMembInfoTable;
//	}
	
	
	
	


	/**
	 * Create the frame.
	 */
	public LibraryManagementMain() {
		service = new MainService();
		service.updateOverdate();
		initialize();

	}
	private void initialize() {
		setTitle("도서 관리 프로그램(메인)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
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
		
		pMembInfoTable = pMainMembSearch.getpMembTable();
		pMembInfoTable.setService(service);
//		pMembInfoTable.selectByNoList(12001);
//		pMembInfoTable.initList();
//		pMembInfoTable.setList();
		pMembInfoTable.loadData();
		pLeft.add(pMembInfoTable);
		
		
		JPanel pRight = new JPanel();
		pMainSearch.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		pMainBookSearch = new pBookSearch();
		pRight.add(pMainBookSearch, BorderLayout.NORTH);
		
		pBookInfoTable = pMainBookSearch.getpBookTable();
		pBookInfoTable.setService(service);
		pBookInfoTable.loadData();
		pRight.add(pBookInfoTable, BorderLayout.CENTER);
		
		
		
	
//		pMainRentTable = 
		
		pMainRentTable = pMembInfoTable.getRentList(); 
		pMainRentTable.setService(service);
		pMainRentTable.loadData();
//		pMainRentTable.initList();
//		pMainRentTable.blankTable();
//		pMainRentTable.selectRentInfoByMembNo(membinfo);
		
		contentPane.add(pMainRentTable, BorderLayout.SOUTH);

		
	}

}

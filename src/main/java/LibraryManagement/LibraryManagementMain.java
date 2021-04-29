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
import LibraryManagement.panel.rentScreen.pMembInfoTable;
import LibraryManagement.service.MainService;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryManagementMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MainService service;
	private pMembInfoTablePanel pMembInfoTable;
	private BookInfoTablePanel pBookInfoTable;
	private pMembSearch pMainMembSearch;
	private RentInfoTablePanel pMainRentTable;
	private pBookSearch pMainBookSearch;
	private JButton btnRent;
	private JButton btnBookInfo;
	private JButton btnReturn;
	private JButton btnMembInfo;
	private JButton btnRank;
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LibraryManagementMain frame = new LibraryManagementMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pMainBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pMainBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(pMainBtns, BorderLayout.NORTH);
		
		btnRent = new JButton("대출하기");
		btnRent.addActionListener(this);
		pMainBtns.add(btnRent);
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		pMainBtns.add(btnReturn);
		
		btnMembInfo = new JButton("회원관리");
		btnMembInfo.addActionListener(this);
		pMainBtns.add(btnMembInfo);
		
		btnBookInfo = new JButton("도서관리");
		btnBookInfo.addActionListener(this);
		pMainBtns.add(btnBookInfo);
		
		btnRank = new JButton("통계");
		btnRank.addActionListener(this);
		pMainBtns.add(btnRank);
//		pMainBtns pMainBtns = new pMainBtns();
//		contentPane.add(pMainBtns, BorderLayout.NORTH);
		
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRank) {
			actionPerformedBtnRank(e);
		}
		if (e.getSource() == btnMembInfo) {
			actionPerformedBtnMembInfo(e);
		}
		if (e.getSource() == btnReturn) {
			actionPerformedBtnReturn(e);
		}
		if (e.getSource() == btnBookInfo) {
			actionPerformedBtnBookInfo(e);
		}
		if (e.getSource() == btnRent) {
			actionPerformedBtnRent(e);
		}
	}
	protected void actionPerformedBtnRent(ActionEvent e) {
		RentScreen frame = new RentScreen();
		frame.setpMembTablePanel(pMembInfoTable);
		frame.setpBookTablePanel(pBookInfoTable);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnReturn(ActionEvent e) {
		ReturnScreen frame = new ReturnScreen();
		frame.setpBookTablePanel(pBookInfoTable);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnMembInfo(ActionEvent e) {
		MembManagement frame = new MembManagement();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnBookInfo(ActionEvent e) {
		BookManagement frame = new BookManagement();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnRank(ActionEvent e) {
		RankFrame frame = new RankFrame();
		frame.setVisible(true);
	}
}

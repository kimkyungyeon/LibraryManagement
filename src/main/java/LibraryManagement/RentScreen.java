package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.panel.rentScreen.pBookInfoTable;
import LibraryManagement.panel.rentScreen.pBookSearch;
import LibraryManagement.panel.rentScreen.pMembInfoTable;
import LibraryManagement.panel.rentScreen.pMembSearch;
import LibraryManagement.panel.rentScreen.pRentBookDetail;
import LibraryManagement.panel.rentScreen.pRentMembDetail;
import LibraryManagement.service.RentScreenService;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RentScreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private RentScreenService service;
	private pRentMembDetail pMembDetail;
	private pMembInfoTable pMembTable;
	private pMembSearch pMembSearch;
	private pBookInfoTable pBookTable;
	private pBookSearch pBookSearch;
	private pRentBookDetail pBookDetail;
	private JButton btnRent;
	private JButton btnCancel;
	
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RentScreen frame = new RentScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public pRentMembDetail getpMembDetail() {
		return pMembDetail;
	}
	public pMembInfoTable getpMembTable() {
		return pMembTable;
	}
	public void setpMembTable(pMembInfoTable pMembTable) {
		this.pMembTable = pMembTable;
	}
	public pBookInfoTable getpBookTable() {
		return pBookTable;
	}
	public void setpBookTable(pBookInfoTable pBookTable) {
		this.pBookTable = pBookTable;
	}
	public void setpMembDetail(pRentMembDetail pMembDetail) {
		this.pMembDetail = pMembDetail;
	}
	public pRentBookDetail getpBookDetail() {
		return pBookDetail;
	}
	public void setpBookDetail(pRentBookDetail pBookDetail) {
		this.pBookDetail = pBookDetail;
	}
	
	
	public RentScreen() {
		service = new RentScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		setTitle("도서 관리 프로그램(대여 화면)");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		
		
		JPanel pRentCenter = new JPanel();
		contentPane.add(pRentCenter);
		pRentCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		pRentCenter.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		//렌트화면 멤버콤보박스
		pMembSearch = new pMembSearch();
		panel.add(pMembSearch, BorderLayout.NORTH);
		
		//렌트화면 멤버리스트
		pMembTable = pMembSearch.getpMembTable();
		pMembTable.setService(service);
		pMembTable.loadData();
		panel.add(pMembTable, BorderLayout.CENTER);
		
		//렌트화면 회원상세
		pMembDetail = pMembTable.getMembDetail();
		pRentCenter.add(pMembDetail);
//		pMembDetail.setLayout(new BoxLayout(pMembDetail, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		pRentCenter.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//렌트화면 콤보박스
		pBookSearch = new pBookSearch();
		panel_1.add(pBookSearch, BorderLayout.NORTH);
		
		
		//렌트화면 북리스트
		pBookTable = pBookSearch.getpBookTable();
		pBookTable.setService(service);
		pBookTable.loadData();
		panel_1.add(pBookTable);
		
		
		pBookDetail = pBookTable.getBookDetail();
		pRentCenter.add(pBookDetail);
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		JPanel pRentSouth = new JPanel();
		FlowLayout fl_pRentSouth = (FlowLayout) pRentSouth.getLayout();
		fl_pRentSouth.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pRentSouth, BorderLayout.SOUTH);
		
		btnRent = new JButton("대여하기");
		btnRent.addActionListener(this);
		pRentSouth.add(btnRent);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pRentSouth.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnRent) {
			actionPerformedBtnRent(e);
		}
	}
	protected void actionPerformedBtnRent(ActionEvent e) {
		try {
			service.rentBookTransaction(pMembDetail.getMembNo(), pBookDetail.getBookNo());
			JOptionPane.showMessageDialog(null, pMembDetail.getMembNo().getMembno()+ "회원의" +pBookDetail.getBookNo().getBookNo()+"도서 대출이 완료되었습니다.");
		}catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "회원, 도서정보를 입력하세요", "에러", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "대여 불가능합니다.","오류",JOptionPane.ERROR_MESSAGE);
		}
//		String str = String.format(pMembDetail.getMembNo()+ "회원의" +pBookDetail.getBookNo()+"도서 대출이 완료되었습니다.", args)
//		System.out.println(pMembDetail.getMembNo()+ "회원의" +pBookDetail.getBookNo()+"도서 대출이 완료되었습니다.");
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pMembDetail.clearTf();
		pBookDetail.clearTf();
		
	}
}

package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagement.panel.returnscreen.pMembInfoTable;
import LibraryManagement.panel.returnscreen.pMembSearch;
import LibraryManagement.panel.returnscreen.pRentInfoTable;
import LibraryManagement.panel.returnscreen.pReturnBookDetail;
import LibraryManagement.panel.returnscreen.pReturnMembDetail;
import LibraryManagement.service.ReturnScreenService;

public class ReturnScreen extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private pMembSearch pMembSearch3;
	private pMembInfoTable pMembTable3;
	private pReturnMembDetail pMembDetail3;
	private ReturnScreenService service;
	private pRentInfoTable pRentTable3;
	private pReturnBookDetail pRentDetail3;
	private JButton btnClear;
	private JButton btnReturn;
	private static LibraryManagementMain main;
	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReturnScreen frame = new ReturnScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public pReturnMembDetail getpMembDetail3() {
		return pMembDetail3;
	}

	public void setpMembDetail3(pReturnMembDetail pMembDetail3) {
		this.pMembDetail3 = pMembDetail3;
	}

	public pReturnBookDetail getpRentDetail3() {
		return pRentDetail3;
	}

	public void setpRentDetail3(pReturnBookDetail pRentDetail3) {
		this.pRentDetail3 = pRentDetail3;
	}

	public ReturnScreen() {
		service = new ReturnScreenService();
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("도서 관리 프로그램(반납 화면)");

		
		JPanel pReturnCenter = new JPanel();
		contentPane.add(pReturnCenter, BorderLayout.CENTER);
		pReturnCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pMemb = new JPanel();
		pReturnCenter.add(pMemb);
		pMemb.setLayout(new BorderLayout(0, 0));
		
		pMembSearch3 = new pMembSearch();
		pMemb.add(pMembSearch3, BorderLayout.NORTH);
		
		pMembTable3 = pMembSearch3.getpMembTable();
		pMembTable3.setService(service);
		pMembTable3.loadData();
		pMemb.add(pMembTable3, BorderLayout.CENTER);
		
		pMembDetail3 = pMembTable3.getMembDetail();
		pMemb.add(pMembDetail3, BorderLayout.SOUTH);
		
		JPanel pBook = new JPanel();
		pReturnCenter.add(pBook);
		pBook.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("대여중인도서목록");
		pBook.add(lblNewLabel, BorderLayout.NORTH);
		
		pRentTable3 = pMembSearch3.getpMembTable().getRentTable();
		pRentTable3.setService(service);
		pRentTable3.loadData();
		pBook.add(pRentTable3, BorderLayout.CENTER);
		
		pRentDetail3 = pRentTable3.getRentDetail();
		pBook.add(pRentDetail3, BorderLayout.SOUTH);
		
		JPanel pReturnSouth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pReturnSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pReturnSouth, BorderLayout.SOUTH);
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		pReturnSouth.add(btnReturn);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pReturnSouth.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReturn) {
			actionPerformedBtnReturn(e);
		}
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
	}
	
	public pMembInfoTable getpMembTable3() {
		return pMembTable3;
	}

	public void setpMembTable3(pMembInfoTable pMembTable3) {
		this.pMembTable3 = pMembTable3;
	}

	public pRentInfoTable getpRentTable3() {
		return pRentTable3;
	}

	public void setpRentTable3(pRentInfoTable pRentTable3) {
		this.pRentTable3 = pRentTable3;
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pMembDetail3.clearTf();
		pRentDetail3.clearTf();
	}
	
	protected void actionPerformedBtnReturn(ActionEvent e) {
		try {
			service.returnBookTransaction(pRentTable3.getRentNo());
			JOptionPane.showMessageDialog(null, 
					pMembDetail3.getMembNo().getMembno()+" 회원의  "+ pRentDetail3.getBookNo().getBookNo().getBookNo()+"도서 반납이 완료되었습니다." );
			
			pRentTable3.selectRentInfoByMembNo(pMembDetail3.getMembNo());
			pRentTable3.setList();
			
		} catch (NullPointerException e1) {
			pRentTable3.initList();
			pRentTable3.setList();
		} catch (NumberFormatException | IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "회원, 도서정보를 입력하세요", "에러", JOptionPane.WARNING_MESSAGE);	
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "반납 불가능합니다.","오류",JOptionPane.ERROR_MESSAGE);
		}
	}

	
}

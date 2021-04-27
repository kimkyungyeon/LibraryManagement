package LibraryManagement;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.exception.FormatException;
import LibraryManagement.exception.InvalidCheckException;
import LibraryManagement.panel.membmanagement.MembInfoTablePanel;
import LibraryManagement.service.MainService;

public class MemberUpdate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMembNo;
	private JTextField tfMembName;
	private JTextField tfMembAccount;
	private JTextField tfMembBirth;
	private JTextField tfMembPhone;
	private JTextField tfMembAddr;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAccept;
	private JTextField tfMembTel;
	private MainService service;
	private MembInfoTablePanel pTable ;
//	private MembManagement membFrame = new MembManagement();



	public void setpTable(MembInfoTablePanel pTable) {
		this.pTable = pTable;
	}
	public MemberUpdate() {
		service = new MainService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		setTitle("회원수정");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblMembNo = new JLabel("회원번호");
		lblMembNo.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembNo);
		
		tfMembNo = new JTextField();
		tfMembNo.setEditable(false);
		contentPane.add(tfMembNo);
		tfMembNo.setColumns(10);
		
		JLabel lblMembName = new JLabel("회원이름");
		lblMembName.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembName.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembName);
		
		tfMembName = new JTextField();
		tfMembName.setFont(new Font("굴림", Font.PLAIN, 17));
		contentPane.add(tfMembName);
		tfMembName.setColumns(10);
		
		JLabel lblMembAccount = new JLabel("회원계정");
		lblMembAccount.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembAccount.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembAccount);
		
		tfMembAccount = new JTextField();
		tfMembAccount.setEditable(false);
		tfMembAccount.setColumns(10);
		contentPane.add(tfMembAccount);
		
		JLabel lblMembBirth = new JLabel("생년월일");
		lblMembBirth.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembBirth);
		
		tfMembBirth = new JTextField();
		tfMembBirth.setEditable(false);
		tfMembBirth.setColumns(10);
		contentPane.add(tfMembBirth);
		
		JLabel lblMembTel = new JLabel("전화번호");
		lblMembTel.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembTel.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembTel);
		
		tfMembTel = new JTextField();
		tfMembTel.setFont(new Font("굴림", Font.PLAIN, 17));
		tfMembTel.setColumns(10);
		contentPane.add(tfMembTel);
		
		JLabel lblMembPhone = new JLabel("휴대전화");
		lblMembPhone.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembPhone);
		
		tfMembPhone = new JTextField();
		tfMembPhone.setFont(new Font("굴림", Font.PLAIN, 17));
		tfMembPhone.setColumns(10);
		contentPane.add(tfMembPhone);
		
		JLabel lblMembAddr = new JLabel("주소");
		lblMembAddr.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembAddr.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembAddr);
		
		tfMembAddr = new JTextField();
		tfMembAddr.setFont(new Font("굴림", Font.PLAIN, 17));
		tfMembAddr.setColumns(10);
		contentPane.add(tfMembAddr);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		btnAccept = new JButton("수정");
		btnAccept.addActionListener(this);
		panel_1.add(btnAccept);
	}
	
	public void setItem(MembInfo membInfo) {
		tfMembNo.setText(membInfo.getMembno()+"");
		tfMembName.setText(membInfo.getMembName());
		tfMembAccount.setText(membInfo.getMembAccount());
		tfMembBirth.setText(membInfo.getMembBirth()+"");
		tfMembTel.setText(membInfo.getMembTel());
		tfMembPhone.setText(membInfo.getMembPhone());
		tfMembAddr.setText(membInfo.getMembAddr());
	}
	
	public MembInfo getItem() {
		typeCheck();
		validCheck();
		int membNo = Integer.parseInt(tfMembNo.getText().trim());
		String membName = tfMembName.getText().trim();
		String membAccount = tfMembAccount.getText().trim();	
		String membTel = tfMembTel.getText().trim();
		String membPhone = tfMembPhone.getText().trim();
		String membAddr = tfMembAddr.getText().trim();
		
		return new MembInfo(membNo, membAccount, membName, membTel, membPhone, membAddr);
	}
	
	public void typeCheck() {
		if (!(Pattern.matches("^[가-힣]*$", tfMembName.getText().trim())
				||Pattern.matches("^[가-힣]*$", tfMembAddr.getText().trim()))) {
			throw new FormatException();
		}
	}

	public void validCheck() {
		if(tfMembName.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
		if(tfMembAccount.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
		if(tfMembTel.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
		if(tfMembPhone.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
		if(tfMembAddr.getText().trim().equals("")) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			try {
			actionPerformedBtnAccept(e);
			}catch (FormatException e1) {
				JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidCheckException e1) {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	protected void actionPerformedBtnAccept(ActionEvent e) {
		MembInfo updateMemb = getItem();
		service.modifyMembInfo(updateMemb);
		pTable.loadData();
		dispose();
	}
}

package LibraryManagement;

import java.awt.GridLayout;
import java.util.Date;
import java.util.List;
import java.util.OptionalInt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.panel.membmanagement.MembInfoTablePanel;
import LibraryManagement.service.ReturnScreenService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberInsert extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMembNo;
	private JTextField tfMembName;
	private JTextField tfMembAccount;
	private JTextField tfMembTel;
	private JTextField tfMembPhone;
	private JTextField tfMembAddr;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAdd;
	private JDateChooser dcMembBirth;
	private MembInfoTablePanel pTable;
	private ReturnScreenService service;




	public void setpTable(MembInfoTablePanel pTable) {
		this.pTable = pTable;
	}
	public MemberInsert() {
		service = new ReturnScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		setTitle("회원추가");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblMembNo = new JLabel("회원번호");
		lblMembNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembNo);
		
		tfMembNo = new JTextField();
		tfMembNo.setEditable(false);
		tfMembNo.setText(getLastMembNo()+"");
		contentPane.add(tfMembNo);
		tfMembNo.setColumns(10);
		
		JLabel lblMembName = new JLabel("회원이름");
		lblMembName.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembName);
		
		tfMembName = new JTextField();
		contentPane.add(tfMembName);
		tfMembName.setColumns(10);
		
		JLabel lblMembAccount = new JLabel("회원계정");
		lblMembAccount.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembAccount);
		
		tfMembAccount = new JTextField();
		tfMembAccount.setColumns(10);
		contentPane.add(tfMembAccount);
		
		JLabel lblMembBirth = new JLabel("생년월일");
		lblMembBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembBirth);
		
		dcMembBirth = new JDateChooser();
		contentPane.add(dcMembBirth);
		
		JLabel lblMembTel = new JLabel("전화번호");
		lblMembTel.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembTel);
		
		tfMembTel = new JTextField();
		tfMembTel.setColumns(10);
		contentPane.add(tfMembTel);
		
		JLabel lblMembPhone = new JLabel("휴대전화");
		lblMembPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembPhone);
		
		tfMembPhone = new JTextField();
		tfMembPhone.setColumns(10);
		contentPane.add(tfMembPhone);
		
		JLabel lblMembAddr = new JLabel("주소");
		lblMembAddr.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembAddr);
		
		tfMembAddr = new JTextField();
		tfMembAddr.setColumns(10);
		contentPane.add(tfMembAddr);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);
	}
	
	public void setItem(MembInfo membInfo) {
		tfMembNo.setText(membInfo.getMembno()+"");
		tfMembName.setText(membInfo.getMembName());
		tfMembAccount.setText(membInfo.getMembAccount());
		tfMembTel.setText(membInfo.getMembTel());
		tfMembPhone.setText(membInfo.getMembPhone());
		tfMembAddr.setText(membInfo.getMembAddr());
	}
	
	public int getLastMembNo() {
//		System.out.println(service.showBookInfoAll());
		List<MembInfo> list = service.showMembInfoAll();

		OptionalInt maxMembNo = service.showMembInfoAll().parallelStream().mapToInt(MembInfo::getMembNo).max();
		int maxMembNo1 = maxMembNo.getAsInt() + 1;
		return maxMembNo1;
	}
	
	public MembInfo getItem() {
		String membAccount = tfMembAccount.getText().trim();
		String membName = tfMembName.getText().trim();
		Date membBirth = dcMembBirth.getDate();
		String membTel = tfMembTel.getText().trim();
		String membPhone = tfMembPhone.getText().trim();
		String membAddr = tfMembAddr.getText().trim();
		return new MembInfo(membAccount, membName, membBirth, membTel, membPhone, membAddr);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		MembInfo addMemb = getItem();
		service.addMembInfo(addMemb);
		pTable.loadData();
		dispose();
	}
}

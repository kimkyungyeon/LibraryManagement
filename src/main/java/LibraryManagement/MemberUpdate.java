package LibraryManagement;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import LibraryManagement.dto.MembInfo;
import javax.swing.JButton;
import java.awt.Font;

public class MemberUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField tfMembNo;
	private JTextField tfMembName;
	private JTextField tfMembAccount;
	private JTextField tfMembBirth;
	private JTextField tfMembTel;
	private JTextField tfMembPhone;
	private JTextField tfMembAddr;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAccept;



	public MemberUpdate() {
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
		tfMembTel.setColumns(10);
		contentPane.add(tfMembTel);
		
		JLabel lblMembPhone = new JLabel("휴대전화");
		lblMembPhone.setFont(new Font("굴림체", Font.PLAIN, 17));
		lblMembPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMembPhone);
		
		tfMembPhone = new JTextField();
		tfMembPhone.setColumns(10);
		contentPane.add(tfMembPhone);
		
		JLabel lblMembAddr = new JLabel("주소");
		lblMembAddr.setFont(new Font("굴림체", Font.PLAIN, 17));
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
		
		btnAccept = new JButton("수정");
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

}

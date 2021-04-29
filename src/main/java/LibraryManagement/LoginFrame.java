package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import LibraryManagement.dto.Login;
import LibraryManagement.service.LoginService;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfAccount;
	private JPasswordField pfPasswd;
	private JButton btnAccept;
	private LoginService service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		service = new LoginService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "로그인", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("로그인");
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("도서관리 프로그램");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblAccount = new JLabel("아이디");
		lblAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblAccount);
		
		tfAccount = new JTextField();
		tfAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfAccount);
		tfAccount.setColumns(10);
		
		JLabel lblPasswd = new JLabel("비밀번호");
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblPasswd);
		
		pfPasswd = new JPasswordField();
		pfPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(pfPasswd);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		btnAccept = new JButton("로그인");
		btnAccept.addActionListener(this);
		panel_1.add(btnAccept);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccept) {
			actionPerformedBtnAccept(e);
		}
	}
	protected void actionPerformedBtnAccept(ActionEvent e) {
		String admin = tfAccount.getText().trim();
		char[] pw = pfPasswd.getPassword();
		String passwd = "";
		for(char cha : pw) {
			Character.toString(cha);
			passwd += (passwd.equals("")) ? ""+cha+"" : ""+cha+"";
		}
		passwd.trim();
//		System.out.println(admin);
//		System.out.println(passwd);
		Login account = service.selectLoginUser(admin, passwd);
		
		if (account != null) {
			LibraryManagementMain frame = new LibraryManagementMain();
			frame.setVisible(true);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			tfAccount.setText("");
			pfPasswd.setText("");
		}
	}
}

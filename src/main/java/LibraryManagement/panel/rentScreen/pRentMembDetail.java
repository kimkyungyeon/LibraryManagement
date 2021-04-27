package LibraryManagement.panel.rentScreen;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import LibraryManagement.dto.MembInfo;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.border.LineBorder;

public class pRentMembDetail extends JPanel {
	private JTextField tfMembTel;
	private JTextField tfMembPhone;
	private JTextField tfMembName;
	private JTextField tfMembNo;
	private JTextField tfBirthYear;
	private JTextField tfBirthMonth;
	private JTextField tfBirthDay;
	private JTextField tfMembAddr;

	/**
	 * Create the panel.
	 */
	public pRentMembDetail() {

		initialize();
	}

	public JTextField getTfMembTel() {
		return tfMembTel;
	}

	public void setTfMembTel(JTextField tfMembTel) {
		this.tfMembTel = tfMembTel;
	}

	public JTextField getTfMembPhone() {
		return tfMembPhone;
	}

	public void setTfMembPhone(JTextField tfMembPhone) {
		this.tfMembPhone = tfMembPhone;
	}

	public JTextField getTfMembName() {
		return tfMembName;
	}

	public void setTfMembName(JTextField tfMembName) {
		this.tfMembName = tfMembName;
	}

	public JTextField getTfMembNo() {
		return tfMembNo;
	}

	public void setTfMembNo(JTextField tfMembNo) {
		this.tfMembNo = tfMembNo;
	}

	public JTextField getTfBirthYear() {
		return tfBirthYear;
	}

	public void setTfBirthYear(JTextField tfBirthYear) {
		this.tfBirthYear = tfBirthYear;
	}

	public JTextField getTfBirthMonth() {
		return tfBirthMonth;
	}

	public void setTfBirthMonth(JTextField tfBirthMonth) {
		this.tfBirthMonth = tfBirthMonth;
	}

	public JTextField getTfBirthDay() {
		return tfBirthDay;
	}

	public void setTfBirthDay(JTextField tfBirthDay) {
		this.tfBirthDay = tfBirthDay;
	}

	public JTextField getTfMembAddr() {
		return tfMembAddr;
	}

	public void setTfMembAddr(JTextField tfMembAddr) {
		this.tfMembAddr = tfMembAddr;
	}

	private void initialize() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "회원상세정보", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		JLabel lblMembName = new JLabel("이름 : ");
		lblMembName.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_4.add(lblMembName);

		tfMembName = new JTextField();
		tfMembName.setEditable(false);
		panel_4.add(tfMembName);
		tfMembName.setColumns(3);

		JLabel lblMembNo = new JLabel("       회원번호 : ");
		lblMembNo.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_4.add(lblMembNo);

		tfMembNo = new JTextField();
		tfMembNo.setEditable(false);
		panel_4.add(tfMembNo);
		tfMembNo.setColumns(3);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JLabel lblMembBirth = new JLabel("생년월일 : ");
		panel_5.add(lblMembBirth);

		tfBirthYear = new JTextField();
		tfBirthYear.setEditable(false);
		panel_5.add(tfBirthYear);
		tfBirthYear.setColumns(10);

		JLabel lblBirthYear = new JLabel(" 년     ");
		panel_5.add(lblBirthYear);

		tfBirthMonth = new JTextField();
		tfBirthMonth.setEditable(false);
		panel_5.add(tfBirthMonth);
		tfBirthMonth.setColumns(5);

		JLabel lblBirthMonth = new JLabel(" 월      ");
		panel_5.add(lblBirthMonth);

		tfBirthDay = new JTextField();
		tfBirthDay.setEditable(false);
		panel_5.add(tfBirthDay);
		tfBirthDay.setColumns(5);

		JLabel lblBirthDay = new JLabel(" 일     ");
		panel_5.add(lblBirthDay);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		JLabel lblMembAddr = new JLabel("주소 : ");
		panel_6.add(lblMembAddr);

		tfMembAddr = new JTextField();
		tfMembAddr.setEditable(false);
		panel_6.add(tfMembAddr);
		tfMembAddr.setColumns(10);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 5, 10));

		JLabel lblMembTel = new JLabel("전화번호 : ");
		lblMembTel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblMembTel);

		tfMembTel = new JTextField();
		tfMembTel.setEditable(false);
		panel_3.add(tfMembTel);
		tfMembTel.setColumns(10);

		JLabel lblMembPhone = new JLabel("휴대전화 : ");
		lblMembPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblMembPhone);

		tfMembPhone = new JTextField();
		tfMembPhone.setEditable(false);
		panel_3.add(tfMembPhone);
		tfMembPhone.setColumns(10);
	}

	public MembInfo getMembNo() {
		int membNo = 0;
		membNo = Integer.parseInt(tfMembNo.getText().trim());

//		JOptionPane.showMessageDialog(null, "회원정보를 입력하세요", "에러", JOptionPane.WARNING_MESSAGE);

		return new MembInfo(membNo);
	}

	public void clearTf() {
		tfMembTel.setText("");
		tfMembPhone.setText("");
		tfMembName.setText("");
		tfMembNo.setText("");
		tfBirthYear.setText("");
		tfBirthMonth.setText("");
		tfBirthDay.setText("");
		tfMembAddr.setText("");
	}

}

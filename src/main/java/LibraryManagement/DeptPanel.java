package LibraryManagement;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeptPanel extends JPanel {
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;

	/**
	 * Create the panel.
	 */
	public DeptPanel() {

		initialize();
	}
	private void initialize() {
		
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBD80\uC11C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblDeptNo = new JLabel("부서번호");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptNo);
		
		tfDeptNo = new JTextField();
		add(tfDeptNo);
		tfDeptNo.setColumns(10);
		
		JLabel lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);
		
		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		add(tfDeptName);
		
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}
	
	public Department getDepartment() {
		int deptNo = Integer.parseInt(tfDeptNo.getText().trim());
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());		
		
		return new Department(deptNo,deptName,floor);
		
	}
	
	public void setDepartment(Department department) {
//		tfDeptNo.setText(String.valueOf(department.getDeptNo()));
		tfDeptNo.setText(department.getDeptNo()+"");
		tfDeptName.setText(department.getDeptName());
		tfFloor.setText(department.getFloor()+"");
	}
	
	public void clearTf() {
//		tfDeptNo.setText(String.valueOf(department.getDeptNo()));
		tfDeptNo.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
	}
}

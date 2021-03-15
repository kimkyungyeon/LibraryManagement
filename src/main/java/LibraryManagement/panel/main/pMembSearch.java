package LibraryManagement.panel.main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LibraryManagement.LibraryManagementMain;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.service.MembInfoService;

@SuppressWarnings("serial")
public class pMembSearch extends JPanel implements ActionListener {
	private JTextField tfMembSearch;
	private JComboBox<String> cbMembSearchBy;
//	private MembInfoService service;
	private String s;
	private pMembInfoTablePanel ex;
	/**
	 * Create the panel.
	 */
	public pMembSearch() {
//		service = new MembInfoService();
		ex = new pMembInfoTablePanel();
		initialize();
		
		
	}
	
	public pMembInfoTablePanel getEx() {
		return ex;
	}

	public void setEx(pMembInfoTablePanel ex) {
		this.ex = ex;
	}
	private void addData() {
		String[] searchKey = {"회원번호", "이름", "계정"};
		
		for (String s : searchKey) {
			
			cbMembSearchBy.addItem(s);
		}
	}
	private void initialize() {
		setLayout(new GridLayout(0, 3, 5, 5));
		
		JLabel lblMembSearch = new JLabel("빠른 회원 검색 :");
		lblMembSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembSearch.setFont(new Font("굴림", Font.PLAIN, 15));
		add(lblMembSearch);
		
		cbMembSearchBy = new JComboBox<>();
		cbMembSearchBy.addActionListener(this);
		addData();
//		cbMembSearchBy.setSelectedIndex(-1);
		add(cbMembSearchBy);
		
		tfMembSearch = new JTextField();
		tfMembSearch.addActionListener(this);
		add(tfMembSearch);
		tfMembSearch.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbMembSearchBy) {
			actionPerformedCbMembSearchBy(e);
		}
		if (e.getSource() == tfMembSearch) {
			if(s.equals("회원번호")) {
			actionPerformedTfMembSearchByNo(e);
			}
		}
	}
	protected void actionPerformedTfMembSearchByNo(ActionEvent e) {
		int membNo = Integer.parseInt(tfMembSearch.getText().trim());
		System.out.println(s);
//		ex.setService(service);
		ex.selectByNoList(membNo);
		ex.setList();
//		System.out.println(service.showMembInfoByNo(new MembInfo(membNo)));
//		ex.loadData();

		
		
		
		
		
		
		
	}

	protected void actionPerformedCbMembSearchBy(ActionEvent e) {
		s  = cbMembSearchBy.getSelectedItem().toString();
		
	}
}

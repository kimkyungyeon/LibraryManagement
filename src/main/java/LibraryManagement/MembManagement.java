package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.panel.membmanagement.MembInfoTablePanel;
import LibraryManagement.service.MainService;
import LibraryManagement.panel.membmanagement.pMembSearch;

public class MembManagement extends JFrame implements ActionListener {

	private JButton btnUpdate;
	private pMembSearch pMembSearch;
	private MembInfoTablePanel pTable;
	private JPanel contentPane;
	private MainService service;

	


//					MembManagement frame = new MembManagement();
//					frame.setVisible(true);



	public MembManagement() {
		service = new MainService();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("회원관리");

		JPanel pBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBtns.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pBtns, BorderLayout.SOUTH);

		pMembSearch = new pMembSearch();
		contentPane.add(pMembSearch, BorderLayout.NORTH);


		pTable = pMembSearch.getpMembTable();
		pTable.setService(service);
		pTable.loadData();
		contentPane.add(pTable, BorderLayout.CENTER);

		
		btnAdd = new JButton("회원추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnUpdate = new JButton("회원수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);
		
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(popupMenuListener);
		popupMenu.add(addItem);
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(popupMenuListener);
		popupMenu.add(updateItem);



		return popupMenu;
	}

	ActionListener popupMenuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate(e);
			}
			if (e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			}

		}
	};
	private JButton btnAdd;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		MembInfo selMemb = pTable.getItem();
		MembInfo selectedMemb = service.showMembInfoByNo(selMemb).get(0);
		MemberUpdate frame = new MemberUpdate();
		frame.setpTable(pTable);
		frame.setVisible(true);
		frame.setItem(selectedMemb);
	}
	
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		MemberInsert frame = new MemberInsert();
		frame.setpTable(pTable);
		frame.setVisible(true);
	}
}

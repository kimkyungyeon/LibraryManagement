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

public class MembManagement extends JFrame implements ActionListener {

	private MembInfoTablePanel pTable;
	private JPanel contentPane;
	private MainService service;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembManagement frame = new MembManagement();
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

		JButton btnAdd = new JButton("회원추가");
		pBtns.add(btnAdd);

		btnUpdate = new JButton("회원수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);

		JButton btnDelete = new JButton("회원삭제");
		pBtns.add(btnDelete);

		pTable = new MembInfoTablePanel();
		
		pTable.setService(service);
		pTable.loadData();
		contentPane.add(pTable, BorderLayout.NORTH);

		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(popupMenuListener);
		popupMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(popupMenuListener);
		popupMenu.add(deleteItem);

		return popupMenu;
	}

	ActionListener popupMenuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("삭제")) {
				MembInfo selMemb = pTable.getItem();
				service.deleteMembInfo(selMemb);
				pTable.loadData();
			}
			if (e.getActionCommand().equals("수정")) {
				MembInfo selMemb = pTable.getItem();
				MembInfo selectedMemb = service.showMembInfoByNo(selMemb).get(0);
				MemberUpdate frame = new MemberUpdate();
				frame.setpTable(pTable);
				frame.setVisible(true);
				frame.setItem(selectedMemb);
			}

		}
	};
	private JButton btnUpdate;

	public void actionPerformed(ActionEvent e) {
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
	
	
}

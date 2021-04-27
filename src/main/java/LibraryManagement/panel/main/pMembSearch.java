package LibraryManagement.panel.main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LibraryManagement.dto.MembInfo;

@SuppressWarnings("serial")
public class pMembSearch extends JPanel implements ActionListener {
	private JTextField tfMembSearch;
	private JComboBox<String> cbMembSearchBy;
	private String tfString;
	private pMembInfoTablePanel pMembTable;

	/**
	 * Create the panel.
	 */
	public pMembSearch() {
//		service = new MembInfoService();
		pMembTable = new pMembInfoTablePanel();
		initialize();

	}

	public pMembInfoTablePanel getpMembTable() {
		return pMembTable;
	}

	public void setpMembTable(pMembInfoTablePanel ex) {
		this.pMembTable = ex;
	}

	// 콤보박스 키워드 추가
	private void addData() {
		String[] searchKey = { "회원번호", "이름", "계정" };

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
			if (tfString.equals("회원번호")) {
				// 메인화면 좌측 텍스트필드 빈칸 검색시 전체 회원 출력 예외처리

				try {
					actionPerformedTfMembSearchByNo(e);
				} catch (NumberFormatException e1) {
					if (tfMembSearch.getText().trim().equals("")) {
						pMembTable.loadData();
					} else {
						pMembTable.nullList();
						JOptionPane.showMessageDialog(null, "해당하는 회원이 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					}

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 회원이 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pMembTable.nullList();
				}
			}
			if (tfString.equals("이름")) {
				try {
					actionPerformedTfMembSearchByName(e);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 회원이 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pMembTable.nullList();
				}
			}
			if (tfString.equals("계정")) {
				try {
					actionPerformedTfMembSearchByAccount(e);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "해당하는 회원이 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					pMembTable.nullList();
				}
			}

		}
	}

	private void actionPerformedTfMembSearchByAccount(ActionEvent e) {
		String membAccount = tfMembSearch.getText().trim();

		pMembTable.selectByAcountList(membAccount);
		pMembTable.setList();
	}

	private void actionPerformedTfMembSearchByName(ActionEvent e) {
		String membName = tfMembSearch.getText().trim();
		pMembTable.selectByNameList(membName);
		pMembTable.setList();
	}

	protected void actionPerformedTfMembSearchByNo(ActionEvent e) {
		int membNo = Integer.parseInt(tfMembSearch.getText().trim());
		pMembTable.selectByNoList(membNo);
		pMembTable.setList();

	}

	protected void actionPerformedCbMembSearchBy(ActionEvent e) {
		tfString = cbMembSearchBy.getSelectedItem().toString();

	}
}

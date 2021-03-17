package LibraryManagement.panel.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.dto.SubMembInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;

public class pMembInfoTablePanel extends AbstractCustomTablePanel<MembInfo> implements MouseListener{
	private RentInfoTablePanel rentList;
	private MainService service;

	
	public pMembInfoTablePanel() {
		rentList = new RentInfoTablePanel();
		initialize();
	}
	private void initialize() {
		table.addMouseListener(this);
		
	}
	
	
	@Override
	public void initList() {
		list = service.showMembInfoAll();
	}
	
	// 콤보박스 회원번호 설정 후 검색 
	public void selectByNoList(int membNo) {
		
		list = service.showMembInfoByNo(new MembInfo(membNo));
		
	}
	
	public void selectByNameList(String membName) {
		list = service.showMembInfoByName(new MembInfo(membName));
		
	}
	
	public void selectByAcountList(String membAccount) {
		MembInfo membinfo = new SubMembInfo(membAccount);
		list = service.showMembInfoByAccoutn(membinfo);
	}
	
	public void blankTable() {
		Object[][] data = new Object[0][];
		
	}
	

	public RentInfoTablePanel getRentList() {
		return rentList;
	}
	
	public void setRentList(RentInfoTablePanel rentList) {
		this.rentList = rentList;
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] {
				"회원번호", "이름", "계정", "전화번호", "휴대전화"
		};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
		setTableCellWidth(100,130,150,270,270);
		
	}

	@Override
	public Object[] toArray(MembInfo t) {
		
		return new Object[] {
				t.getMembno(), t.getMembName(), t.getMembAccount(), t.getMembTel(), t.getMembPhone()
		};
	}
	
	public void setService(MainService service) {
		this.service = service;
	}


	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == table) {
			mousePressedThisTable(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedThisTable(MouseEvent e) {
		int idx = table.getSelectedRow();
		if (idx == -1) {
			throw new NotSelectedException();
		}
		//첫 메인화면 구동시 rentinfo테이블 null 예외처리
		try {
			System.out.println(list.get(idx));
		rentList.selectRentInfoByMembNo(list.get(idx));
//		System.out.println(service.showRentInfoByMembNo(list.get(idx)));
		rentList.setList();

		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "대여정보가 없습니다.");
		}
	}
}

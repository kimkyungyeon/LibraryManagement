  package LibraryManagement.panel.returnscreen;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.dto.SubMembInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;
import LibraryManagement.service.RentScreenService;
import LibraryManagement.service.ReturnScreenService;

public class pMembInfoTable extends AbstractCustomTablePanel<MembInfo> implements MouseListener{
//	private RentInfoTablePanel rentList;
	private pReturnMembDetail membDetail;
	private ReturnScreenService service;
	private pRentInfoTable rentTable;
//	private pReturnBookDetail rentBookDetail;

	
	public pMembInfoTable() {
//		rentList = new RentInfoTablePanel();
		membDetail = new pReturnMembDetail();
		rentTable = new pRentInfoTable();
//		rentBookDetail = new pReturnBookDetail();
		table.addMouseListener(this);
	}
	
	public pReturnMembDetail getMembDetail() {
		return membDetail;
	}

	public void nullList() {
		list = new ArrayList<MembInfo>();
	}
	

	@Override
	public void initList() {
		list = service.showMembInfoAll();
	}
	
	// 콤보박스 회원번호 설정 후 검색 
	public void selectByNoList(int membNo) {
		System.out.println(service);
		list = service.showMembInfoByNo(new MembInfo(membNo));
		
	}
	
	public void selectByNameList(String membName) {
		list = service.showMembInfoByName(new MembInfo(membName));
		
	}
	
	public void selectByAcountList(String membAccount) {
		MembInfo membinfo = new SubMembInfo(membAccount);
		list = service.showMembInfoByAccount(membinfo);
	}
	
	public void blankTable() {
		Object[][] data = new Object[0][];
		
	}
	

//	public RentInfoTablePanel getRentList() {
//		return rentList;
//	}
	
//	public void setRentList(RentInfoTablePanel rentList) {
//		this.rentList = rentList;
//	}
	
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
	
	public void setService(ReturnScreenService service) {
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
		int membNo = (int) table.getValueAt(idx, 0);
		if(idx==-1) {
			throw new NotSelectedException();
		}
		try {
		MembInfo selectedMembInfo = service.showMembInfoByNo1(membNo);
		setItem(selectedMembInfo);
		
		rentTable.selectRentInfoByMembNo(selectedMembInfo);
		rentTable.setList();
		
		
//		
//		if (idx == -1) {
//			throw new NotSelectedException();
//		}
//		//첫 메인화면 구동시 rentinfo테이블 null 예외처리
//		try {
//			MembInfo membInfo = list.get(idx);
//			setItem(membInfo);
////		System.out.println(service.showRentInfoByMembNo(list.get(idx)));
////		rentList.setList();

		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "대여정보가 없습니다.");
			rentTable.initList();
			rentTable.setList();
		}
	}

	public pRentInfoTable getRentTable() {
		return rentTable;
	}

	public void setRentTable(pRentInfoTable rentTable) {
		this.rentTable = rentTable;
	}

	//테이블에서 클릭하면 대여회원상세정보에 데이터 세팅
	public void setItem(MembInfo membInfo) {
		membDetail.getTfMembName().setText(membInfo.getMembName());
		membDetail.getTfMembNo().setText(membInfo.getMembno()+"");
		membDetail.getTfBirthYear().setText(membInfo.getMembBirth().getYear()+1900+"");
		membDetail.getTfBirthMonth().setText(membInfo.getMembBirth().getMonth()+1+"");
		membDetail.getTfBirthDay().setText(membInfo.getMembBirth().getDate()+"");
		membDetail.getTfMembAddr().setText(membInfo.getMembAddr());
		membDetail.getTfMembTel().setText(membInfo.getMembTel());
		membDetail.getTfMembPhone().setText(membInfo.getMembPhone());
	}
	
	public void searchMembNo(RentInfo rentInfo) {
		RentInfo newRentInfo = service.showRentInfoByRentNo(rentInfo);
		
		int idx = 0;
		for(int i = 0; i<list.size();i++) {
			if((int)table.getValueAt(i, 0) == newRentInfo.getMembNo().getMembno()) {
				idx = i;
				break;
			}
		}
		
		table.setRowSelectionInterval(idx, idx);
		table.scrollRectToVisible(new Rectangle(table.getCellRect(idx, idx, true)));
	}

	
	
}

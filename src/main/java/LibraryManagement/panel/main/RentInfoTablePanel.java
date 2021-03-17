package LibraryManagement.panel.main;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;
import LibraryManagement.service.RentInfoService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class RentInfoTablePanel extends AbstractCustomTablePanel<RentInfo>  {
	private MainService service;
	
	public RentInfoTablePanel() {
		initialize();
	}
	
	
	private void initialize() {
		setBorder(new TitledBorder(null, "현재 대여중인 도서목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public void initList() {
		list = null;
//		list= service.showRentInfoAll();
		
	}
	
	public void blankTable() {
		Object[][] data = new Object[0][];
		
	}
	
	//해당하는 리스트 초기화
	public void selectRentInfoByMembNo(MembInfo membinfo) {
		list = service.showRentInfoByMembNo(membinfo);
	} 
	
	
	
	@Override
	public String[] getColumnNames() {
		
		return new String[] {"대여번호", "도서번호", "도서제목", "도서연체일", "도서대여일"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
	}

	@Override
	public Object[] toArray(RentInfo t) {
	
		return new Object[] {t.getRentNo(), t.getBookNo().getBookNo(), t.getRentBookTitle(), t.getOverDate(), t.getRentDate()} ;
	}
	
	public void setService(MainService service) {
		this.service = service;
	}
	

	
}

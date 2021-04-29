package LibraryManagement.panel.returnscreen;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.ReturnScreenService;

public class pRentInfoTable extends AbstractCustomTablePanel<RentInfo> implements MouseListener {
	private pReturnBookDetail rentDetail;
	private ReturnScreenService service;
	
	
	public pReturnBookDetail getRentDetail() {
		return rentDetail;
	}

	public void setRentDetail(pReturnBookDetail rentDetail) {
		this.rentDetail = rentDetail;
	}

	/**
	 * Create the panel.
	 */
	public  void setService(ReturnScreenService service) {
		this.service = service;
	}
	
	public pRentInfoTable() {
		rentDetail = new pReturnBookDetail();
		table.addMouseListener(this);
	}

	//빈 테이블 초기화
	@Override
	public void initList() {
		list = new ArrayList<RentInfo>();
		
	}
	
	//회원번호로 대여정보 검색한 테이블
	public void selectRentInfoByMembNo(MembInfo membInfo) {
		try {
		list = service.showRentInfoByNo(membInfo);
		} catch (NullPointerException e) {
			
		}
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {
				"대여번호", "도서번호" , "도서제목" , "도서연체일", "도서대여일"
		};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
		setTableCellWidth(100,100,500,130,150);		
	}

	@Override
	public Object[] toArray(RentInfo t) {
		return new Object[] {
				t.getRentNo(), t.getBookNo().getBookNo(), t.getRentBookTitle(), t.getOverDate(), t.getRentDate()
		};
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == table) {
			mousePressedThisTable(e);
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private void mousePressedThisTable(MouseEvent e) {
		int idx = table.getSelectedRow();
		int bookNo = (int) table.getValueAt(idx, 1);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		
		try {
			List<BookInfo> rentBookInfo =  service.showBookInfoByNo(new BookInfo(bookNo));
			setItem(rentBookInfo.get(0));
		} catch (NullPointerException e1) {
//			//////////////////
		}
	}

	public void setItem(BookInfo bookInfo) {
		rentDetail.getTfBookTitle().setText(bookInfo.getBookTitle());
		rentDetail.getTfBookNo().setText(bookInfo.getBookNo()+"");
		rentDetail.getTfBookCategory().setText(bookInfo.getCategoryNo().getBookCategory());
		
	}

	public RentInfo getRentNo() {
		int idx = table.getSelectedRow();
		int rentNo = (int) table.getValueAt(idx, 0);
		int bookNo = (int) table.getValueAt(idx, 1);
		
		return new RentInfo(rentNo,new BookInfo(bookNo));
	}
	
	
	//Main화면에서 더블클릭하고 들어왔을때 테이블 클릭된것처럼 하는 메소드
	public void searchRentNo(RentInfo rentInfo) {
		RentInfo newRentInfo = service.showRentInfoByRentNo(rentInfo);
		
		int idx =0;
		for(int i = 0; i<list.size(); i++) {
			if((int)table.getValueAt(i, 0) == newRentInfo.getRentNo()) {
				idx = i;
				break;
			}
		}
		
		table.setRowSelectionInterval(idx, idx);
		table.scrollRectToVisible(new Rectangle(table.getCellRect(idx, idx, true)));
				
	}
	
	
}

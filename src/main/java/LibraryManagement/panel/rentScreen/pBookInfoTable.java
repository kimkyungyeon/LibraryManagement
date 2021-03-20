package LibraryManagement.panel.rentScreen;

import javax.swing.SwingConstants;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;

public class pBookInfoTable extends AbstractCustomTablePanel<BookInfo> {
	private MainService service;

	@Override
	public void initList() {
		list = service.showBookInfoAll();

	}
	//콤보박스 도서번호 선택후 검색
	public void selectByNoList(int bookNo) {
//		list = new ArrayList<BookInfo>();
		System.out.println(service);
		list = service.showBookInfoByNo(new BookInfo(bookNo));	
	}
	
	public void selectByTitleList(String bookTitle) {
		
	}

	@Override
	public String[] getColumnNames() {

		return new String[] { "도서번호", "도서제목", "도서구분", "대출여부" };
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3);
		setTableCellWidth(70,400,70,70);

	}

	@Override
	public Object[] toArray(BookInfo t) {
		return new Object[] {
				t.getBookNo(), t.getBookTitle(), t.getCategoryNo().getBookCategory(), t.isRentYN()
			};
	}
	
	public void setService(MainService service) {
		this.service = service;
	}
}

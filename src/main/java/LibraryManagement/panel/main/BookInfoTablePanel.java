package LibraryManagement.panel.main;

import javax.swing.SwingConstants;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.BookInfoService;

public class BookInfoTablePanel extends AbstractCustomTablePanel<BookInfo> {
	private BookInfoService service;

	@Override
	public void initList() {
		list = service.showBookInfoAll();

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
				t.getBookNo(), t.getBookTitle(), t.getCategoryNo(), t.isRentYN()
			};
	}
	
	public void setService(BookInfoService service) {
		this.service = service;
	}
}

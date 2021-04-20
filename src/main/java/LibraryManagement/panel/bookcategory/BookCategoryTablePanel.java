package LibraryManagement.panel.bookcategory;

import javax.swing.SwingConstants;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.ReturnScreenService;

public class BookCategoryTablePanel extends AbstractCustomTablePanel<BookCategory> {
	private ReturnScreenService service;

	@Override
	public void initList() {
		list = service.showBookCategoryAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {
				"구분번호","구분명"
		};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1);		
		setTableCellWidth(100,100);
		
	}

	@Override
	public Object[] toArray(BookCategory t) {
		return new Object[] {
				t.getCategoryNo(),t.getBookCategory()
		};
	}

	public void setService(ReturnScreenService service) {
		this.service = service;
	}
	
	

}

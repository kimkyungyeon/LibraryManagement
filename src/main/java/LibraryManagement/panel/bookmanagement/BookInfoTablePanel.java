package LibraryManagement.panel.bookmanagement;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.ReturnScreenService;

public class BookInfoTablePanel extends AbstractCustomTablePanel<BookInfo> {
	private ReturnScreenService service;
	
	@Override
	public void initList() {
		list = service.showBookInfoAll();
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setAlignAndWidth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray(BookInfo t) {
		// TODO Auto-generated method stub
		return null;
	}

}

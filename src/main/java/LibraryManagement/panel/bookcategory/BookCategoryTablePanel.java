package LibraryManagement.panel.bookcategory;

import javax.swing.SwingConstants;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.ReturnScreenService;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BookCategoryTablePanel extends AbstractCustomTablePanel<BookCategory> {
	public BookCategoryTablePanel() {
		initialize();
	}
	private void initialize() {
	}
	private ReturnScreenService service = new ReturnScreenService();

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
	
	

//	public void mouseClicked(MouseEvent e) {
//	}
//	public void mouseEntered(MouseEvent e) {
//	}
//	public void mouseExited(MouseEvent e) {
//	}
//	public void mousePressed(MouseEvent e) {
//		if (e.getSource() == table) {
//			mousePressedThisTable(e);
//		}
//	}
//	public void mouseReleased(MouseEvent e) {
//	}
//	protected void mousePressedThisTable(MouseEvent e) {
//		BookCategory bc = getItem();
//		
//	}
	
	public BookCategory getItem() {
		int row = table.getSelectedRow();
		int categoryNo = (int) table.getValueAt(row, 0);
		String bookCategory = (String) table.getValueAt(row, 1);
		if(row == -1) {
			throw	new NotSelectedException();
		}
		return new BookCategory(categoryNo,bookCategory);
	}
}

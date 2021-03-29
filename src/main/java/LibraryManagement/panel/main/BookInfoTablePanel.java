package LibraryManagement.panel.main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;

public class BookInfoTablePanel extends AbstractCustomTablePanel<BookInfo> {
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
		list = service.showBookInfoByTitle(new BookInfo(bookTitle));
	}

	public void selectByCategoryList(String bookCategory) {
		list = service.showBookInfoByCateogry(new BookInfo(new BookCategory(bookCategory)));
		System.out.println(list);
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
	
	public void setTableCellCondition(int...idx) {
		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i=0; i<idx.length; i++)
		tcm.getColumn(idx[i]).setCellRenderer(ctcr);
	}
	
	private class ConditionTableCellRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value == null ? ""  :value.toString());
			setOpaque(true);
			String isRent = (String) table.getValueAt(row, 3);
			if(isRent.equals("대출불가")) {
				setBackground(Color.PINK);
			} else{
				setBackground(Color.WHITE);
			}
			return this;
		}
	}

	@Override
	public void setList() {
		super.setList();
		setTableCellCondition(0,1,2,3);
	}
	
	
}

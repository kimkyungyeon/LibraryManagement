package LibraryManagement.panel.rentScreen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.RentScreenService;

public class pBookInfoTable extends AbstractCustomTablePanel<BookInfo> implements MouseListener {
	private RentScreenService service;
	private pRentBookDetail bookDetail;

	
	
	public pBookInfoTable() {
		bookDetail = new pRentBookDetail();
		table.addMouseListener(this);
	}
	@Override
	public void initList() {
		list = service.showBookInfoAll();

	}
	public pRentBookDetail getBookDetail() {
		return bookDetail;
	}
	//콤보박스 도서번호 선택후 검색
	public void selectByNoList(int bookNo) {
//		list = new ArrayList<BookInfo>();
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

		return new String[] { "도서번호", "도서제목", "도서구분", "대출여부", "권수"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
		setTableCellWidth(70,400,70,70);

	}

	@Override
	public Object[] toArray(BookInfo t) {
		return new Object[] {
				t.getBookNo(), t.getBookTitle(), t.getCategoryNo().getBookCategory(), t.isRentYN(), t.getCount()
			};
	}
	
	public void setService(RentScreenService service) {
		this.service = service;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == table) {
			mousePressedThisTable(e);
		}		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void mousePressedThisTable(MouseEvent e) {
		int idx = table.getSelectedRow();
		
		if(idx==-1) {
			throw new NotSelectedException();
		}
		
		try {
			BookInfo bookInfo = list.get(idx);
			System.out.println(bookInfo);
			setItem(bookInfo);
		} catch(NullPointerException e1){
			JOptionPane.showMessageDialog(null, "도서정보가없습니다.");
		}
	}
	//테이블에서 클릭하면 대여도서상세정보에 데이터 세팅
	private void setItem(BookInfo bookInfo) {
		bookDetail.getTfBookTitle().setText(bookInfo.getBookTitle());
		bookDetail.getTfBookNo().setText(bookInfo.getBookNo()+"");
		bookDetail.getTfBookCategory().setText(bookInfo.getCategoryNo().getBookCategory());
	}
	
}

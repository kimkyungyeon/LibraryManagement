package LibraryManagement.panel.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import LibraryManagement.ReturnScreen;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.panel.rentScreen.pBookInfoTable;
import LibraryManagement.panel.returnscreen.pReturnMembDetail;
import LibraryManagement.service.MainService;
import LibraryManagement.service.ReturnScreenService;

public class RentInfoTablePanel extends AbstractCustomTablePanel<RentInfo> implements MouseListener   {
	private MainService service;
	private ReturnScreenService returnService = new ReturnScreenService();
	private pReturnMembDetail returnMembDetail;    
	private pBookInfoTable rentBookTable;
	
	
	
	public RentInfoTablePanel() {
		initialize();
		table.addMouseListener(this);
	}
	
	
	private void initialize() {
		setBorder(new TitledBorder(null, "현재 대여중인 도서목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public void initList() {
		list = new ArrayList<RentInfo>();
//		list= service.showRentInfoAll();
		
	}
	
	public void blankTable() {
		Object[][] data = new Object[0][];
		
	}
	
	//해당하는 리스트 초기화
	public void selectRentInfoByMembNo(MembInfo membinfo) {
		list = service.showRentInfoByMembNo(membinfo);
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
			int isRent = (int) table.getValueAt(row, 3);
			setTableAlign(SwingConstants.CENTER, 3);
			if(isRent>3) {
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
		setTableCellCondition(5);
	}


	@Override
	public String[] getColumnNames() {
		
		return new String[] {"대여번호", "도서번호", "도서제목", "도서연체일", "도서대여일","연체여부"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
		setTableCellWidth(100,100,100,100,100,30);
	}

	@Override
	public Object[] toArray(RentInfo t) {
	
		return new Object[] {t.getRentNo(), t.getBookNo().getBookNo(), t.getRentBookTitle(), t.getOverDate(), t.getRentDate()} ;
	}
	
	public void setService(MainService service) {
		this.service = service;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2) {
			mouseDoubleClickOpenReturnScreen();
		}
	}


	private void mouseDoubleClickOpenReturnScreen() {
		int idx = table.getSelectedRow();
		int rentNo = (int) table.getValueAt(idx, 0);
		int bookNo = (int) table.getValueAt(idx, 1);
		System.out.println(bookNo);
		if(idx == -1) {
			throw new NotSelectedException();
		}
		
		ReturnScreen frame = new ReturnScreen();
		frame.setVisible(true);
		RentInfo selectedRentInfo = returnService.showRentInfoByRentNo(new RentInfo(rentNo));
		
		int membNo = selectedRentInfo.getMembNo().getMembno();
		MembInfo memb = service.showMembInfoByNo1(membNo);
		System.out.println(memb);
		frame.getpMembTable3().setItem(memb);  //첫화면 대여정보 더블클릭하면 반납화면 디테일 세팅
		
		frame.getpMembTable3().getRentTable().selectRentInfoByMembNo(memb); //대여화면 하단 대여 도서 리스트 세팅
		frame.getpMembTable3().searchMembNo(new RentInfo(rentNo));
		frame.getpMembTable3().getRentTable().setList();
		
		frame.getpRentTable3().setItem(service.showBookInfoByNo1(bookNo));
		frame.getpRentTable3().searchRentNo(new RentInfo(rentNo));
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
//	public void searchRentNo(RentInfo rentInfo) {
//		RentInfo newRentInfo = service.showRentInfoByRentNo(rentInfo);
//		
//		int idx =0;
//		for(int i = 0; i<list.size(); i++) {
//			if((int)table.getValueAt(i, 0) == newRentInfo.getRentNo()) {
//				idx = i;
//				break;
//			}
//		}
//		
//		table.setRowSelectionInterval(idx, idx);
//		table.scrollRectToVisible(new Rectangle(table.getCellRect(idx, idx, true)));
//				
//	}
	
	


}

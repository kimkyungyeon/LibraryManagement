package LibraryManagement.panel.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MembInfoService;
import java.awt.event.MouseListener;

public class pMembInfoTablePanel extends AbstractCustomTablePanel<MembInfo> implements MouseListener {
	public pMembInfoTablePanel() {
//		table.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				int membNo = 
//				super.mousePressed(e);
//			}
//			
//		});
		
		initialize();
	}
	private void initialize() {
		table.addMouseListener(this);
	}
	private MembInfoService service;
	
	
	@Override
	public void initList() {
		list = service.showMembInfoAll();
	}
	
	public void selectByNoList(int membNo) {
		list = service.showMembInfoByNo(new MembInfo(membNo));
		
	}
	
	

	@Override
	public String[] getColumnNames() {
		return new String[] {
				"회원번호", "이름", "계정", "전화번호", "휴대전화"
		};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4);
		setTableCellWidth(100,130,150,270,270);
		
	}

	@Override
	public Object[] toArray(MembInfo t) {
		
		return new Object[] {
				t.getMembno(), t.getMembName(), t.getMembAccount(), t.getMembTel(), t.getMembPhone()
		};
	}
	
	public void setService(MembInfoService service) {
		this.service = service;
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == table) {
			mousePressedThisTable(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedThisTable(MouseEvent e) {
	}
}

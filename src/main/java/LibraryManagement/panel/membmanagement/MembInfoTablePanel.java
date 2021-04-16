package LibraryManagement.panel.membmanagement;

import javax.swing.SwingConstants;

import LibraryManagement.dto.MembInfo;
import LibraryManagement.exception.NotSelectedException;
import LibraryManagement.panel.AbstractCustomTablePanel;
import LibraryManagement.service.MainService;

public class MembInfoTablePanel extends AbstractCustomTablePanel<MembInfo> {
	private MainService service;
	
	@Override
	public void initList() {
		list = service.showMembInfoAll();		
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {
				"회원번호", "이름", "계정","생년월일", "전화번호", "휴대전화","주소"
		};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6);
		setTableCellWidth(100,100,150,250,270,270,100);
	}

	@Override
	public Object[] toArray(MembInfo t) {
		return new Object[] {
				t.getMembno(), t.getMembName(), t.getMembAccount(),
				t.getMembBirth(), t.getMembTel(), t.getMembPhone(),t.getMembAddr()
		};
	}
	
	public void setService(MainService service) {
		this.service = service;
	}
	
	public MembInfo getItem() {
		int row = table.getSelectedRow();
		int membNo = (int) table.getValueAt(row, 0);
		System.out.println(membNo);
		if(row == -1) {
			throw new NotSelectedException();
		}
		return new MembInfo(membNo);
	}

}

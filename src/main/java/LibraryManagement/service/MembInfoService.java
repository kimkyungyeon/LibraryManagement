package LibraryManagement.service;

import java.util.List;

import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dto.MembInfo;

public class MembInfoService {
	private MembInfoDao dao = MembInfoDaoImpl.getInstance();

	public List<MembInfo> showMembInfoAll() {
		return dao.selectMembInfoByAll();
	}

	public List<MembInfo> showMembInfoByNo(MembInfo membinfo) {
		return dao.selectMembInfoByMembNo(membinfo);
	}

}

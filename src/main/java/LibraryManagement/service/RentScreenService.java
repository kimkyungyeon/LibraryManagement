package LibraryManagement.service;

import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dto.MembInfo;

public class RentScreenService {
	private MembInfoDao membDao = MembInfoDaoImpl.getInstance();
	private BookInfoDao bookDao = BookInfoDaoImpl.getInstance();
	private RentInfoDao rentDao = RentInfoDaoImpl.getInstance();
	
	public List<MembInfo> showMembInfoAll() {
		return membDao.selectMembInfoByAll();
	}

	public List<MembInfo> showMembInfoByNo(MembInfo membInfo) {
		return membDao.selectMembInfoByMembNo(membInfo);
	}

	public List<MembInfo> showMembInfoByName(MembInfo membInfo) {
		return membDao.selectMembInfoByMembName(membInfo);
	}

	public List<MembInfo> showMembInfoByAccount(MembInfo membinfo) {
		return membDao.selectMembInfoByMembAccount(membinfo);
	}
}

package LibraryManagement.service;

import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public class MainService {
	private MembInfoDao membDao = MembInfoDaoImpl.getInstance();
	private RentInfoDao rentDao = RentInfoDaoImpl.getInstance();
	private BookInfoDao bookDao = BookInfoDaoImpl.getInstance();

	public List<MembInfo> showMembInfoAll() {
		return membDao.selectMembInfoByAll();
	}

	public List<MembInfo> showMembInfoByNo(MembInfo membinfo) {
		return membDao.selectMembInfoByMembNo(membinfo);
	}
	
	public List<MembInfo> showMembInfoByName(MembInfo membinfo){
		return membDao.selectMembInfoByMembName(membinfo);
	}

	public List<MembInfo> showMembInfoByAccoutn(MembInfo membinfo){
		return membDao.selectMembInfoByMembAccount(membinfo);
	}
	
	public List<RentInfo> showRentInfoByMembNo(MembInfo membInfo) {
		return rentDao.selectRentInfoByMembNo(membInfo);
	}
	
	public List<RentInfo> showRentInfoAll(){
		return rentDao.selectRentInfoByAll();
	}
	
	public List<BookInfo> showBookInfoAll(){
		return bookDao.selectBookInfoByAll();
	}
	
}

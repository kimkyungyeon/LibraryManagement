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
	
	public MembInfo showMembInfoByNo1(int membNo) {
		return membDao.selectMembInfoByMembNo(membNo);
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
	
	public int deleteMembInfo(MembInfo membInfo) {
		return membDao.deleteMembInfo(membInfo);
	}
	
	public int modifyMembInfo(MembInfo membInfo) {
		return membDao.updateMembInfo(membInfo);
	}
	
	public int updateOverdate() {
		return rentDao.updateBookOverDate();
	}
	
	public List<RentInfo> showRentInfoAll(){
		return rentDao.selectRentInfoByAll();
	}
	
	public List<BookInfo> showBookInfoAll(){
		return bookDao.selectBookInfoByAll();
	}
	
	public List<BookInfo> showBookInfoByNo(BookInfo	bookInfo){
		return bookDao.selectBookInfoByNo(bookInfo);
	}
	
	public BookInfo showBookInfoByNo1(int bookNo) {
		return bookDao.selectBookInfoByNo(bookNo);
	}

	public List<BookInfo> showBookInfoByTitle(BookInfo bookInfo) {
		return bookDao.selectBookInfoByTitle(bookInfo);
	}

	public List<BookInfo> showBookInfoByCateogry(BookInfo bookInfo) {
		return bookDao.selectBookInfoByCategory(bookInfo);
	}
	
	public RentInfo showRentInfoByRentNo(RentInfo rentInfo) {
		return rentDao.selectRentInfoByRentNo(rentInfo);
	}
	
}

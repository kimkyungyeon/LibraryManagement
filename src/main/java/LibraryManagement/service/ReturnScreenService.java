package LibraryManagement.service;

import java.sql.SQLException;
import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dao.impl.TransAction;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public class ReturnScreenService {
	private MembInfoDao membDao = MembInfoDaoImpl.getInstance();
	private BookInfoDao bookDao = BookInfoDaoImpl.getInstance();
	private RentInfoDao rentDao = RentInfoDaoImpl.getInstance();
	private TransAction transDao = TransAction.getInstance();
	
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
	
	public MembInfo showMembInfoByNo1(int membNo) {
		return membDao.selectMembInfoByMembNo(membNo);
	}
	
	public List<BookInfo> showBookInfoAll(){
		return bookDao.selectBookInfoByAll();
	}
	
	public List<BookInfo> showBookInfoByNo(BookInfo	bookInfo){
		return bookDao.selectBookInfoByNo(bookInfo);
	}
	
	public List<BookInfo> showBookInfoByTitle(BookInfo bookInfo){
		return bookDao.selectBookInfoByTitle(bookInfo);
	}
	
	public List<BookInfo> showBookInfoByCateogry(BookInfo bookInfo){
		return bookDao.selectBookInfoByCategory(bookInfo);
	}
	
	public List<RentInfo> showRentInfoAll(){
		return rentDao.selectRentInfoByAll();
	}
	
	public List<RentInfo> showRentInfoByNo(MembInfo membInfo){
		return rentDao.selectRentInfoByMembNo(membInfo);
	}
	
	public RentInfo showRentInfoByRentNo(RentInfo rentInfo) {
		return rentDao.selectRentInfoByRentNo(rentInfo);
	}
	
	public String rentBookTransaction(MembInfo membInfo, BookInfo bookInfo) throws SQLException {
		return transDao.transAddRentInfoAndUpdateBookInfo(membInfo, bookInfo);
	}
	
	public String returnBookTransaction(RentInfo rentInfo) throws SQLException {
		return transDao.transUpdateRentInfoAndUpdateBookInfo(rentInfo);
	}
	
	
	
}

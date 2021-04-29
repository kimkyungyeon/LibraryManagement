package LibraryManagement.service;

import java.sql.SQLException;
import java.util.List;

import LibraryManagement.dao.BookCategoryDao;
import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dao.impl.BookCategoryDaoImpl;
import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dao.impl.TransAction;
import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public class ReturnScreenService {
	private MembInfoDao membDao = MembInfoDaoImpl.getInstance();
	private BookInfoDao bookDao = BookInfoDaoImpl.getInstance();
	private RentInfoDao rentDao = RentInfoDaoImpl.getInstance();
	private BookCategoryDao categoryDao = BookCategoryDaoImpl.getInstance();
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
	
	public int addMembInfo(MembInfo membInfo) {
		return membDao.insertMembInfo(membInfo);
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
	
	public List<RentInfo> showRentInfoCount() {
		return rentDao.selectRentInfoCount();
	}
	
	public List<RentInfo> showRentInfoBookCount(){
		return rentDao.selectRentInfoBookCount();
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
	
	public List<BookCategory> showBookCategoryAll(){
		return categoryDao.selectBookCategoryByAll();
	}
	
	public int addBookCategory(BookCategory bc) {
		return categoryDao.insertBookCategory(bc);		
	}
	
	public int modifyBookCategory(BookCategory bc) {
		return categoryDao.updateBookCategory(bc);
	}
	
	public int addBookInfo(BookInfo bookInfo) {
		return bookDao.insertBookInfo(bookInfo);
	}
	
	public int modifyBookInfo(BookInfo bookInfo) {
		return bookDao.updateBookInfo(bookInfo);
	}
	
}

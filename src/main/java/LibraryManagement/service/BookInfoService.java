package LibraryManagement.service;

import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dto.BookInfo;

public class BookInfoService {
	private BookInfoDao dao = BookInfoDaoImpl.getInstance();
	
	public List<BookInfo> showBookInfoAll(){
		return dao.selectBookInfoByAll();
		
	}
}

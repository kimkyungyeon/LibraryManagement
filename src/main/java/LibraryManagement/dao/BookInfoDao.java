package LibraryManagement.dao;

import java.util.List;

import LibraryManagement.dto.BookInfo;

public interface BookInfoDao {
	List<BookInfo> selectBookInfoByAll();
	List<BookInfo> selectBookInfoByNo(BookInfo bookInfo);
	List<BookInfo> selectBookInfoByTitle(BookInfo bookInfo);
	List<BookInfo> selectBookInfoByCategory(BookInfo bookInfo);
	List<BookInfo> selectBookInfoByRentYN(BookInfo bookInfo);
	
	int insertBookInfo(BookInfo bookInfo);
	int updateBookInfo(BookInfo bookInfo);
	int deleteBookInfo(BookInfo bookInfo);
}

package LibraryManagement.dao;

import java.util.List;

import LibraryManagement.dto.BookCategory;

public interface BookCategoryDao {
	List<BookCategory> selectBookCategoryByAll();
	List<BookCategory> selectBookCategoryByCategoryNo(BookCategory bc);
	List<BookCategory> selectBookCategoryByCategory(BookCategory bc);
	
	int insertBookCategory(BookCategory bc);
	int updateBookCategory(BookCategory bc);
	int deleteBookCategory(BookCategory bc);
	

}

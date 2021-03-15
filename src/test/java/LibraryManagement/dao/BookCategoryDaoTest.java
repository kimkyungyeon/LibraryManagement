package LibraryManagement.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import LibraryManagement.dao.impl.BookCategoryDaoImpl;
import LibraryManagement.dto.BookCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookCategoryDaoTest {
	private static BookCategoryDao dao = BookCategoryDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectBookCategoryByAll() {
		System.out.println("SelectBookCategoryByAll");
		List<BookCategory> list = dao.selectBookCategoryByAll();
		Assert.assertNotNull(list);
		
		for(BookCategory bc : list) {
			System.out.println(bc);
		}
		
	}

	@Test
	public void testSelectBookCategoryByCategoryNo() {
		System.out.println("SelectBookCategoryByCategoryNo");
		BookCategory bc = new BookCategory(1);
		List<BookCategory> list = dao.selectBookCategoryByCategoryNo(bc);
		Assert.assertNotNull(list);
		
		for(BookCategory b : list) {
			System.out.println(b);
		}
	}

	@Test
	public void testSelectBookCategoryByCategory() {
		System.out.println("SelectBookCategoryByCategory");
		BookCategory bc = new BookCategory("퓨");
		List<BookCategory> list = dao.selectBookCategoryByCategory(bc);
		Assert.assertNotNull(list);
		
		for(BookCategory b : list) {
			System.out.println(b);
		}
	}

//	@Test
//	public void testInsertBookCategory() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateBookCategory() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteBookCategory() {
//		fail("Not yet implemented");
//	}

}

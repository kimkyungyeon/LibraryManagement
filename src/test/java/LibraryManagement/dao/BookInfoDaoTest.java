package LibraryManagement.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;

public class BookInfoDaoTest {
	private BookInfoDao dao = BookInfoDaoImpl.getInstance();
	
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
	public void testSelectBookInfoByAll() {
		
	}

	@Test
	public void testSelectBookInfoByNo() {
		System.out.println("testSelectBookInfoByAll");
		List<BookInfo> bookInfoList = dao.selectBookInfoByAll();
		Assert.assertNotNull(bookInfoList);
		
		for(BookInfo b : bookInfoList) {
			System.out.println(b);   
		}	}

//	@Test
//	public void testSelectBookInfoByTitle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectBookInfoByRentYN() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertBookInfo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateBookInfo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteBookInfo() {
//		fail("Not yet implemented");
//	}

}

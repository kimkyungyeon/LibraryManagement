package LibraryManagement.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dao.impl.BookInfoDaoImpl;
import LibraryManagement.dto.BookCategory;
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
		System.out.println("testSelectBookInfoByAll");
		List<BookInfo> bookInfoList = dao.selectBookInfoByAll();
		Assert.assertNotNull(bookInfoList);
		
		for(BookInfo b : bookInfoList) {
			System.out.println(b);   
		}	
	}

	@Test
	public void testSelectBookInfoByNo() {
		System.out.println("testSelectBookInfoByNo");
		BookInfo newBookInfo = new BookInfo(40001);
		List<BookInfo> bookInfoList = dao.selectBookInfoByNo(newBookInfo);
		Assert.assertNotNull(bookInfoList);
		
		for(BookInfo b : bookInfoList) {
			System.out.println(b);   
		}	
		
	}

	@Test
	public void testSelectBookInfoByTitle() {
		System.out.println("testSelectBookInfoByTitle");
		BookInfo newBookInfo = new BookInfo("el");
		List<BookInfo> bookInfoList = dao.selectBookInfoByTitle(newBookInfo);
		Assert.assertNotNull(bookInfoList);
		
		for(BookInfo b : bookInfoList) {
			System.out.println(b);
		}
	}

//	@Test
//	public void testSelectBookInfoByRentYN() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testSelectBookInfoByCategory() {
		System.out.println("testSelectBookInfoByCategory");
		BookInfo newBookInfo = new BookInfo(new BookCategory("컴퓨터"));
		List<BookInfo> bookInfoList = dao.selectBookInfoByCategory(newBookInfo);
		Assert.assertNotNull(bookInfoList);
		
		for(BookInfo b : bookInfoList) {
			System.out.println(b);
		}
		
	}
//
//	@Test
	public void testInsertBookInfo() {
		System.out.println("testInsertBookInfo");
		BookInfo newBookInfo = new BookInfo(40011,"홍길동전",true,new BookCategory(1),6,5);
		int res = dao.insertBookInfo(newBookInfo);
	}
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

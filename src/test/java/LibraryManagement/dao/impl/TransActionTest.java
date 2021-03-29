package LibraryManagement.dao.impl;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;

public class TransActionTest {
	TransAction service = TransAction.getInstance();
	
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
	public void testTransAddRentInfoAndUpdateBookInfo() throws SQLException {
		System.out.println("transaction");
		MembInfo membInfo = new MembInfo(12008);
		BookInfo bookInfo = new BookInfo(40010);
		
		String res = service.transAddRentInfoAndUpdateBookInfo(membInfo, bookInfo);
		System.out.println(res);
		Assert.assertEquals("commit", res);
		
	}

}

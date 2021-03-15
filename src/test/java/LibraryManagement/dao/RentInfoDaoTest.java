package LibraryManagement.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public class RentInfoDaoTest {
	private RentInfoDao dao = RentInfoDaoImpl.getInstance();
	
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
	public void testSelectRentInfoByAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectRentInfoByRentNo() {
		System.out.println("selectRentInfoByRentNo");
		
		
		
	}

	@Test
	public void testSelectRentInfoByMembNo() {
		System.out.println("selectRentInfoByMembNo");
		MembInfo newMemb = new MembInfo(12001);
		List<RentInfo> searchMemb = dao.selectRentInfoByMembNo(newMemb);
		Assert.assertNotNull(searchMemb);
		System.out.println(searchMemb);
		}

	@Test
	public void testSelectRentInfoByBookNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertRentInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRentInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRentInfo() {
		fail("Not yet implemented");
	}

}

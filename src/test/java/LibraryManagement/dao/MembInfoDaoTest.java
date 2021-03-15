package LibraryManagement.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dto.MembInfo;

public class MembInfoDaoTest {
	private static MembInfoDao dao = MembInfoDaoImpl.getInstance();

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
	public void testSelectMembInfoByAll() {
		System.out.println("testSelectMembInfoByAll");
		List<MembInfo> membInfoList = dao.selectMembInfoByAll();
		Assert.assertNotNull(membInfoList);
		
		for(MembInfo m : membInfoList) {
			System.out.println(m);   
		}
	}

	@Test
	public void testSelectMembInfoByMembNo() {
		System.out.println("testSelectMembInfoByMembNo");
		MembInfo newMembInfo = new MembInfo(12001);
		List<MembInfo> membInfoListbyNo = dao.selectMembInfoByMembNo(newMembInfo);
		Assert.assertNotNull(membInfoListbyNo);
		System.out.println(membInfoListbyNo);
		
		
	}
//
//	@Test
//	public void testSelectMembInfoByMembName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectMembInfoByMembAccount() {
//		fail("Not yet implemented");
//	}
	
//	membno,membaccount,membName,membbirth,membtel,membphone,membaddr
	@Test
	public void testInsertMembInfo() {
		System.out.println("testInsertMembInfo");
		
		Date birthday = new Date(94,7,1);
		MembInfo membInfo =	new MembInfo("kykim", "김경연", birthday, "053-323-1241", "010-6510-7277", "대구");
		int res = dao.insertMembInfo(membInfo);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectMembInfoByAll());
}

//	@Test
//	public void testUpdateMembInfo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMembInfo() {
//		fail("Not yet implemented");
//	}

}

package LibraryManagement.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import LibraryManagement.dao.impl.MembInfoDaoImpl;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.SubMembInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

//	@Test
	public void test04SelectMembInfoByAll() {
		System.out.println("testSelectMembInfoByAll");
		List<MembInfo> membInfoList = dao.selectMembInfoByAll();
		Assert.assertNotNull(membInfoList);
		
		for(MembInfo m : membInfoList) {
			System.out.println(m);   
		}
	}

//	@Test
	public void test03SelectMembInfoByMembNo() {
		System.out.println("testSelectMembInfoByMembNo");
		MembInfo newMembInfo = new MembInfo(12001);
		List<MembInfo> membInfoListbyNo = dao.selectMembInfoByMembNo(newMembInfo);
		Assert.assertNotNull(membInfoListbyNo);
		System.out.println(membInfoListbyNo);
		
		
	}

//	@Test
	public void test02SelectMembInfoByMembName() {
		System.out.println("testSelectMembInfoByMembName");
		MembInfo newMembInfo = new MembInfo("길");
		List<MembInfo> membInfoListByName = dao.selectMembInfoByMembName(newMembInfo);
		Assert.assertNotNull(membInfoListByName);
		System.out.println(membInfoListByName);
	}

//	@Test
	public void test01SelectMembInfoByMembAccount() {
		System.out.println("testSelectMembInfoByMembAccount");
		MembInfo newMembInfo = new SubMembInfo("k");
		List<MembInfo> membInfoListByAccount = dao.selectMembInfoByMembAccount(newMembInfo);
		Assert.assertNotNull(membInfoListByAccount);
		
		System.out.println(membInfoListByAccount);
	}
	
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
	public void testUpdateMembInfo() {
		fail("Not yet implemented");
	}

//	@Testr
	public void testDeleteMembInfo() {
		fail("Not yet implemented");
	}

}

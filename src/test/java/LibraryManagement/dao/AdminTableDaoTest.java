package LibraryManagement.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import LibraryManagement.dao.impl.AdminTableDaoImpl;
import LibraryManagement.dto.AdminTable;

public class AdminTableDaoTest {
	private static AdminTableDaoImpl dao = AdminTableDaoImpl.getInstance();

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
	public void testSelectAdminById() {
		System.out.println("selectAdminById");
		AdminTable admin = dao.selectAdminById("admin", "rootroot");
		Assert.assertNotNull(admin);
	
		System.out.println(admin);
	
	}

}

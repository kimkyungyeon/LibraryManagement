package LibraryManagement.service;

import LibraryManagement.dao.LoginDao;
import LibraryManagement.dao.impl.LoginDaoImpl;
import LibraryManagement.dto.Login;

public class LoginService {
	private LoginDao dao = LoginDaoImpl.getInstance();

	public Login selectLoginUser(String id, String passwd) {
		return dao.selectLoginUser(id, passwd);
	}

//	private AdminTableDaoImpl dao = AdminTableDaoImpl.getInstance();
//	public AdminTable isCorrectAccount(String id, String passwd) {
//		return dao.selectAdminById(id, passwd);
//	}

}

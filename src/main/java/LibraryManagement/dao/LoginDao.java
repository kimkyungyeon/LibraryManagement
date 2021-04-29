package LibraryManagement.dao;

import LibraryManagement.dto.Login;

public interface LoginDao {
	Login selectLoginUser(String admin, String passwd);
}

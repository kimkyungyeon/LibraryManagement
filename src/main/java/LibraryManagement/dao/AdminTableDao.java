package LibraryManagement.dao;

import LibraryManagement.dto.AdminTable;

public interface AdminTableDao {
	public AdminTable selectAdminById(String id, String passwd);
}

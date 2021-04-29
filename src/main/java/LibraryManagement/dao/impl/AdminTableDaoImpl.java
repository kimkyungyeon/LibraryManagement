package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LibraryManagement.dao.AdminTableDao;
import LibraryManagement.dto.AdminTable;
import LibraryManagement.util.JdbcUtil;

public class AdminTableDaoImpl implements AdminTableDao {
	private static final AdminTableDaoImpl instance = AdminTableDaoImpl.getInstance();

	public static AdminTableDaoImpl getInstance() {
		return instance;
	}





	private AdminTableDaoImpl() {
	}

	@Override
	public AdminTable selectAdminById(String id, String passwd) {
		System.out.println(1);
		String sql = "select admin, passwd from adminTable where admin = ? and passwd = password(?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getAdminTable(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private AdminTable getAdminTable(ResultSet rs) throws SQLException {
		String admin = rs.getString("admin");
//		String passwd = rs.getString("passwd");
		return new AdminTable(admin);
	}


}

package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LibraryManagement.dao.LoginDao;
import LibraryManagement.dto.Login;
import LibraryManagement.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {
	private static LoginDaoImpl instance = new LoginDaoImpl();

	public static LoginDaoImpl getInstance() {
		return instance;
	}
	

	private LoginDaoImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Login selectLoginUser(String admin, String passwd) {
		String sql = "select admin, passwd from adminTable where admin=? and passwd=password(?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, admin);
			pstmt.setString(2, passwd);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getLogin(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Login getLogin(ResultSet rs) throws SQLException {
		String admin = rs.getString("admin");

		return new Login(admin);
	}

}

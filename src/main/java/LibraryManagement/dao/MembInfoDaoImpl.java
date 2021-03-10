package LibraryManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




import LibraryManagement.dto.MembInfo;
import LibraryManagement.util.JdbcUtil;

public class MembInfoDaoImpl implements MembInfoDao {

	@Override
	public List<MembInfo> selectMembInfoByAll() {
		String sql = "select membno as 회원번호, membaccount as 회원계정,membname as 회원이름,"
				+ " membtel as 회원번호, membphone as 휴대전화 from membinfo m ";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<MembInfo> selectMembInfoByMembNo(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembInfo> selectMembInfoByMembName(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembInfo> selectMembInfoByMembAccount(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMembInfo(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMembInfo(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMembInfo(MembInfo membInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

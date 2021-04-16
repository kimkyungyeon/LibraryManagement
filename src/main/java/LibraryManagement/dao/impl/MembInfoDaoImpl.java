package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import LibraryManagement.dao.MembInfoDao;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.util.JdbcUtil;

public class MembInfoDaoImpl implements MembInfoDao {
	public static final MembInfoDaoImpl instance = new MembInfoDaoImpl();

	public static MembInfoDaoImpl getInstance() {
		return instance;
	}

	private MembInfoDaoImpl() {
	}

	@Override
	public List<MembInfo> selectMembInfoByAll() {
		String sql = "select membno , membaccount ,membname ,membbirth , "
				+ " membtel , membphone  , membaddr  from membinfo m ";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<MembInfo> list = new ArrayList<MembInfo>();
				do {
					list.add(getMembInfo(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// public MembInfo(int membno, String membAccount, String membName, Date
	// membBirth, String membTel,String membPhone, String membAddr)
	private MembInfo getMembInfo(ResultSet rs) throws SQLException {
		int membNo = rs.getInt("membno");
		String membAccount = rs.getString("membaccount");
		String membName = rs.getString("membname");
		Date membBirth = rs.getDate("membbirth");
		String membTel = rs.getString("membtel");
		String membPhone = rs.getString("membphone");
		String membAddr = rs.getString("membaddr");

		return new MembInfo(membNo, membAccount, membName, membBirth, membTel, membPhone, membAddr);
	}

	@Override
	public List<MembInfo> selectMembInfoByMembNo(MembInfo membInfo) {
		String sql = "select membno , membaccount ,membname ,membbirth , membtel "
				+ " , membphone  , membaddr  from membinfo m  where membno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, membInfo.getMembno());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<MembInfo> list = new ArrayList<MembInfo>();
					do {
						list.add(getMembInfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MembInfo> selectMembInfoByMembName(MembInfo membInfo) {
		String sql = "select membno , membaccount , membname, membbirth , "
				+ " membtel , membphone, membaddr from membinfo where membname like ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, "%" + membInfo.getMembName() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<MembInfo> list = new ArrayList<MembInfo>();
					do {
						list.add(getMembInfo(rs));
					} while (rs.next());
					return list;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMembInfo(MembInfo membInfo) {
		String sql = "insert into membinfo (membaccount, membname, membbirth, membtel, membphone, membaddr) values ( ? , ? , ? , ? , ? , ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, membInfo.getMembAccount());
			pstmt.setString(2, membInfo.getMembName());
			pstmt.setTimestamp(3, new Timestamp(membInfo.getMembBirth().getTime()));
//		pstmt.setTimestamp(4, new Timestamp(MembInfo.getMembBirth().getTime()));
//		System.out.println("dd");
			pstmt.setString(4, membInfo.getMembTel());
			pstmt.setString(5, membInfo.getMembPhone());
			pstmt.setString(6, membInfo.getMembAddr());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMembInfo(MembInfo membInfo) {
		String sql = "update membinfo set membname = ?, membtel = ?, membphone = ?, membaddr = ? where membno =?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, membInfo.getMembName());
			pstmt.setString(2, membInfo.getMembTel());
			pstmt.setString(3, membInfo.getMembPhone());
			pstmt.setString(4, membInfo.getMembAddr());
			pstmt.setInt(5, membInfo.getMembno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMembInfo(MembInfo membInfo) {
		String sql = "delete from membinfo where membno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, membInfo.getMembno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<MembInfo> selectMembInfoByMembAccount(MembInfo membInfo) {
		String sql = "select membno , membaccount , membname, membbirth , "
				+ " membtel , membphone, membaddr from membinfo where membaccount like ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, "%" + membInfo.getMembAccount() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<MembInfo> list = new ArrayList<MembInfo>();
					do {
						list.add(getMembInfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MembInfo selectMembInfoByMembNo(int membNo) {
		String sql = "select membno , membaccount , membname, membbirth , "
				+ " membtel , membphone, membaddr from membinfo where membno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, membNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMembInfo(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.util.JdbcUtil;

public class TransAction {
	private static TransAction instance = new TransAction();

	public static TransAction getInstance() {
		return instance;
	}

	private TransAction() {
		// TODO Auto-generated constructor stub
	}

	public String transAddRentInfoAndUpdateBookInfo(MembInfo membInfo, BookInfo bookInfo) throws SQLException {
		String bookInfoSql = "update bookinfo set count = count-1 where (bookno = ? and rentyn = 1) ";
		String rentInfoSql = "insert into rentinfo (membno, bookno, rentdate, returndate, overdate) "
				+ " values (?, ?, now(), null, 0)";
		String bookInfoSql2 = "update bookinfo set rentyn = 0 where count = 0 ";

		String res = null;
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement bPstmt2 = null;
		PreparedStatement rPstmt = null;

		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);

			bPstmt = con.prepareStatement(bookInfoSql);
			bPstmt.setInt(1, bookInfo.getBookNo());
//			bPstmt.executeUpdate();  

			if (bPstmt.executeUpdate() == 0) {
				throw new SQLException();
			}

			rPstmt = con.prepareStatement(rentInfoSql);
			rPstmt.setInt(1, membInfo.getMembno());
			rPstmt.setInt(2, bookInfo.getBookNo());
			rPstmt.executeUpdate();

			bPstmt2 = con.prepareStatement(bookInfoSql2);
			bPstmt2.executeUpdate();

			con.commit();
			res = "commit";
		} catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		} finally {
			System.out.println(res);
			closeUtil(con, bPstmt, rPstmt, bPstmt2);
		}
		if (res.equals("rollback")) {
			throw new SQLException();
		}
		return res;
	}

	public String transUpdateRentInfoAndUpdateBookInfo(RentInfo rentInfo) throws SQLException {
		String bookInfoSql = "update bookinfo set count = count + 1 where bookno = ? and count <5";
		String rentInfoSql = "update rentinfo set returndate = now() where rentno = ? and returndate is null";
		String bookInfoSql2 = "update bookinfo set rentyn = 1 where count != 0 ";

		String res = null;
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement bPstmt2 = null;
		PreparedStatement rPstmt = null;

		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			bPstmt = con.prepareStatement(bookInfoSql);
			bPstmt.setInt(1, rentInfo.getBookNo().getBookNo());
			if (bPstmt.executeUpdate() == 0) {
				throw new SQLException();
			}
			
			rPstmt = con.prepareStatement(rentInfoSql);
			rPstmt.setInt(1, rentInfo.getRentNo());
			rPstmt.executeUpdate();

			bPstmt2 = con.prepareStatement(bookInfoSql2);
			bPstmt2.executeUpdate();

			con.commit();
			res = "commit";
		} catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		} finally {
			System.out.println(res);
			closeUtil(con, bPstmt, rPstmt, bPstmt2);
		}
		if (res.equals("rollback")) {
			throw new SQLException();
		}
		return res;
	}

	private void closeUtil(Connection con, PreparedStatement bPstmt, PreparedStatement rPstmt,
			PreparedStatement bPstmt2) {
		try {
			con.setAutoCommit(true);
			if (bPstmt != null)
				bPstmt.close();
			if (rPstmt != null)
				rPstmt.close();
			if (bPstmt2 != null)
				bPstmt2.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void rollbackUtil(Connection con) {
		try {
			System.out.println("rollback");
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

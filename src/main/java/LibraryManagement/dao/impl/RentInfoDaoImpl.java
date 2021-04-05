package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dto.BookCategory;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;
import LibraryManagement.util.JdbcUtil;

public class RentInfoDaoImpl implements RentInfoDao {
	private static RentInfoDaoImpl instance  = new RentInfoDaoImpl();
	
	public static RentInfoDaoImpl getInstance() {
		return instance;
	}

	private RentInfoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RentInfo> selectRentInfoByAll() {
		String sql = "select  r.rentno , r.membno, r.bookno, b.booktitle, r.overdate , r.rentdate , r.returndate , c.categoryno , c.bookcategory "
				+ " FROM bookinfo b JOIN rentinfo r " + 
				" ON b.bookno = r.bookno  join bookcategory c  on b.categoryno = c.categoryno ";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<RentInfo> list = new ArrayList<RentInfo>();{
					do {
						list.add(getRentInfo(rs));
					} while(rs.next());
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
	public List<RentInfo> selectRentInfoByRentNo(RentInfo rentInfo) {
		
		return null;
	}

	@Override
	public List<RentInfo> selectRentInfoByMembNo(MembInfo membInfo) {
		String sql = "SELECT r.rentno , r.membno, r.bookno, b.booktitle, r.overdate , r.rentdate , r.returndate , c.categoryno , c.bookcategory "
				+ " FROM bookinfo b JOIN rentinfo r " 
				+ "	ON b.bookno = r.bookno join bookcategory c  on b.categoryno = c.categoryno "
				+ " where r.membno = ? and returndate is null";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, membInfo.getMembno());
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<RentInfo> list = new ArrayList<RentInfo>();
					do {
						list.add(getRentInfo(rs));
					}while(rs.next());
					return list;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private RentInfo getRentInfo(ResultSet rs) throws SQLException {
		int rentNo = rs.getInt("r.rentno");
		MembInfo membNo = new MembInfo(rs.getInt("r.membno"));
		BookInfo bookNo = new BookInfo(rs.getInt("r.bookno"),rs.getString("b.booktitle"),new BookCategory(rs.getInt("c.categoryno"),rs.getString("c.bookcategory")));
		Date rentDate = rs.getDate("r.rentdate");
		Date returnDate = rs.getDate("r.returndate");
		int overDate = rs.getInt("r.overdate");
		
		return new RentInfo (rentNo , membNo, bookNo, rentDate, returnDate, overDate);
	}

	@Override
	public List<RentInfo> selectRentInfoByBookNo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRentInfo(RentInfo rentInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRentInfo(RentInfo rentInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRentInfo(RentInfo rentInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookOverDate() {
		String sql = "update rentinfo set overdate = (to_days(now())-to_days(rentdate))-3 "
				+ " where (to_days(now())-to_days(rentdate)) >3" ;
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

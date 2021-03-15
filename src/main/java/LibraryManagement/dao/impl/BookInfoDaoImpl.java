package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dto.BookInfo;
import LibraryManagement.util.JdbcUtil;

public class BookInfoDaoImpl implements BookInfoDao {
	private static final BookInfoDaoImpl instance = new BookInfoDaoImpl();
	
	public static BookInfoDaoImpl getInstance() {
		return instance;
	}
	
	private BookInfoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookInfo> selectBookInfoByAll() {
		String sql = "select bookno , booktitle , rentYN , categoryno , count , totalcount  from bookinfo";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<BookInfo> list = new ArrayList<BookInfo>();
				do {
					list.add(getBookInfo(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private BookInfo getBookInfo(ResultSet rs) throws SQLException {
		int bookNo = rs.getInt("bookno");
		String bookTitle = rs.getString("booktitle");
		boolean rentYN = rs.getBoolean("rentYN");
		int categoryNo = rs.getInt("categoryno");
		int count = rs.getInt("count");
		int totalCount = rs.getInt("totalcount");
		return new BookInfo(bookNo, bookTitle, rentYN, categoryNo, count, totalCount);
	}

	@Override
	public List<BookInfo> selectBookInfoByNo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookInfo> selectBookInfoByTitle(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookInfo> selectBookInfoByRentYN(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

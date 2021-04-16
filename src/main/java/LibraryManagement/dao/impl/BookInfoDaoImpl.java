package LibraryManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LibraryManagement.dao.BookInfoDao;
import LibraryManagement.dto.BookCategory;
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
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname ";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<BookInfo> list = new ArrayList<BookInfo>();
				do {
					list.add(getBookInfo(rs));
				} while (rs.next());
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
		BookCategory categoryNo = new BookCategory(rs.getInt("categoryno"), rs.getString("bookcategory"));
		int count = rs.getInt("count");
		int totalCount = rs.getInt("totalcount");
		return new BookInfo(bookNo, bookTitle, rentYN, categoryNo, count, totalCount);
	}

	@Override
	public List<BookInfo> selectBookInfoByNo(BookInfo bookInfo) {
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname where bookno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookInfo.getBookNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInfo> list = new ArrayList<BookInfo>();
					do {
						list.add(getBookInfo(rs));
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
	public List<BookInfo> selectBookInfoByTitle(BookInfo bookInfo) {
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname where booktitle like ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, "%" + bookInfo.getBookTitle() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInfo> list = new ArrayList<BookInfo>();
					do {
						list.add(getBookInfo(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookInfo> selectBookInfoByRentYN(BookInfo bookInfo) {
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname where retnYN = ?";
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

	@Override
	public List<BookInfo> selectBookInfoByCategory(BookInfo bookInfo) {
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname where bookcategory like ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, "%" + bookInfo.getCategoryNo().getBookCategory() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInfo> list = new ArrayList<BookInfo>();
					do {
						list.add(getBookInfo(rs));
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
	public BookInfo selectBookInfoByNo(int bookNo) {
		String sql = "select bookno , booktitle , rentYN , categoryno ,bookcategory , count , totalcount  from vw_book_categoryname where bookno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBookInfo(rs);
				}
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

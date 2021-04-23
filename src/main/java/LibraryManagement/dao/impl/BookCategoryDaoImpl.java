package LibraryManagement.dao.impl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LibraryManagement.dao.BookCategoryDao;
import LibraryManagement.dto.BookCategory;
import LibraryManagement.util.JdbcUtil;

public class BookCategoryDaoImpl implements BookCategoryDao {
	
	public static final BookCategoryDaoImpl instance = new BookCategoryDaoImpl();
	
	public static BookCategoryDaoImpl getInstance() {
		return instance;
	}
	

	private BookCategoryDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookCategory> selectBookCategoryByAll() {
		String sql = "select categoryno, bookcategory from bookcategory";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<BookCategory> list = new ArrayList<BookCategory>();
				do {
				list.add(getBookCategory(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private BookCategory getBookCategory(ResultSet rs) throws SQLException {
		int categoryNo = rs.getInt("categoryno");
		String bookCategory = rs.getString("bookcategory");
		return new BookCategory(categoryNo , bookCategory);
	}

	@Override
	public List<BookCategory> selectBookCategoryByCategoryNo(BookCategory bc) {
		String sql = "select  categoryno , bookcategory from bookcategory where categoryno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){
			pstmt.setInt(1, bc.getCategoryNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<BookCategory> list = new ArrayList<BookCategory>();
					do {
						list.add(getBookCategory(rs));
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
	public List<BookCategory> selectBookCategoryByCategory(BookCategory bc) {
		String sql = "select categoryno, bookcategory from bookcategory where bookcategory like ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1,"%"+ bc.getBookCategory()+"%");
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<BookCategory> list = new ArrayList<BookCategory>();
					do {
						list.add(getBookCategory(rs));
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
	public int insertBookCategory(BookCategory bc) {
		String sql = "insert into bookcategory values (? , ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, bc.getCategoryNo());
			pstmt.setString(2, bc.getBookCategory());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBookCategory(BookCategory bc) {
		String sql = "update bookcategory set bookcategory = ? where categoryno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, bc.getBookCategory());
			pstmt.setInt(2, bc.getCategoryNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBookCategory(BookCategory bc) {
		// TODO Auto-generated method stub
		return 0;
	}

}

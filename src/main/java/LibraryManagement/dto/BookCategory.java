package LibraryManagement.dto;

public class BookCategory {
	int categoryNo;
	String bookCategory;
	
	public BookCategory() {
		// TODO Auto-generated constructor stub
	}

	public BookCategory(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public BookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookCategory(int categoryNo, String bookCategory) {
		this.categoryNo = categoryNo;
		this.bookCategory = bookCategory;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", bookCategory , categoryNo);
	}

	
	
	
	
}

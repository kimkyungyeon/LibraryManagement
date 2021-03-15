package LibraryManagement.dto;

public class BookInfo {
	private int bookNo;
	private String bookTitle;
	private boolean rentYN;
	private int categoryNo;
	private int count;
	private int totalcount;
	
	public BookInfo() {
		// TODO Auto-generated constructor stub
	}

	public BookInfo(int bookNo) {
		this.bookNo = bookNo;
	}

	public BookInfo(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public BookInfo(boolean rentYN) {
		this.rentYN = rentYN;
	}

	public BookInfo(int bookNo, String bookTitle, boolean rentYN, int categoryNo, int count, int totalcount) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.rentYN = rentYN;
		this.categoryNo = categoryNo;
		this.count = count;
		this.totalcount = totalcount;
	}
	

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String isRentYN() {
		if (rentYN == true) {
			return "대출가능";
		} else {
			return "대출불가";
		}
		
	}

	public void setRentYN(boolean rentYN) {
		this.rentYN = rentYN;
	}
	
//	public String getCategoryNo() {
//		String s = null;
//		if (categoryNo ==1) {
//			s= "수학";
//		}else if (categoryNo ==2){
//			s= "컴퓨터";
//		}else if (categoryNo == 3) {
//			s = "공학";
//		} else if(categoryNo == 4) {
//			s = "문학";
//		}
//		return s;
//	}
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	@Override
	public String toString() {
		return String.format("BookInfo [bookNo=%s, bookTitle=%s, rentYN=%s, categoryNo=%s, count=%s, totalcount=%s]",
				bookNo, bookTitle, rentYN, categoryNo, count, totalcount);
	}
	

}

package LibraryManagement.dto;

import java.util.Date;

public class RentInfo {
	   private int rentNo;
	   private MembInfo membNo;
	   private BookInfo bookNo;
	   private Date rentDate;
	   private Date returnDate;
	   private int overDate;
	
	   public RentInfo(MembInfo membNo) {
		this.membNo = membNo;
	}

	public RentInfo(int rentNo) {
		this.rentNo = rentNo;
	}

	public RentInfo(BookInfo bookNo) {
		this.bookNo = bookNo;
	}

	public RentInfo(int rentNo, MembInfo membNo, BookInfo bookNo, Date rentDate, int overDate) {
		this.rentNo = rentNo;
		this.membNo = membNo;
		this.bookNo = bookNo;
		this.rentDate = rentDate;
		this.overDate = overDate;
	}

	public RentInfo(int rentNo, MembInfo membNo, BookInfo bookNo, Date rentDate, Date returnDate, int overDate) {
		this.rentNo = rentNo;
		this.membNo = membNo;
		this.bookNo = bookNo;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.overDate = overDate;
	}

	public int getRentNo() {
		return rentNo;
	}

	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}

	public MembInfo getMembNo() {
		return membNo;
	}

	public void setMembNo(MembInfo membNo) {
		this.membNo = membNo;
	}

	public BookInfo getBookNo() {
		return bookNo;
	}

	public void setBookNo(BookInfo bookNo) {
		this.bookNo = bookNo;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getOverDate() {
		return overDate;
	}

	public void setOverDate(int overDate) {
		this.overDate = overDate;
	}
	
	public String getRentBookTitle() {
		return bookNo.getBookTitle();
	}

	@Override
	public String toString() {
		return String.format("RentInfo [rentNo=%s, membNo=%s, bookNo=%s, rentDate=%s, returnDate=%s, overDate=%s]",
				rentNo, membNo, bookNo, rentDate, returnDate, overDate);
	}
	
	
}


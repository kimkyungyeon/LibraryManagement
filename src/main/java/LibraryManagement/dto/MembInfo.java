package LibraryManagement.dto;

import java.util.Date;

public class MembInfo {
	int membNo;
	String membAccount;
	String membName;
//	static Date today = new Date();
//	 Date membBirth;
	Date membBirth;
	String membTel;
	String membPhone;
	String membAddr;
	
	public MembInfo(String membAccount, String membName,Date birthday, String membTel, String membPhone,
			String membAddr) {
		this.membAccount = membAccount;
		this.membName = membName;
		this.membBirth = birthday;
		this.membTel = membTel;
		this.membPhone = membPhone;
		this.membAddr = membAddr;
	}




	public MembInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MembInfo(int membno) {
		this.membNo = membno;
	}
	
	


	public MembInfo(String membName) {
		this.membName = membName;
	}

	public MembInfo(int membno, String membAccount, String membName, Date membBirth, String membTel,
			String membPhone, String membAddr) {
		this.membNo = membno;
		this.membAccount = membAccount;
		this.membName = membName;
		this.membBirth = membBirth;
		this.membTel = membTel;
		this.membPhone = membPhone;
		this.membAddr = membAddr;
	}

	public int getMembno() {
		return membNo;
	}


	public void setMembno(int membno) {
		this.membNo = membno;
	}


	public String getMembAccount() {
		return membAccount;
	}


	public void setMembAccount(String membAccount) {
		this.membAccount = membAccount;
	}


	public String getMembName() {
		return membName;
	}


	public void setMembName(String membName) {
		this.membName = membName;
	}


	public Date getMembBirth() {
		return  membBirth;
	}


	public void setMembBirth(Date membBirth) {
		this.membBirth = membBirth;
	}


	public String getMembTel() {
		return membTel;
	}


	public void setMembTel(String membTel) {
		this.membTel = membTel;
	}


	public String getMembPhone() {
		return membPhone;
	}


	public void setMembPhone(String membPhone) {
		this.membPhone = membPhone;
	}


	public String getMembAddr() {
		return membAddr;
	}


	public void setMembAddr(String membAddr) {
		this.membAddr = membAddr;
	}




	@Override
	public String toString() {
		
		return String.format(
				"MembInfo [membno=%s, membAccount=%s, membName=%s, membBirth=%s, membTel=%s, membPhone=%s, membAddr=%s]",
				membNo, membAccount, membName, membBirth, membTel, membPhone, membAddr);
	}
	
	
}

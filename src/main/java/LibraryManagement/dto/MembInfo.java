package LibraryManagement.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MembInfo {
	int membno;
	String membAccount;
	String membName;
//	static Date today = new Date();
	SimpleDateFormat membBirth;
	String membTel;
	String membPhone;
	String membAddr;
	
	public MembInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MembInfo(int membno) {
		this.membno = membno;
	}
	
	


	public MembInfo(String membName) {
		this.membName = membName;
	}


	public MembInfo(int membno, String membAccount, String membName, SimpleDateFormat membBirth, String membTel,
			String membPhone, String membAddr) {
		this.membno = membno;
		this.membAccount = membAccount;
		this.membName = membName;
		this.membBirth = membBirth;
		this.membTel = membTel;
		this.membPhone = membPhone;
		this.membAddr = membAddr;
	}


	@Override
	public String toString() {
		return String.format(
				"MembInfo [membno=%s, membAccount=%s, membName=%s, membBirth=%s, membTel=%s, membPhone=%s, membAddr=%s]",
				membno, membAccount, membName, membBirth, membTel, membPhone, membAddr);
	}
	
	
}

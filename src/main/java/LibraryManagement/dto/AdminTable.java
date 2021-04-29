package LibraryManagement.dto;

public class AdminTable {
	private String admin;
	private String passwd;
	
	public AdminTable() {
		// TODO Auto-generated constructor stub
	}

	public AdminTable(String admin) {
		this.admin = admin;
	}
	
	public AdminTable(String admin, String passwd) {
		this.admin = admin;
		this.passwd = passwd;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return String.format("AdminTable [admin=%s, passwd=%s]", admin, passwd);
	}

	
	
	
}

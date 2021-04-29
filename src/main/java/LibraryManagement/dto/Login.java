package LibraryManagement.dto;

public class Login {
	private String admin;
	private String passwd;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String admin) {
		this.admin = admin;
	}

	public Login(String admin, String passwd) {
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
		return String.format("Login [admin=%s, passwd=%s]", admin, passwd);
	}
	
	
	

}

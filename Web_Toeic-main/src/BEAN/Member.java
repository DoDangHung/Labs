package BEAN;

public class Member {
	private String ho_ten, username, password, email,date;
	int cmt,testing;
	

	public int getCmt() {
		return cmt;
	}

	

	public Member(String ho_ten, String username, String password, String email, String date) {
		super();
		this.ho_ten = ho_ten;
		this.username = username;
		this.password = password;
		this.email = email;
		this.date = date;
	}



	public void setCmt(int cmt) {
		this.cmt = cmt;
	}

	public int getTesting() {
		return testing;
	}

	public void setTesting(int testing) {
		this.testing = testing;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Member(String ho_ten, String username, String password, String email) {
		super();
		this.ho_ten = ho_ten;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Member() {
		super();
	}

	public Member(String ho_ten, String username, int cmt, int testing) {
		super();
		this.ho_ten = ho_ten;
		this.username = username;
		this.cmt = cmt;
		this.testing = testing;
	}

	public Member(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

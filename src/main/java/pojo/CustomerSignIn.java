package pojo;

public class CustomerSignIn {
	String cname,email,pass;
	public CustomerSignIn(String email,String pass) {
		this.email = email;
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}
}

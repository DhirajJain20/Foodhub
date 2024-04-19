package pojo;

public class CustomerRegistration {
	String cname,email,pass;
	public CustomerRegistration(String cname,String email,String pass) {
		this.cname = cname;
		this.email = email;
		this.pass = pass;
	}
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}


}

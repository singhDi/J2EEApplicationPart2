package model;

public class PersonInfo {
	private String email;
	private String password, name, phone, gender;
	

	public PersonInfo() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String p) {
		this.phone = p;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String g) {
		this.gender = g;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonInfo[email =" + email + ",  password=" + password + "]";
	}
	
}

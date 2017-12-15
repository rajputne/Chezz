package entities;

public class BuyUser {
	private long id;
	private String name;
	private String password;
	private String telePhone;
	private String email;
	private String trueName;
	private String address;
	private String postBoy;
	private String passHint;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassHint() {
		return passHint;
	}
	public void setPassHint(String passHint) {
		this.passHint = passHint;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPostBoy() {
		return postBoy;
	}
	public void setPostBoy(String postBoy) {
		this.postBoy = postBoy;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

}

package entities;

public class SellUser {

	private long id;
	private String username;
	private String password;
	private String tetlePhone;
	private String eMail;
	private String trueName;
	private String address;
	private String postBoy;
	private String passHint;
	private int creditValue;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getCreditValue() {
		return creditValue;
	}
	public void setCreditValue(int creditValue) {
		this.creditValue = creditValue;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String mail) {
		eMail = mail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getTetlePhone() {
		return tetlePhone;
	}
	public void setTetlePhone(String tetlePhone) {
		this.tetlePhone = tetlePhone;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

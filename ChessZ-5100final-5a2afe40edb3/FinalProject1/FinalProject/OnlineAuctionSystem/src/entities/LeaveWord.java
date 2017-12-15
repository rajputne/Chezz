package entities;



public class LeaveWord {

	private long id;
	private long bUserid;
	private String content;
	private String ltime;
	
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}
	public long getBUserid() {
		return bUserid;
	}
	public void setBUserid(long userid) {
		bUserid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	
	
	
}

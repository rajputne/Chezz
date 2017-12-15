package entities;

public class Appraise {

	private long id;
	private long bUserId;
	private String appContent;
	private int appMark;
	public String getAppContent() {
		return appContent;
	}
	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}
	public int getAppMark() {
		return appMark;
	}
	public void setAppMark(int appMark) {
		this.appMark = appMark;
	}
	public long getBUserId() {
		return bUserId;
	}
	public void setBUserId(long userId) {
		bUserId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}

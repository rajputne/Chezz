package entities;

public class BuyGoodsInfo {

	private long id;
	private long buyUserId;
	private long goodsId;
	private int buyCount;
	private String buyTime;
	private Double buyPrice;
	private String sendAddress;
	private String sendFashion;
	private int isSucc;//只能为0和1
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public long getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(long buyUserId) {
		this.buyUserId = buyUserId;
	}
	
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getIsSucc() {
		return isSucc;
	}
	public void setIsSucc(int isSucc) {
		this.isSucc = isSucc;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getSendFashion() {
		return sendFashion;
	}
	public void setSendFashion(String sendFashion) {
		this.sendFashion = sendFashion;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
}

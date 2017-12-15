package entities;

public class GoodsInfo {

	private long id;
	private String goodsName;
	private String goodsDescription;
	private Double beginPrice;
	private String imagePath;
	private int goodsCount;
	private String enroTime;
	private long sellUserId;
	public Double getBeginPrice() {
		return beginPrice;
	}
	public void setBeginPrice(Double beginPrice) {
		this.beginPrice = beginPrice;
	}
	
	public String getEnroTime() {
		return enroTime;
	}
	public void setEnroTime(String enroTime) {
		this.enroTime = enroTime;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGoodsDescription() {
		return goodsDescription;
	}
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public long getSellUserId() {
		return sellUserId;
	}
	public void setSellUserId(long sellUserId) {
		this.sellUserId = sellUserId;
	}
	
	
	
}

package entities;

public class Succ {
	private long id;
	private String name;
	private String miaos;
	private int count;
	private Double price;
	private Double prices;
	private int buyCount;
	private long buyUserId;
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public long getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(long buyUserId) {
		this.buyUserId = buyUserId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMiaos() {
		return miaos;
	}
	public void setMiaos(String miaos) {
		this.miaos = miaos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrices() {
		return prices;
	}
	public void setPrices(Double prices) {
		this.prices = prices;
	}

}

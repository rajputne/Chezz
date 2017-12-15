/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Item;

/**
 *
 * @author chess
 */
public class Item {
    private String name;
    private int startPrice;
    private int minAcceptPrice;
    private int buyItNowPrice;
    private int currentPrice;
    private int ItemId;

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }
    

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getMinAcceptPrice() {
        return minAcceptPrice;
    }

    public void setMinAcceptPrice(int minAcceptPrice) {
        this.minAcceptPrice = minAcceptPrice;
    }

    public int getBuyItNowPrice() {
        return buyItNowPrice;
    }

    public void setBuyItNowPrice(int buyItNowPrice) {
        this.buyItNowPrice = buyItNowPrice;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

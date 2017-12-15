/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BidQueue;

import Business.Item.ItemDirectory;
import Business.Item.Item;

/**
 *
 * @author 111
 */
public class ReplenishRequest extends BidRequest {

    private int quantity;
    private Item item;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    

}

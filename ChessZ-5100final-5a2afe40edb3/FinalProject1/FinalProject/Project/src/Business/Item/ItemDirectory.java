/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Item;

import java.util.ArrayList;

/**
 *
 * @author chess
 */
public class ItemDirectory {
    private ArrayList<Item> itemDirectory;

    public ItemDirectory() {
        itemDirectory = new ArrayList<>();
    }

    public ArrayList<Item> getItemDirectory() {
        return itemDirectory;
    }

    public void setItemDirectory(ArrayList<Item> itemDirectory) {
        this.itemDirectory = itemDirectory;
    }
    
    public Item addItem() {
        Item item = new Item();
        itemDirectory.add(item);
        return item;
    }
    
    public void deleteAirlane(Item item) {
        itemDirectory.remove(item);
    }
    
}

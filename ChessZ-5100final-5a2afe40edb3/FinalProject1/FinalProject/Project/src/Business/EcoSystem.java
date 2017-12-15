/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.AuctionPlatform.AuctionPlatform;
import Business.Item.Item;
import Business.Item.ItemDirectory;
import Business.Market.Market;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author 111
 */
public class EcoSystem extends Organization {
    private static EcoSystem business;
    private ArrayList<Market> marketList;
    private ItemDirectory itemDirectory;
    
     public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

   public EcoSystem() { 
       super(null);
       marketList = new ArrayList<>();
       itemDirectory = new ItemDirectory();
    }

    public ArrayList<Market> getMarketList() {
        return marketList;
    }
    
    public Market creatAndAddMarket(){
   Market market =new Market();
   marketList.add(market);
   return market;
    }
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

       

        return true;
    }

    public ItemDirectory getItemDirectory() {
        return itemDirectory;
    }

    public void setItemDirectory(ItemDirectory itemDirectory) {
        this.itemDirectory = itemDirectory;
    }

    
    
    
}

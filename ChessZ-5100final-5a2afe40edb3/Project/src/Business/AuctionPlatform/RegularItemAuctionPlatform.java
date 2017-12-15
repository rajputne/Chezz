/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AuctionPlatform;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author 111
 */
public class RegularItemAuctionPlatform extends AuctionPlatform {
    public RegularItemAuctionPlatform(String name){
        super(name, AuctionPlatformType.RegularItemAuction);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}

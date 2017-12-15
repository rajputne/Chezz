/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AuctionPlatform;
import java.util.ArrayList;
/**
 *
 * @author 111
 */
public class AuctionPlatformDirectory {
    private ArrayList<AuctionPlatform> auctionplatformList;
    public AuctionPlatformDirectory(){
        auctionplatformList = new ArrayList<>();
    }

    public ArrayList<AuctionPlatform> getAuctionplatformList() {
        return auctionplatformList;
    }
    public AuctionPlatform createAndAddAuctionPlatform(String name, AuctionPlatform.AuctionPlatformType type){
        AuctionPlatform auctionplatform = null;
        if (type == AuctionPlatform.AuctionPlatformType.RegularItemAuction){
            auctionplatform = new RegularItemAuctionPlatform(name);
            auctionplatformList.add(auctionplatform);
        }
        else if( type == AuctionPlatform.AuctionPlatformType.EmploymentAuction){
            auctionplatform = new EmploymentAuctionPlatform(name);
            auctionplatformList.add(auctionplatform);
        }
        return auctionplatform;
    }
  
    
  
}

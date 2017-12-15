/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.AuctionPlatform.AuctionPlatformDirectory;

/**
 *
 * @author 111
 */
public class Market {
    private String name;
    private AuctionPlatformDirectory auctionplatformDirectory;
 
    public Market(){
        auctionplatformDirectory = new AuctionPlatformDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuctionPlatformDirectory getAuctionplatformDirectory() {
        return auctionplatformDirectory;
    }

    @Override
    public String toString(){
        return name;
    }
    
    
}

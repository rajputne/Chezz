/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.AuctionPlatform.AuctionPlatform;
import Business.Organization.Organization;
import Business.Organization.SellerOrganization;
import Business.UserAccount.UserAccount;
import Interface.Seller.SellerWorkArea;

//import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author 111
 */
public class SellerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount useraccount,Organization organization,AuctionPlatform auctionplatform,EcoSystem system) {
        return new SellerWorkArea(userProcessContainer,useraccount, (SellerOrganization)organization,auctionplatform,system);
    }
    
}

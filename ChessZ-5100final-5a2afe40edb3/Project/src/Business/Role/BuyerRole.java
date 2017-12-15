/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.AuctionPlatform.AuctionPlatform;
import Business.Organization.BuyerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.Buyer.BuyerWorkArea;
//import UserInterface.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author 111
 */
public class BuyerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount useraccount,Organization organization,AuctionPlatform auctionplatform,EcoSystem business) {
        return new BuyerWorkArea(userProcessContainer,useraccount, (BuyerOrganization)organization,auctionplatform,business);
    }
    
    
}

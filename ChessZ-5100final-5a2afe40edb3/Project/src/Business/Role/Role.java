/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.AuctionPlatform.AuctionPlatform;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author 111
 */
public abstract class Role {
    
    public enum RoleType{
        PlatformAdmin("PlatformAdmin"),
        Buyer("Buyer"),
        Seller("Seller");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        
        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount useraccount, 
            Organization organization, 
            AuctionPlatform auctionplatform,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}
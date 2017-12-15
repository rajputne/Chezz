/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.SellerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 111
 */
public class SellerOrganization extends Organization{

    public SellerOrganization() {
        super(Organization.Type.Seller.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SellerRole());
        return roles;
    }
     
   
    
    
}

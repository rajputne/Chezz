/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BuyerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 111
 */
public class BuyerOrganization extends Organization{

    public BuyerOrganization() {
        super(Organization.Type.Buyer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BuyerRole());
        return roles;
    }
     
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.PlatformAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 111
 */
public class PlatformAdminOrganization extends Organization{

    public PlatformAdminOrganization() {
        super(Type.PlatformAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        //roles.add(new PlatformAdminRole());
        return roles;
    }
     
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.BidQueue.BidQueue;
import Business.Item.ItemDirectory;
import java.util.ArrayList;

/**
 *
 * @author 111
 */
public abstract class Organization {

    private String name;
    private BidQueue bidQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private ItemDirectory itemDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Buyer("Buyer"), Seller("Seller"), PlatformAdmin("PlatformAdmin");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        bidQueue = new BidQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        itemDirectory = new ItemDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public BidQueue getBidQueue() {
        return bidQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBidQueue(BidQueue bidQueue) {
        this.bidQueue = bidQueue;
    }

    public ItemDirectory getItemDirectory() {
        return itemDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}


package Business.AuctionPlatform;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;


/**
 *
 * @author 111
 */
public abstract class AuctionPlatform extends Organization {
    private AuctionPlatformType auctionplatformType;
    private OrganizationDirectory organizationDirectory;
     public AuctionPlatform(String name, AuctionPlatformType type) {
        super(name);
        this.auctionplatformType = type;
         organizationDirectory = new OrganizationDirectory();
    }
     public enum AuctionPlatformType{

        RegularItemAuction("RegularItemAuction"),EmploymentAuction("EmploymentAuction");
         private String value;
         private AuctionPlatformType(String value){
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

    public AuctionPlatformType getAuctionplatformType() {
        return auctionplatformType;
    }

   public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}

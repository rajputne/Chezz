/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

/**
 *
 * @author 111
 */
public class SellingItems extends SellerOrganization {
    private String SellItemName;
    private String SellItemNumber;

    public String getSellItemName() {
        return SellItemName;
    }

    public void setSellItemName(String SellItemName) {
        this.SellItemName = SellItemName;
    }

    public String getSellItemNumber() {
        return SellItemNumber;
    }

    public void setSellItemNumber(String SellItemNumber) {
        this.SellItemNumber = SellItemNumber;
    }
    
    
}

/*
 * BuyerWorkArea.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package Interface.Buyer;

import Business.AuctionPlatform.AuctionPlatform;
import Business.EcoSystem;
import Business.Market.Market;
import Business.Organization.BuyerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author  raunak
 */
public class BuyerWorkArea extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    UserAccount userAccount;
    AuctionPlatform auctionPlatform;
    Market market;
    EcoSystem system;
    /** Creates new form AdminWorkAreaJPanel */
    public BuyerWorkArea(JPanel userProcessContainer,UserAccount userAccount,BuyerOrganization organization,AuctionPlatform auctionplatform,EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.auctionPlatform = auctionPlatform;
        this.market = market;
        this.system = system;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    //public BuyerWorkArea(JPanel userProcessContainer, UserAccount useraccount, Organization organization, AuctionPlatform auctionplatform) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPurchasedItems = new javax.swing.JButton();
        btnBiddingItems = new javax.swing.JButton();
        btnBrowseItems = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Work Area -Buyer");

        btnPurchasedItems.setText("PurchasedItems");
        btnPurchasedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchasedItemsActionPerformed(evt);
            }
        });

        btnBiddingItems.setText("BiddingItems");
        btnBiddingItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiddingItemsActionPerformed(evt);
            }
        });

        btnBrowseItems.setText("BrowseItems");
        btnBrowseItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBrowseItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBiddingItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPurchasedItems))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(btnBrowseItems)
                .addGap(27, 27, 27)
                .addComponent(btnBiddingItems)
                .addGap(21, 21, 21)
                .addComponent(btnPurchasedItems)
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPurchasedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchasedItemsActionPerformed

        PurchasedItems purchasedItems = new PurchasedItems(userProcessContainer, system);
        userProcessContainer.add("PurchasedItems", purchasedItems);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPurchasedItemsActionPerformed

    private void btnBiddingItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiddingItemsActionPerformed

        BiddingItems biddingItems = new BiddingItems(userProcessContainer);
        userProcessContainer.add("BiddingItems", biddingItems);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnBiddingItemsActionPerformed

    private void btnBrowseItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseItemsActionPerformed

        BrowseItems browseItems = new BrowseItems(userProcessContainer, system);
        userProcessContainer.add("BrowseItems", browseItems);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBrowseItemsActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBiddingItems;
    private javax.swing.JButton btnBrowseItems;
    private javax.swing.JButton btnPurchasedItems;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
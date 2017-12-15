/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BidQueue;

import java.util.ArrayList;

/**
 *
 * @author 111
 */
public class BidQueue {
    
    private ArrayList<BidRequest> workRequestList;

    public BidQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<BidRequest> getWorkRequestList() {
        return workRequestList;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Anjali
 */
public class ClaimWorkQueue {
    private ArrayList<ClaimWorkRequest> claimWorkRequestList;

    public ClaimWorkQueue() {
        claimWorkRequestList = new ArrayList();
    }

    public ArrayList<ClaimWorkRequest> getWorkRequestList() {
        return claimWorkRequestList;
    }
}

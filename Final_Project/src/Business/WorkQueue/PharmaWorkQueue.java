/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manasa
 */
public class PharmaWorkQueue {
    
    private ArrayList<PharmaWorkRequest> pharmacyList;

    public PharmaWorkQueue() {
        pharmacyList = new ArrayList<PharmaWorkRequest>();
    }

    public ArrayList<PharmaWorkRequest> getPharmaList() {
        System.out.println("inside get pharma="+pharmacyList);
        for(PharmaWorkRequest w: pharmacyList){
            System.out.println("inside get loop pharma="+w.getMedList());
        }
        return pharmacyList;
    }
    public void addPharmaRequest(PharmaWorkRequest pharmaReq) {
        System.out.println("inside add pharma="+pharmaReq.getMedList());
        this.pharmacyList.add(pharmaReq);
             for(PharmaWorkRequest w: pharmacyList){
            System.out.println("inside add loop pharma="+w.getMedList());
        }
    }
            public void removePharmaRequest(PharmaWorkRequest pharmaReq) {
        pharmacyList.remove(pharmaReq);
    }
    
        public void updatePharmaRequest(PharmaWorkRequest pharmaReq,List<PharmaWorkRequest> pharmaList){
            for(PharmaWorkRequest work: pharmaList){
                if(work.getId().equals(pharmaReq.getId())){
                   work=pharmaReq;
                }
            }
        }
        public PharmaWorkRequest getPharmaRequest(PharmaWorkRequest w){
            for(PharmaWorkRequest work: pharmacyList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}
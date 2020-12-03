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
        pharmacyList = new ArrayList();
    }

    public ArrayList<PharmaWorkRequest> getPharmaList() {
        return pharmacyList;
    }
    public void addPharmaRequest(PharmaWorkRequest pharmaReq) {
        pharmacyList.add(pharmaReq);
    }
            public void removePharmaRequest(PharmaWorkRequest pharmaReq) {
        pharmacyList.remove(pharmaReq);
    }
    
        public void updatePharmaRequest(PharmaWorkRequest pharmaReq,List<PharmaWorkRequest> labRequestList){
            for(PharmaWorkRequest work: pharmacyList){
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
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
//Pharmacy sends demand requests to manufacturing unit using this queue.
public class DrugDemandQueue {
    
    private ArrayList<DrugDemandWorkRequest> demandRequest;

    public DrugDemandQueue() {
        demandRequest = new ArrayList<DrugDemandWorkRequest>();
    }

    public ArrayList<DrugDemandWorkRequest> getDemandList() {
        return demandRequest;
    }
    public void addDemandRequest(DrugDemandWorkRequest demandReq) {
        this.demandRequest.add(demandReq);
    }
            public void removeDemandRequest(DrugDemandWorkRequest req) {
        demandRequest.remove(req);
    }
    
        public void updateDemandRequest(DrugDemandWorkRequest req,List<DrugDemandWorkRequest> demandRequest){
            for(DrugDemandWorkRequest work: demandRequest){
                if(work.getId().equals(req.getId())){
                   work=req;
                }
            }
        }
        public DrugDemandWorkRequest getDemandRequest(DrugDemandWorkRequest w){
            for(DrugDemandWorkRequest work: demandRequest){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}
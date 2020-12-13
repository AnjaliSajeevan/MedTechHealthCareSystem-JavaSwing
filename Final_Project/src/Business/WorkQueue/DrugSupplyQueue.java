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
//Manufacturing Unit fulfills pharmacy demands using this queue.
public class DrugSupplyQueue {
    
    private ArrayList<DrugSupplyWorkRequest> supplyRequest;

    public DrugSupplyQueue() {
        supplyRequest = new ArrayList<DrugSupplyWorkRequest>();
    }

    public ArrayList<DrugSupplyWorkRequest> getSupplyList() {
        return supplyRequest;
    }
    public void addSupplyRequest(DrugSupplyWorkRequest demandReq) {
        this.supplyRequest.add(demandReq);
    }
            public void removeSupplyRequest(DrugSupplyWorkRequest req) {
        supplyRequest.remove(req);
    }
    
        public void updateSupplyRequest(DrugSupplyWorkRequest req,List<DrugSupplyWorkRequest> supplyRequest){
            for(DrugSupplyWorkRequest work: supplyRequest){
                if(work.getId().equals(req.getId())){
                   work=req;
                }
            }
        }
        public DrugSupplyWorkRequest getSupplyRequest(DrugSupplyWorkRequest w){
            for(DrugSupplyWorkRequest work: supplyRequest){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}
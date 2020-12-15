/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raunak
 */
public class VaccineWorkQueue {
    
    private ArrayList<VaccineWorkRequest> vaccineRequestList;

    public VaccineWorkQueue() {
        vaccineRequestList = new ArrayList();
    }

    public ArrayList<VaccineWorkRequest> getVaccineRequestList() {
        return vaccineRequestList;
    }
    public void addWorkRequest(VaccineWorkRequest w) {
        vaccineRequestList.add(w);
    }
        public void removeWorkRequest(VaccineWorkRequest w) {
        vaccineRequestList.remove(w);
    }
    
        public void updateWorkRequest(VaccineWorkRequest w,List<VaccineWorkRequest> vaccineRequestList){
            for(VaccineWorkRequest work: vaccineRequestList){
                if(work.getVaccine().getId().equals(w.getVaccine().getId())){
                   work=w;
                }
            }
        }
        public VaccineWorkRequest getWorkRequest(VaccineWorkRequest w){
            for(VaccineWorkRequest work: vaccineRequestList){
                if(work.getVaccine().getId().equals(w.getVaccine().getId())){
                    return work;
                }
            }
            return null;
        }
    
}
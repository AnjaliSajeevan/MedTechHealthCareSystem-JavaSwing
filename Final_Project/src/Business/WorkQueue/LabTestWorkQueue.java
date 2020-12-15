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
public class LabTestWorkQueue {
    
    private ArrayList<LabTestWorkRequest> labRequestList;

    public LabTestWorkQueue() {
        labRequestList = new ArrayList();
    }

    public ArrayList<LabTestWorkRequest> getLabRequestList() {
        return labRequestList;
    }
    public void addLabRequest(LabTestWorkRequest w) {
        labRequestList.add(w);
    }
        public void removeLabRequest(LabTestWorkRequest w) {
        labRequestList.remove(w);
    }
    
        public void updateLabRequest(LabTestWorkRequest w,List<LabTestWorkRequest> labRequestList){
            for(LabTestWorkRequest work: labRequestList){
                if(work.getId().equals(w.getId())){
                   work=w;
                }
            }
        }
        public LabTestWorkRequest getLabRequest(LabTestWorkRequest w){
            for(LabTestWorkRequest work: labRequestList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}
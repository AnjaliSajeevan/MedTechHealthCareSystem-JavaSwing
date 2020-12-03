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
public class LabPatientWorkQueue {
    
    private ArrayList<LabPatientWorkRequest> labPatientList;

    public LabPatientWorkQueue() {
        labPatientList = new ArrayList();
    }

    public ArrayList<LabPatientWorkRequest> getLabPatientRequestList() {
        return labPatientList;
    }
    public void addLabPatientRequest(LabPatientWorkRequest w) {
        labPatientList.add(w);
    }
        public void removeLabPatientRequest(LabPatientWorkRequest w) {
        labPatientList.remove(w);
    }
    
        public void updateLabPatientRequest(LabPatientWorkRequest w,List<LabPatientWorkRequest> labPatientList){
            for(LabPatientWorkRequest work: labPatientList){
                if(work.getId().equals(w.getId())){
                   work=w;
                }
            }
        }
        public LabPatientWorkRequest getLabPatientRequest(LabPatientWorkRequest w){
            for(LabPatientWorkRequest work: labPatientList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}
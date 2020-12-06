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
public class EmergencyQueue {
    
    private ArrayList<EmergencyRequest> emergencyList;

    public EmergencyQueue() {
        emergencyList = new ArrayList();
    }

    public ArrayList<EmergencyRequest> getEmergencyRequestList() {
        return emergencyList;
    }
    public void addEmergencyRequest(EmergencyRequest w) {
        emergencyList.add(w);
    }
        public void removeEmergencyRequest(EmergencyRequest w) {
        emergencyList.remove(w);
    }
    
        public void updateEmergencyRequest(EmergencyRequest w,List<EmergencyRequest> emergencyList){
            for(EmergencyRequest work: emergencyList){
                if(work.toString().equals(w.toString())){
                   work=w;
                }
            }
        }
        public EmergencyRequest getEmergencyRequest(EmergencyRequest w){
            for(EmergencyRequest work: emergencyList){
               if(work.toString().equals(w.toString())){
                    return work;
                }
            }
            return null;
        }
    
}
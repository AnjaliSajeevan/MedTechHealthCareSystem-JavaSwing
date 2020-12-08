/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Anjali
 */
public class PatientHospitalAppointmentWorkQueue {
        private ArrayList<PatientHospitalAppointmentWorkRequest> hospitalAppointmentworkRequestList;

    public PatientHospitalAppointmentWorkQueue() {
        hospitalAppointmentworkRequestList = new ArrayList();
    }

    public ArrayList<PatientHospitalAppointmentWorkRequest> hospitalRequestList() {
        return hospitalAppointmentworkRequestList;
    }
    public void addhospitalRequestListWorkRequest(PatientHospitalAppointmentWorkRequest w) {
        hospitalAppointmentworkRequestList.add(w);
    }
    public void updateHospitalRequest(PatientHospitalAppointmentWorkRequest w,List<PatientHospitalAppointmentWorkRequest> HosRequestList){
            for(PatientHospitalAppointmentWorkRequest work: HosRequestList){
                if(work.getRequestNo().equals(w.getRequestNo())){
                   work=w;
                }
            }
        }
}

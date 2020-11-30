/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
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
}

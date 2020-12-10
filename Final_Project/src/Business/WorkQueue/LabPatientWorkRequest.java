/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class LabPatientWorkRequest {
       private Vaccine vaccine;
    private UserAccount patient;
    private int id;
    private String message;
    private String slotDate;
    private String slotTime;
    private String enterprise;
    private String labTestType;
    private UserAccount receiver;
    private UserAccount sender;
    private boolean covidCase;
    private Date completeDate;
    private Map<String,Date> statusMap;
        
   private static int count = 1;

    public LabPatientWorkRequest() {
        id = count;
        count++;
        statusMap = new HashMap<String,Date>();
        
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public UserAccount getPatient() {
        return patient;
    }

    public void setPatient(UserAccount patient) {
        this.patient = patient;
    }

    public String getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(String labTestType) {
        this.labTestType = labTestType;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getId() {
        return String.valueOf(id);
    }

 

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public Map<String, Date> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Date> statusMap) {
        this.statusMap = statusMap;
    }

    public boolean isCovidCase() {
        return covidCase;
    }

    public void setCovidCase(boolean covidCase) {
        this.covidCase = covidCase;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }


    

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}

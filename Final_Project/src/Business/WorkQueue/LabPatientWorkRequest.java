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

/**
 *
 * @author Manasa
 */
public class LabPatientWorkRequest {
       private Vaccine vaccine;
    private String patient;
    private int id;
    private String message;
    private String slotDate;
    private String slotTime;
    private String labTestType;
    private UserAccount receiver;
    private UserAccount sender;
        
   private static int count = 1;

    public LabPatientWorkRequest() {
        id = count;
        count++;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(String labTestType) {
        this.labTestType = labTestType;
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


    

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}

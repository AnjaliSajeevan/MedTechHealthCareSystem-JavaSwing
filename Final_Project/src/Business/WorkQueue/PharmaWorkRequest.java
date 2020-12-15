/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Essentials.Medicine;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class PharmaWorkRequest {
    private int id;
    private String condition;
    private Map<Medicine,Integer> medList;
    private UserAccount receiver;
    private UserAccount sender;
    private String patient;
    private UserAccount cust;
    private Map<String,Date> statusMap;
    private String prescription;
    private String message;
    private String enterprise;
    private Date createDate;
        
   private static int count = 1;

    public PharmaWorkRequest() {
        id = count;
        count++;
        medList = new HashMap<Medicine,Integer>();
        statusMap = new HashMap<String,Date>();
        createDate=new Date();
    }

    public String getId() {
        return String.valueOf(id);
    }


    public String getCondition() {
        return condition;
    }

    public void setCondition(String message) {
        this.condition = message;
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

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public UserAccount getCust() {
        return cust;
    }

    public void setCust(UserAccount cust) {
        this.cust = cust;
    }


    public Map<Medicine, Integer> getMedList() {
        return medList;
    }

    public void updateMedList(Medicine med,Integer num) {
        medList.put(med, num);
    }
    
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public Map<String, Date> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Date> statusMap) {
        this.statusMap = statusMap;
    }



    

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}

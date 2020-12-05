/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Manasa
 */
public class EmergencyRequest {
    private UserAccount sender;
    private UserAccount receiver;
    private String hospital;
    private Date createDate;
    private String enterprise;
    private String msg;
    private String result;
    private int id;
    private Map<String,Date> statusMap;
   private static int count = 1;

    public EmergencyRequest() {
        id = count;
        count++;
        createDate = new Date();
        statusMap = new HashMap<String,Date>();
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getCreateDate() {
        return createDate;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
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

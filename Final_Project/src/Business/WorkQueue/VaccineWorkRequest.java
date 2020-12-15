/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class VaccineWorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Vaccine vaccine;
    private Map<String,Date> statusMap;
    private Date requestDate;
    private Date resolveDate;
    private String enterprise;
    private String success;
    private String phase;
    private UserAccount manufacturer;
    
    public VaccineWorkRequest(){
        requestDate = new Date();
        statusMap = new HashMap<String,Date>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Map<String, Date> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Date> statusMap) {
        this.statusMap = statusMap;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
    
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public UserAccount getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(UserAccount manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return String.valueOf(getVaccine().getId());
    }
    
}

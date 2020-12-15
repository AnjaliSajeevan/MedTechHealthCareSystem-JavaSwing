/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class LabTestWorkRequest {
       private Vaccine vaccine;
    private VaccineTester tester;
    private String id;
    private String result;
    private boolean complete;
    private String message;
    private String labTestType;
    private UserAccount receiver;
    private UserAccount sender;
    private String enterprise;
    private Map<String,Date> statusMap;
   private static int count = 1;

    public LabTestWorkRequest() {
        List<Integer> numbers = new ArrayList();
        for(int i = 0; i < 10; i++){
        numbers.add(i);
        }

        Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
        id="LT"+result;

    }
        statusMap = new HashMap<String,Date>();
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public VaccineTester getTester() {
        return tester;
    }

    public void setTester(VaccineTester tester) {
        this.tester = tester;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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

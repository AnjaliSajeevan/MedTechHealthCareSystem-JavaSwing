/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Anjali
 */
public class ClaimWorkRequest {
    
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private InsurancePolicy insurancepolicy;
    private String requestNo;
    private String InsuranceEnterprise;
    private double cost;
    private String message;
    private Patient patient;
    private String hospital;
    private String insuranceNo;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    
    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    
    
    
    public ClaimWorkRequest(){
        requestDate = new Date();
        List<Integer> numbers = new ArrayList();
        for(int i = 0; i < 10; i++){
        numbers.add(i);
        }

        Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
        requestNo="C"+result;

    }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public InsurancePolicy getInsurancepolicy() {
        return insurancepolicy;
    }

    public void setInsurancepolicy(InsurancePolicy insurancepolicy) {
        this.insurancepolicy = insurancepolicy;
    }

    public String getRequestNo() {
        return requestNo;
    }

   

    public String getInsuranceEnterprise() {
        return InsuranceEnterprise;
    }

    public void setInsuranceEnterprise(String InsuranceEnterprise) {
        this.InsuranceEnterprise = InsuranceEnterprise;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    
      @Override
    public String toString() {
        return requestNo;
    }
}

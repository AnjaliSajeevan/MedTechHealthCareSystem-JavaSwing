/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.InsurancePolicy.InsurancePolicy;
import Business.UserAccount.UserAccount;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Anjali
 */
public class PatientHospitalAppointmentWorkRequest {
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String requestNo;
    private String doctor;
    private String result;
    private double cost;
    private Map<String,Date> statusMap;
    private InsurancePolicy Insurance;

    public InsurancePolicy getInsurance() {
        return Insurance;
    }

    public void setInsurance(InsurancePolicy Insurance) {
        this.Insurance = Insurance;
    }
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }
    private Map<String,String> appointment;
    private Date requestDate;
    private Date resolveDate;
    private String hospital;
    private LocalDate appDate;
    private String time;
     private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDate appDate) {
        this.appDate = appDate;
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

    public Map<String, String> getAppointment() {
        return appointment;
    }

    public void setAppointment(Map<String, String> appointment) {
        this.appointment = appointment;
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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
      public PatientHospitalAppointmentWorkRequest(){
        requestDate = new Date();
        statusMap = new HashMap<String,Date>();
        List<Integer> numbers = new ArrayList();
        for(int i = 0; i < 10; i++){
        numbers.add(i);
        }

        Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
        requestNo="A"+result;

    }
    }
          public Map<String, Date> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Date> statusMap) {
        this.statusMap = statusMap;
    }
      @Override
    public String toString() {
        return requestNo;
    }
}

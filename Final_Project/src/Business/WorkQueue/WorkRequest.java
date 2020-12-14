/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.InsurancePolicy.InsurancePolicy;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String insurancepolicy;
    private String requestNo;
    private String enterprise;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public String getInsurancepolicy() {
        return insurancepolicy;
    }

    public void setInsurancepolicy(String insurancepolicy) {
        this.insurancepolicy = insurancepolicy;
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
    public WorkRequest(){
        requestDate = new Date();
        List<Integer> numbers = new ArrayList();
        for(int i = 0; i < 10; i++){
        numbers.add(i);
        }

        Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
        requestNo="I"+result;

    }
    }
      @Override
    public String toString() {
        return requestNo;
    }
}

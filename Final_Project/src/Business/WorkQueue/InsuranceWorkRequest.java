/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Anjali
 */
public class InsuranceWorkRequest extends WorkRequest{
     private String insuranceResult;

    public String getTestResult() {
        return insuranceResult;
    }

    public void setTestResult(String testResult) {
        this.insuranceResult = testResult;
    }
}

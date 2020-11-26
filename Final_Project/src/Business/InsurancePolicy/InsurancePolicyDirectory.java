/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InsurancePolicy;

import java.util.ArrayList;

/**
 *
 * @author Anjali
 */
public class InsurancePolicyDirectory {
     private ArrayList<InsurancePolicy> insurancePolicyList;

    public InsurancePolicyDirectory() {
        insurancePolicyList = new ArrayList();
    }

    public ArrayList<InsurancePolicy> getInsurancePolicyList() {
        return insurancePolicyList;
    }

    public void setInsurancePolicyList(ArrayList<InsurancePolicy> insurancePolicyList) {
        this.insurancePolicyList = insurancePolicyList;
    }
       public InsurancePolicy addInsurancePolicy(){
        InsurancePolicy c = new InsurancePolicy();
        insurancePolicyList.add(c);
        return c;
    }
    
    public void deleteMenu(InsurancePolicy c){
        insurancePolicyList.remove(c);
    }
}

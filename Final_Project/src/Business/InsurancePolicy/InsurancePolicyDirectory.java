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
    
    public void deleteInsurancePolicy(InsurancePolicy c){
        insurancePolicyList.remove(c);
    }
    
    public InsurancePolicy searchzipCode(String code){
           
        for(InsurancePolicy zip: insurancePolicyList){
            if(zip.getZipCode().equals(code))
                    {
                return zip;
            }
        }
        return null;
            }
    public InsurancePolicy searchAge(String age){
           
        for(InsurancePolicy zip: insurancePolicyList){
           if(zip.getAgeGroup().equals(age))          
                    {
                return zip;
            }
        }
        return null;
            }
    public InsurancePolicy searchMax(Double max){
           
        for(InsurancePolicy zip: insurancePolicyList){
            if(zip.getMonthlyPremium()<=max)
                    {
                return zip;
            }
        }
        return null;
            }
    public InsurancePolicy searchpolicy(String type){
           
        for(InsurancePolicy zip: insurancePolicyList){
            if(zip.getPolicyType().equals(type))
                    {
                return zip;
            }
        }
        return null;
            }
}

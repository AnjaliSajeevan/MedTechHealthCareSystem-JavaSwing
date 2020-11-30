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
public class InsurancePolicy {
    private String policyName;
    private double monthlyPremium;
    private String policyType;
    private String policyMax;
    private String OutOfPocket;
    private double deductable;
    private String dental;
    private String vision;
    private String hearing;
    private String fitness;
    private String laboratory;
    private String pharmacy;
    private String teleHealth;
    private String zipCode;
    private int primaryCare;
    private int specialist;
    private int emergency;
    private int surgery;
    private int laboratoryservices;
    private int inPatients;
    private String userName;
    private String Enterprise;
    private String ageGroup;
    private double totalcost;

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }
    private ArrayList<String> HospitalList=new ArrayList<String>();
    private ArrayList<String> PharmacyList=new ArrayList<String>();
    private ArrayList<String> LaboratoryList=new ArrayList<String>();
    private ArrayList<String> UserAccountList = new ArrayList<String>();

    public ArrayList<String> getUserAccountList() {
        return UserAccountList;
    }

    public void setUserAccountList(ArrayList<String> UserAccountList) {
        this.UserAccountList = UserAccountList;
    }

    public String getEnterprise() {
        return Enterprise;
    }

    public void setEnterprise(String Enterprise) {
        this.Enterprise = Enterprise;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getDeductable() {
        return deductable;
    }

    public void setDeductable(double deductable) {
        this.deductable = deductable;
    }
    
    public ArrayList<String> getHospitalList() {
        return HospitalList;
    }
    
     public void addPatient(String a){
    UserAccountList.add(a);   
    }
     
      public void deletePatient(String a){
    UserAccountList.remove(a);   
    }

    public void addHospitals(String a){
    HospitalList.add(a);   
    }
    
    public void addLaboratory(String a){
    LaboratoryList.add(a);   
    }
    
    public void addPharmacy(String a){
    PharmacyList.add(a);   
    }
        
    public ArrayList<String> getPharmacyList() {
        return PharmacyList;
    }

    public void setPharmacyList(ArrayList<String> PharmacyList) {
        this.PharmacyList = PharmacyList;
    }

    public ArrayList<String> getLaboratoryList() {
        return LaboratoryList;
    }

    public void setLaboratoryList(ArrayList<String> LaboratoryList) {
        this.LaboratoryList = LaboratoryList;
    }
    
    public String getPolicyMax() {
        return policyMax;
    }

    public void setPolicyMax(String policyMax) {
        this.policyMax = policyMax;
    }

    public String getOutOfPocket() {
        return OutOfPocket;
    }

    public void setOutOfPocket(String OutOfPocket) {
        this.OutOfPocket = OutOfPocket;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
       

    public int getInPatients() {
        return inPatients;
    }

    public void setInPatients(int inPatients) {
        this.inPatients = inPatients;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public double getMonthlyPremium() {
        return monthlyPremium;
    }

    public void setMonthlyPremium(double monthlyPremium) {
        this.monthlyPremium = monthlyPremium;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

   

    public String getDental() {
        return dental;
    }

    public void setDental(String dental) {
        this.dental = dental;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getTeleHealth() {
        return teleHealth;
    }

    public void setTeleHealth(String teleHealth) {
        this.teleHealth = teleHealth;
    }

    public int getPrimaryCare() {
        return primaryCare;
    }

    public void setPrimaryCare(int primaryCare) {
        this.primaryCare = primaryCare;
    }

    public int getSpecialist() {
        return specialist;
    }

    public void setSpecialist(int specialist) {
        this.specialist = specialist;
    }

    public int getEmergency() {
        return emergency;
    }

    public void setEmergency(int emergency) {
        this.emergency = emergency;
    }

    public int getSurgery() {
        return surgery;
    }

    public void setSurgery(int surgery) {
        this.surgery = surgery;
    }

    public int getLaboratoryservices() {
        return laboratoryservices;
    }

    public void setLaboratoryservices(int laboratoryservices) {
        this.laboratoryservices = laboratoryservices;
    }
         @Override
    public String toString() {
        return policyName;
    }
    
}

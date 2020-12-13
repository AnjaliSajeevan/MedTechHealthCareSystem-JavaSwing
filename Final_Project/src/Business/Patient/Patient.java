/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Employee.Employee;
import Business.InsurancePolicy.InsurancePolicy;
import Business.Organization.Organization;
import Business.Role.PatientRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sayu
 */

public class Patient extends Employee {
     private String patientname;
    private String address1;
    private String address2;
    private String address3;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }
    private int id;

   
    private static int count = 1;
    private String DOB;
    private int age;
    private String contact;
    private String email;
    private String gender;
    private Date createDate;
    private Date updateDate;
    private String ssn;
    private String healthNum;
    private String license;
    private String allergy;
    private String healthOther;
    private String condition;
    private String photograph;
    private InsurancePolicy insurance;
    private String userName;
    private int adultNo;
    private int childrenNo;
    private String primaryHospital;
    private String insuranceOrderNo;

    public String getInsuranceOrderNo() {
        return insuranceOrderNo;
    }

    public void setInsuranceOrderNo(String insuranceOrderNo) {
        this.insuranceOrderNo = insuranceOrderNo;
    }

    public String getPrimaryHospital() {
        return primaryHospital;
    }

    public void setPrimaryHospital(String primaryHospital) {
        this.primaryHospital = primaryHospital;
    }

    public int getAdultNo() {
        return adultNo;
    }

    public void setAdultNo(int adultNo) {
        this.adultNo = adultNo;
    }

    public int getChildrenNo() {
        return childrenNo;
    }

    public void setChildrenNo(int childrenNo) {
        this.childrenNo = childrenNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserAccount(String userName) {
        this.userName = userName;
    }
   public String getUserAccount() {
        return userName;
    }

    public InsurancePolicy getInsurance() {
        return insurance;
    }

    public void setInsurance(InsurancePolicy insurance) {
        this.insurance = insurance;
    }

    public Patient() {
        id = count;
        count++;
        this.setCreateDate();
    }

    public int getId() {
        return id;
    }


    public String getPatientname() {
        return patientname;
    }

     
    public void setPatientname(String name) {
        this.patientname = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Patient.count = count;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        this.createDate = new Date();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getHealthNum() {
        return healthNum;
    }

    public void setHealthNum(String healthNum) {
        this.healthNum = healthNum;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getHealthOther() {
        return healthOther;
    }

    public void setHealthOther(String healthOther) {
        this.healthOther = healthOther;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

   

    @Override
    public String toString() {
        return patientname;
    }
    
    
}

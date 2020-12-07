/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import Business.Enterprise.Enterprise;
import java.util.Date;

/**
 *
 * @author Manasa
 */
public class VaccineTester {
    
    private String name;
    private String address;
    private int id;
    private static int count = 1;
    private String DOB;
    private int age;
    private int contact;
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
    private Enterprise enterprise;

    public VaccineTester() {
        id = count;
        count++;
        this.setCreateDate();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        VaccineTester.count = count;
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

   

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
}

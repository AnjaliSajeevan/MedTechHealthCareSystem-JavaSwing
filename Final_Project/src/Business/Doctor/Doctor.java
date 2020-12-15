/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import Business.Employee.Employee;
import Business.Patient.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author sayu
 */
public class Doctor extends Employee {
     private String name;
    private String address;
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
    private String specialization;
    private String hospital;
    private String healthOther;
    private Date dateFrom;
    private Date dateTo;
    private String time;
    private String userName;
    private ArrayList<String> TimeSlotList=new ArrayList<String>();
    Map<LocalDate,ArrayList<String>>appointment;
    //private String photograph;

    public Map<LocalDate, ArrayList<String>> getAppointment() {
        return appointment;
    }

    public void setAppointment(Map<LocalDate, ArrayList<String>> appointment) {
        this.appointment = appointment;
    }
    
     public void removeAppointment(LocalDate dates,String selected){
         appointment.get(dates).remove(selected);
        
    }
     
    public ArrayList<String> getTimeSlotList() {
        return TimeSlotList;
    }

    public void setTimeSlotList(ArrayList<String> TimeSlotList) {
        this.TimeSlotList = TimeSlotList;
    }
    
    public void addTimeSlot(String a){
    TimeSlotList.add(a);   
    }
    public void removeAllTimeSlot(){
    TimeSlotList.clear();   
    }
    

    public String getHealthOther() {
        return healthOther;
    }

    public void setHealthOther(String healthOther) {
        this.healthOther = healthOther;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    
    
    private String photograph;

    public Doctor() {
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
        Doctor.count = count;
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
public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }
      @Override
    public String toString() {
        return name;
    }
    
  }

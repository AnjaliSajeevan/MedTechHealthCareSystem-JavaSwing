/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.LabTestWorkQueue;
import Business.WorkQueue.PatientHospitalAppointmentWorkQueue;
import Business.WorkQueue.VaccineWorkQueue;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak,Manasa
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private VaccineWorkQueue vaccineQueue;
    private PatientHospitalAppointmentWorkQueue hospitalQueue;
    private LabTestWorkQueue labQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        HospitalAdmin("Hospiatal Organization"), Doctor("Hospiatal Organization"),HospitalStaff("Hospiatal Organization"),AmbulanceDriver("Hospiatal Organization"),
        PharmacyAdmin("Pharmacy Organization"),PharmacyStaff("Pharmacy Organization"),
        VaccineCompanyAdmin("Vaccine Organization"),ResearchScientists("Vaccine Organization"),VaccineTestingStaff("Vaccine Organization"),
        LabAdmin("Laboratory Organization"),LabStaff("Laboratory Organization"),
        InsuranceAdmin("Insurance Organization"), InsuranceStaff("Insurance Organization"),
        FDAAdmin("FDA Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        vaccineQueue = new VaccineWorkQueue();
        hospitalQueue=new PatientHospitalAppointmentWorkQueue();
        labQueue = new LabTestWorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public PatientHospitalAppointmentWorkQueue getHospitalQueue() {
        return hospitalQueue;
    }

    public void setHospitalQueue(PatientHospitalAppointmentWorkQueue hospitalQueue) {
        this.hospitalQueue = hospitalQueue;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    public VaccineWorkQueue getVaccineQueue() {
        return vaccineQueue;
    }

    public void setVaccineQueue(VaccineWorkQueue vaccineQueue) {
        this.vaccineQueue = vaccineQueue;
    } 
    public LabTestWorkQueue getLabQueue() {
        return labQueue;
    }

    public void setLabQueue(LabTestWorkQueue labQueue) {
        this.labQueue = labQueue;
    }
    
    public String getOrganizationType(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

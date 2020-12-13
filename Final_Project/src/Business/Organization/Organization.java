/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.ClaimWorkQueue;
import Business.WorkQueue.DrugDemandQueue;
import Business.WorkQueue.DrugSupplyQueue;
import Business.WorkQueue.EmergencyQueue;
import Business.WorkQueue.LabPatientWorkQueue;
import Business.WorkQueue.LabTestWorkQueue;
import Business.WorkQueue.PatientHospitalAppointmentWorkQueue;
import Business.WorkQueue.PharmaWorkQueue;
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
    private ClaimWorkQueue claimWorkQueue;
    private LabTestWorkQueue labQueue;
    private PharmaWorkQueue pharmaQueue;
    private LabPatientWorkQueue labPatQueue;
    private EmergencyQueue emergencyQueue;
    private DrugDemandQueue pharmaDemandQueue;
    private DrugSupplyQueue pharmaSupplyQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        HospitalAdmin("Hospiatal Organization"), Doctor("Hospiatal Organization"),HospitalStaff("Hospiatal Organization"),AmbulanceDriver("Hospiatal Organization"),
        PharmacyAdmin("Pharmacy Organization"),DeliveryMan("Pharmacy Organization"),
        VaccineCompanyAdmin("Vaccine Organization"),VaccineScientist("Vaccine Organization"),VaccineTestingStaff("Vaccine Organization"),
        LabAdmin("Laboratory Organization"),LabStaff("Laboratory Organization"),
        InsuranceAdmin("Insurance Organization"), InsuranceStaff("Insurance Organization"),
        FDAAdmin("FDA Organization"),ManufactureAdmin("Manufacturing Organization");
        
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
        claimWorkQueue = new ClaimWorkQueue();
        labPatQueue = new LabPatientWorkQueue();
        pharmaQueue = new PharmaWorkQueue();
        emergencyQueue = new EmergencyQueue();
        hospitalQueue=new PatientHospitalAppointmentWorkQueue();
        labQueue = new LabTestWorkQueue();
        pharmaDemandQueue = new DrugDemandQueue();
        pharmaSupplyQueue = new DrugSupplyQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();

        organizationID = counter;
        ++counter;
    }

    public ClaimWorkQueue getClaimWorkQueue() {
        return claimWorkQueue;
    }

    public void setClaimWorkQueue(ClaimWorkQueue claimWorkQueue) {
        this.claimWorkQueue = claimWorkQueue;
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

    public PharmaWorkQueue getPharmaQueue() {
        return pharmaQueue;
    }

    public void setPharmaQueue(PharmaWorkQueue pharmaQueue) {
        this.pharmaQueue = pharmaQueue;
    }

    public LabPatientWorkQueue getLabPatQueue() {
        return labPatQueue;
    }

    public void setLabPatQueue(LabPatientWorkQueue labPatQueue) {
        this.labPatQueue = labPatQueue;
    }

    public EmergencyQueue getEmergencyQueue() {
        return emergencyQueue;
    }

    public void setEmergencyQueue(EmergencyQueue emergencyQueue) {
        this.emergencyQueue = emergencyQueue;
    }

   public DrugDemandQueue getPharmaDemandQueue() {
        return pharmaDemandQueue;
    }

    public void setPharmaDemandQueue(DrugDemandQueue pharmaDemandQueue) {
        this.pharmaDemandQueue = pharmaDemandQueue;
    }

    public DrugSupplyQueue getPharmaSupplyQueue() {
        return pharmaSupplyQueue;
    }

    public void setPharmaSupplyQueue(DrugSupplyQueue pharmaSupplyQueue) {
        this.pharmaSupplyQueue = pharmaSupplyQueue;
    }
    public String getOrganizationType(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

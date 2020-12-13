/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.ClaimWorkQueue;
import Business.WorkQueue.DrugDemandQueue;
import Business.WorkQueue.DrugSupplyQueue;
import Business.WorkQueue.EmergencyQueue;
import Business.WorkQueue.LabPatientWorkQueue;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.LabTestWorkQueue;
import Business.WorkQueue.PatientHospitalAppointmentWorkQueue;
import Business.WorkQueue.PharmaWorkQueue;
import Business.WorkQueue.VaccineWorkQueue;
/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private VaccineWorkQueue vaccineWorkQueue;
    private LabTestWorkQueue labTestWorkQueue;
    private PharmaWorkQueue pharmaWorkQueue;
    private LabPatientWorkQueue labPatientWorkQueue;
    private EmergencyQueue emergencyQueue;
    private PatientHospitalAppointmentWorkQueue hospitalWorkQueue;
    private ClaimWorkQueue claimWorkQueue; 
    private DrugDemandQueue pharmaDemandQueue;
    private DrugSupplyQueue pharmaSupplyQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
        vaccineWorkQueue = new VaccineWorkQueue();
        labTestWorkQueue = new LabTestWorkQueue();
        labPatientWorkQueue = new LabPatientWorkQueue();
        pharmaWorkQueue = new PharmaWorkQueue();
        emergencyQueue = new EmergencyQueue();
        hospitalWorkQueue= new PatientHospitalAppointmentWorkQueue();
        claimWorkQueue = new ClaimWorkQueue();
        pharmaDemandQueue = new DrugDemandQueue();
        pharmaSupplyQueue = new DrugSupplyQueue();
    }

    public ClaimWorkQueue getClaimWorkQueue() {
        return claimWorkQueue;
    }

    public void setClaimWorkQueue(ClaimWorkQueue claimWorkQueue) {
        this.claimWorkQueue = claimWorkQueue;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public VaccineWorkQueue getVaccineWorkQueue() {
        return vaccineWorkQueue;
    }

    public LabTestWorkQueue getLabTestWorkQueue() {
        return labTestWorkQueue;
    }
    public PharmaWorkQueue getPharmaWorkQueue() {
        return pharmaWorkQueue;
    }

  /*  public void setPharmaWorkQueue(PharmaWorkQueue pharmaWorkQueue) {
        this.pharmaWorkQueue = pharmaWorkQueue;
    }*/

    public LabPatientWorkQueue getLabPatientWorkQueue() {
        return labPatientWorkQueue;
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



    public PatientHospitalAppointmentWorkQueue getHospitalWorkQueue() {
        return hospitalWorkQueue;
    }

    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}
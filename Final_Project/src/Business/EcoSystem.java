/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Doctor.DoctorDirectory;
import Business.Essentials.ProductCatalog;
import Business.InsurancePolicy.InsurancePolicyDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private PatientDirectory patientDirectory;
    private InsurancePolicyDirectory insurancePolicyDirectory;
    private ProductCatalog productcatalog;
    private DoctorDirectory doctorDirectory;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        patientDirectory=new PatientDirectory();
        insurancePolicyDirectory= new InsurancePolicyDirectory();
        productcatalog=new ProductCatalog();
        doctorDirectory= new DoctorDirectory();
        networkList=new ArrayList<Network>();
    }

    public DoctorDirectory getDoctorDirectory() {
        System.out.println("Business.EcoSystem.getDoctorDirectory()"+ doctorDirectory);
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public InsurancePolicyDirectory getInsurancePolicyDirectory() {
        return insurancePolicyDirectory;
    }

    public void setInsurancePolicyDirectory(InsurancePolicyDirectory insurancePolicyDirectory) {
        this.insurancePolicyDirectory = insurancePolicyDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }

    public void setProductCatalog(ProductCatalog vaccineDirectory) {
        this.productcatalog = vaccineDirectory;
    }


 
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
}

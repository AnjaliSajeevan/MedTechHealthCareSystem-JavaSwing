/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Essentials.ProductCatalog;
import Business.InsurancePolicy.InsurancePolicyDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Vaccine.VaccineDirectory;
import Business.Vaccine.VaccineTesterDirectory;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private PatientDirectory patientDirectory;
    private VaccineDirectory vaccineDirectory;
    private VaccineTesterDirectory vaccinetesterDirectory;
    private InsurancePolicyDirectory insurancePolicyDirectory;
    private ProductCatalog productcatalog;
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
        vaccineDirectory=new VaccineDirectory();
        vaccinetesterDirectory=new VaccineTesterDirectory();
        insurancePolicyDirectory= new InsurancePolicyDirectory();
        productcatalog=new ProductCatalog();
        networkList=new ArrayList<Network>();
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

    public VaccineDirectory getVaccineDirectory() {
        return vaccineDirectory;
    }

    public void setVaccineDirectory(VaccineDirectory vaccineDirectory) {
        this.vaccineDirectory = vaccineDirectory;
    }
    public ProductCatalog getProductCatalogy() {
        return productcatalog;
    }

    public void setProductCatalog(ProductCatalog vaccineDirectory) {
        this.productcatalog = vaccineDirectory;
    }

    public VaccineTesterDirectory getVaccinetesterDirectory() {
        return vaccinetesterDirectory;
    }

    public void setVaccinetesterDirectory(VaccineTesterDirectory vaccinetesterDirectory) {
        this.vaccinetesterDirectory = vaccinetesterDirectory;
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

    public ProductCatalog getProductcatalog() {
        return productcatalog;
    }

    public void setProductcatalog(ProductCatalog productcatalog) {
        this.productcatalog = productcatalog;
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

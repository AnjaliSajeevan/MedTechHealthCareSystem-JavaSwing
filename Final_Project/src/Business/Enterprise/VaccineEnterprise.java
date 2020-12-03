/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Vaccine.VaccineDirectory;
import Business.Vaccine.VaccineTesterDirectory;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class VaccineEnterprise extends Enterprise {
     private VaccineDirectory vaccineDirectory;
    private VaccineTesterDirectory vaccinetesterDirectory;   
    public VaccineEnterprise(String name){
        super(name,Enterprise.EnterpriseType.VaccineCompany);
        vaccineDirectory=new VaccineDirectory();
        vaccinetesterDirectory=new VaccineTesterDirectory();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
        public VaccineDirectory getVaccineDirectory() {
        return vaccineDirectory;
    }

    public void setVaccineDirectory(VaccineDirectory vaccineDirectory) {
        this.vaccineDirectory = vaccineDirectory;
    }
    
    public VaccineTesterDirectory getVaccinetesterDirectory() {
        return vaccinetesterDirectory;
    }

    public void setVaccinetesterDirectory(VaccineTesterDirectory vaccinetesterDirectory) {
        this.vaccinetesterDirectory = vaccinetesterDirectory;
    }
}

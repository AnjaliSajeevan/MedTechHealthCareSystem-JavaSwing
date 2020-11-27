/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Role.VaccineAdminRole;
import Business.Role.VaccineScientistRole;
import Business.Role.VaccineTestingStaffRole;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class VaccineCompanyOrganization extends Organization{
    private String organizationType;
    public VaccineCompanyOrganization(String organizationType) {
        super(Organization.Type.VaccineCompanyAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VaccineAdminRole());
        roles.add(new VaccineScientistRole());
        roles.add(new VaccineTestingStaffRole());
        return roles;
    }
     
}
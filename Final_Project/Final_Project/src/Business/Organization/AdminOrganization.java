/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.AmbulanceDriverRole;
import Business.Role.DoctorRole;
import Business.Role.HospitalStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AdminOrganization extends Organization{

     private String organizationType;
     
    public AdminOrganization(String organizationType) {
        super(Organization.Type.HospitalAdmin.getValue());
        this.organizationType = organizationType;
    }
     public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminRole());
        roles.add(new DoctorRole());
        roles.add(new HospitalStaffRole());
        roles.add(new AmbulanceDriverRole());
        return roles;
    }
     
}

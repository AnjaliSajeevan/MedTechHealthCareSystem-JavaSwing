/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabAdminRole;
import Business.Role.LabStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */

public class LaboratoryOrganization extends Organization{

    private String organizationType;

    public LaboratoryOrganization(String organizationType) {
        super(Organization.Type.LabAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAdminRole());
        roles.add(new LabStaffRole());
        return roles;
    }
     
}
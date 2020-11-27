/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DeliveryManRole;
import Business.Role.DoctorRole;
import Business.Role.PharmacyAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class PharmacyOrganization extends Organization{
    private String organizationType;
    public PharmacyOrganization(String organizationType) {
        super(Organization.Type.PharmacyAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PharmacyAdminRole());
        roles.add(new DeliveryManRole());
        return roles;
    }
     
}
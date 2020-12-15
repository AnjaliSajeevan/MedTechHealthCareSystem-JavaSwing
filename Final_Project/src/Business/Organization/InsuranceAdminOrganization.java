/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InsuranceAdminRole;
import Business.Role.InsuranceClaimRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class InsuranceAdminOrganization extends Organization{
    
    private String organizationType;
    
    public InsuranceAdminOrganization(String organizationType) {
        super(Organization.Type.InsuranceAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsuranceAdminRole());
        roles.add(new InsuranceClaimRole());
        return roles;
    }
    
}

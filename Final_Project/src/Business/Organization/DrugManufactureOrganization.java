/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.ManufactureAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class DrugManufactureOrganization extends Organization{
   private String organizationType;
    
    public DrugManufactureOrganization(String organizationType) {
        super(Organization.Type.ManufactureAdmin.getValue());
         this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufactureAdminRole());
        return roles;
    }
     
}

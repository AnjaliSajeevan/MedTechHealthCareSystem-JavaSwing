/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LaboratoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.LabStaffRole.LabStaffWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class LabStaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabStaffWorkAreaJPanel(userProcessContainer, business,account,(LaboratoryOrganization)organization,enterprise);
    
    }
    
    public String toString(){
        return "LabStaff";
    }
    
    
}

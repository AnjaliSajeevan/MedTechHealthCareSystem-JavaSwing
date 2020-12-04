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
import javax.swing.JPanel;
import userinterface.LabAdminRole.LabAdminWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class LabAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabAdminWorkAreaJPanel(userProcessContainer, account,(LaboratoryOrganization)organization,enterprise,business);
    }

    public String toString(){
        return "LabAdmin";
    }   
    
}

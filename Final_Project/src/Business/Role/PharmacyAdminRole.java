/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Organization.LaboratoryOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LabStaffRole.LabStaffWorkAreaJPanel;
import userinterface.PharmacyAdminRole.PharmacyAdminWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class PharmacyAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PharmacyAdminWorkAreaJPanel(userProcessContainer, account,(PharmacyOrganization)organization,(PharmacyEnterprise) enterprise,business);
    }

    public String toString(){
        return "PharmacyAdmin";
    }  
    
}

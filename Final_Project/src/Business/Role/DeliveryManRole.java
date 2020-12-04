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
import userinterface.DeliveryManRole.DeliveryManWorkAreaJPanel;
import userinterface.LabStaffRole.LabStaffWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class DeliveryManRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DeliveryManWorkAreaJPanel(userProcessContainer, account,(PharmacyOrganization)organization,(PharmacyEnterprise) enterprise,business);
    }
    
    public String toString(){
        return "DeliveryMan";
    }
    
    
}

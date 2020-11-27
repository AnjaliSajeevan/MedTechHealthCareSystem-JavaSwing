/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LaboratoryOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.VaccineCompanyOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LabStaffRole.LabStaffWorkAreaJPanel;
import userinterface.PharmacyAdminRole.PharmacyAdminWorkAreaJPanel;
import userinterface.VaccineScientistRole.VaccineScientistWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class VaccineScientistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new VaccineScientistWorkAreaJPanel(userProcessContainer, account,(VaccineCompanyOrganization)organization,enterprise,business);
    }

        public String toString(){
        return ("VaccineScientist");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.InsuranceAdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.InsuranceAdminWorkArea.InsuranceAdminWorkAreaJPanel;

/**
 *
 * @author Anjali
 */
public class InsuranceAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        return new InsuranceAdminWorkAreaJPanel(userProcessContainer, account,(InsuranceAdminOrganization)organization,enterprise,ecosystem);
    }
    public String toString(){
        return "InsuranceAdmin";
    } 
}

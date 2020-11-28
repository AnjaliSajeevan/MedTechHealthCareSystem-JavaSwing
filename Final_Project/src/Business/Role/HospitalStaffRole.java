/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HospitalStaffWorkAreaJPanel.HospitalStaffWorkAreaJPanel;

/**
 *
 * @author Anjali
 */
public class HospitalStaffRole extends Role{

   @Override
   public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HospitalStaffWorkAreaJPanel(userProcessContainer, account,enterprise,business);
    }
    public String toString(){
        return "HospitalStaff";
    } 
}
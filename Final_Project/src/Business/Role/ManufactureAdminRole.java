package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FDAWorkAreaJPanel.FDAWorkAreaJPanel;
import userinterface.ManufacturerRole.ManufacturerWorkAreaJPanel;

/**
 *
 * @author Manasa
 */
public class ManufactureAdminRole extends Role{
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManufacturerWorkAreaJPanel(userProcessContainer, account,organization,enterprise,business);
    }
     public String toString(){
        return "ManufactureAdmin";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak,Manasa
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.LabAdmin.getValue())){
            organization = new LaboratoryOrganization(String.valueOf(type));
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.VaccineCompanyAdmin.getValue())){
            organization = new VaccineCompanyOrganization(String.valueOf(type));
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PharmacyAdmin.getValue())){
            organization = new PharmacyOrganization(String.valueOf(type));
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.InsuranceAdmin.getValue())){
            organization = new InsuranceAdminOrganization(String.valueOf(type)) ;
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FDAAdmin.getValue())){
            organization = new FDAOrganization(String.valueOf(type));
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.HospitalAdmin.getValue())){
            organization = new AdminOrganization(String.valueOf(type));
            organizationList.add(organization);
        }
        
        return organization;
    }
}
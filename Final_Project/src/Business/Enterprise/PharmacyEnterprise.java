/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Essentials.MedicineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class PharmacyEnterprise extends Enterprise {
      private MedicineCatalog  medicineCatalog;    
    public PharmacyEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Pharmacy);
         medicineCatalog=new MedicineCatalog();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public MedicineCatalog getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(MedicineCatalog medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
    }
    

}

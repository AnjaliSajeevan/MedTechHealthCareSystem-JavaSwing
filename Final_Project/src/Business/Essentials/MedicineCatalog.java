/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Essentials;

import Business.Essentials.Medicine;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class MedicineCatalog {
    
    private ArrayList<Medicine> medicineList;

    public MedicineCatalog() {
        medicineList = new ArrayList<Medicine>();
    }

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }
    
    public Medicine addMedicine(Medicine med){
        medicineList.add(med);
        return med;
    }
     public void removeMedicine(Medicine med){
        medicineList.remove(med);
    }
    
    public void updateMedicine(Medicine med){
        for(Medicine medicine : medicineList){
            if(medicine.getId() == med.getId()){
               medicine = med;
                
            }
        }
    }
    
    
}
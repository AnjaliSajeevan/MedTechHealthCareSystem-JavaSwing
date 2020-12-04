/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class VaccineDirectory {
    
    private ArrayList<Vaccine> vaccineList;

    public VaccineDirectory() {
        vaccineList = new ArrayList<Vaccine>();
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }
    
    public Vaccine addVaccine(Vaccine v){
        vaccineList.add(v);
        return v;
    }
    
    public void updateVaccine(Vaccine v){
        for(Vaccine vac : vaccineList){
            if(vac.getId() == v.getId()){
               vac = v;
                
            }
        }
    }
    
    
}
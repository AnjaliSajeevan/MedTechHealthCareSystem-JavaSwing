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
public class VaccineTesterDirectory {
    
    private ArrayList<VaccineTester> vaccineTesterList;

    public VaccineTesterDirectory() {
        vaccineTesterList = new ArrayList<VaccineTester>();
    }

    public ArrayList<VaccineTester> getVaccineTesterList() {
        return vaccineTesterList;
    }
    
    public VaccineTester addVaccineTester(VaccineTester v){
        vaccineTesterList.add(v);
        return v;
    }
        public void removeVaccineTester(VaccineTester v){
        vaccineTesterList.remove(v);
    }
        public void updateVaccineTester(VaccineTester v){
        for(VaccineTester vac : vaccineTesterList){
            if(vac.getId() == v.getId()){
               vac = v;
                
            }
        }
    }
}
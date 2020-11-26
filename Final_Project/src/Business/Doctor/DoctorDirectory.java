/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;


import java.util.ArrayList;

/**
 *
 * @author sayu
 */
public class DoctorDirectory {
    private ArrayList<Doctor> doctorlist;

    public DoctorDirectory() {
        System.out.println("DoctorDirectory.<init>()");
        doctorlist = new ArrayList<Doctor>();
    }

    public ArrayList<Doctor> getdoctorlist() {
        return doctorlist;
    }
    
    public Doctor addDoctor(Doctor p)
    {
        
        doctorlist.add(p);
        System.out.println("doc dir= "+p);
        return p;
    }
   
      public void deleteDoctor(Doctor doctor){
        doctorlist.remove(doctor); 
    }
    
        public Doctor searchDoctor(String doctorName){
        for (Doctor doctor: doctorlist) {
            if (doctor.getName().equals(doctorName)) {
                return doctor;
            }
        }
        return null;
    }
}


    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Vaccine.Vaccine;
import Business.Vaccine.VaccineTester;

/**
 *
 * @author Manasa
 */
public class LabTestWorkRequest {
       private Vaccine vaccine;
    private VaccineTester tester;
    private int id;
    private String result;
    private String message;
    private String labTestType;
    private String username;
        
   private static int count = 1;

    public LabTestWorkRequest() {
        id = count;
        count++;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public VaccineTester getTester() {
        return tester;
    }

    public void setTester(VaccineTester tester) {
        this.tester = tester;
    }

    public String getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(String labTestType) {
        this.labTestType = labTestType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class LabEnterprise extends Enterprise {
    Map<String,String> timeSlot;
    List<String> services;
    public LabEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Laboratory);
        timeSlot = new HashMap<String,String>();
        services = new ArrayList<String>();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public Map<String, String> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Map<String, String> timeSlot) {
        this.timeSlot = timeSlot;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
    

}
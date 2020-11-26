/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manasa
 */
public class LabEnterprise extends Enterprise {
    
    public LabEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Laboratory);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    

}
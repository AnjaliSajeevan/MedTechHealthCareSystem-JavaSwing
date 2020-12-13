/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Essentials.Medicine;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class DrugDemandWorkRequest {
    private int quantity;
    private int id;
    private String medicine;
    private UserAccount pharmacy;
    private Date createDate;
        
   private static int count = 1;

    public DrugDemandWorkRequest() {
        id = count;
        count++;
        createDate=new Date();
    }

    public String getId() {
        return String.valueOf(id);
    }


 
    public Date getCreateDate() {
        return createDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public UserAccount getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(UserAccount pharmacy) {
        this.pharmacy = pharmacy;
    }

 

    

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}

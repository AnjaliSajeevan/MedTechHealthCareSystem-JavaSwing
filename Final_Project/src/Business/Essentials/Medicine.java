/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Essentials;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Manasa
 */
public class Medicine {
    private String name;
    private Double price;
    private int quantity;
    private int dosage;
    private int demand;
    private String condition;
    private Date createDate;
    private Date updateDate;
    private UserAccount manufacturer;
        private int id;
    private static int count = 1;


    public Medicine(String name, Double price, int quantity, int dosage) {
        id = count;
        count++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dosage = dosage;
        this.createDate = new Date();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public UserAccount getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(UserAccount manufacturer) {
        this.manufacturer = manufacturer;
    }



    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    @Override
    public String toString() {
        return name ;
    }
    
}

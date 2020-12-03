/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Essentials;

/**
 *
 * @author Manasa
 */
public class Medicine {
    private String name;
    private Double price;
    private int quantity;
    private int dosage;
    private String condition;
        private int id;
    private static int count = 1;


    public Medicine(String name, Double price, int quantity, int dosage) {
        id = count;
        count++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dosage = dosage;
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

    @Override
    public String toString() {
        return name ;
    }
    
}

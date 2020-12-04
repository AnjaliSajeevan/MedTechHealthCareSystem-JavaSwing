 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Essentials;

/**
 *
 * @author abhishekashwathnarayanvenkat
 */
public class Product {
    
    private String prodName;
//    private int price;
//    private int modelNumber;
    private int avail;
    private String enterpriseName;
  
    
     private static int count =0;
    

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    
   

    @Override
    public String toString() {
        return prodName; //To change body of generated methods, choose Tools | Templates.
    }

    
    public Product() {
    count++;
   // modelNumber = count;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getModelNumber() {
//        return modelNumber;
//    }
//
//    public void setModelNumber(int modelNumber) {
//        this.modelNumber = modelNumber;
//    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    
    
}

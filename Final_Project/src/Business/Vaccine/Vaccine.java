/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class Vaccine {
    
    private String name;
    private int id;
    private static int count = 1;
    private String description;
    private String coreComponents;
    private String condition;
    private String allergens;
    private Date createDate;
    private Date updateDate;
    private String username;
    private int minAgeGroup;
    private int maxAgeGroup;
    private Map<String,Integer> dosage;
    private String administration;
    private String other;
    private String preservations;
    private String sideeffects;

    public Vaccine() {
        dosage = new HashMap<String,Integer>();
        id = count;
        count++;
        this.setCreateDate();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoreComponents() {
        return coreComponents;
    }

    public void setCoreComponents(String coreComponents) {
        this.coreComponents = coreComponents;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        this.createDate = new Date();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMinAgeGroup() {
        return minAgeGroup;
    }

    public void setMinAgeGroup(int minAge) {
        this.minAgeGroup = minAge;
    }
        public int getMaxAgeGroup() {
        return maxAgeGroup;
    }

    public void setMaxAgeGroup(int maxAge) {
        this.maxAgeGroup = maxAge;
    }

    public Map<String, Integer> getDosage() {
        return dosage;
    }

    public void setDosage(Map<String, Integer> updateDose) {
        dosage = updateDose;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPreservations() {
        return preservations;
    }

    public void setPreservations(String preservations) {
        this.preservations = preservations;
    }

    public String getSideeffects() {
        return sideeffects;
    }

    public void setSideeffects(String sideeffects) {
        this.sideeffects = sideeffects;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

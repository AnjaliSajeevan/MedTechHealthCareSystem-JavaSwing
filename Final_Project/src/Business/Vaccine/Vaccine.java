/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manasa
 */
public class Vaccine {
    
    private String name;
    private String id;
   // private static int count = 1;
    private String description;
    private String coreComponents;
    private String condition;
    private String allergens;
    private Date createDate;
    private Date updateDate;
    private UserAccount username;
    private int minAgeGroup;
    private int maxAgeGroup;
    private Map<String,Integer> dosage;
    private String administration;
    private String other;
    private String preservations;
    private Enterprise enterprise;
    private String sideeffects;
    private String enterpriseName;
    private int testerNum;
    private boolean tested;
    
    public Vaccine() {
        dosage = new HashMap<String,Integer>();
        this.setCreateDate();
               List<Integer> numbers = new ArrayList();
        for(int i = 0; i < 10; i++){
        numbers.add(i);
        }

        Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
        id="VAC"+result;

    }
    }
 
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
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

    public UserAccount getUsername() {
        return username;
    }

    public void setUsername(UserAccount username) {
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

    public int getTesterNum() {
        return testerNum;
    }

    public void setTesterNum(int testerNum) {
        this.testerNum = testerNum;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

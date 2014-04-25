/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author karriem
 */
@Entity
public class MedicalSupplies implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String suppliersID;
    private String suppliersName;
    private String equipmentID;
    private String description;
    private String dateOfOrder;
    private int amt;
    private int cost;

    public MedicalSupplies() {
    }
    
    public MedicalSupplies(Builder builder){
        
        id = builder.id;
        suppliersID = builder.suppliersID;
        suppliersName = builder.suppliersName;
        equipmentID = builder.equipmentID;
        description = builder.description;
        amt = builder.amt;
        dateOfOrder = builder.dateOfOrder;
        cost = builder.cost;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public Long getId() {
        return id;
    }

    public String getSuppliersID() {
        return suppliersID;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return dateOfOrder;
    }

    public int getAmt() {
        return amt;
    }

    public int getCost() {
        return cost;
    }
    
    public static class Builder{
        
        private Long id;
        private String suppliersID;
        private String equipmentID;
        private String description;
        private String dateOfOrder;
        private int amt;
        private int cost;
        private String suppliersName;
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder suppliersID(String val){
            
            this.suppliersID = val;
            
            return this;
        }
        
        public Builder equipmentID(String val){
            
            this.equipmentID = val;
            
            return this;
        }
        
        public Builder description(String val){
            
            this.description = val;
            
            return this;
        }
        
        public Builder date(String val){
            
            this.dateOfOrder = val;
            
            return this;
        }
        
        public Builder amt(int val){
            
            this.amt = val;
            
            return this;
        }
        
        public Builder cost(int val){
            
            this.cost = val;
            
            return this;
        }
        
        public Builder suppliersName(String val){
            
            this.suppliersName = val;
            
            return this;
        }
        
        public MedicalSupplies build(){
            
            return new MedicalSupplies(this);
        }
        
        public Builder medSupplier(MedicalSupplies medS){
            
            this.id = medS.getId();
            this.suppliersID = medS.getSuppliersID();
            this.equipmentID = medS.getEquipmentID();
            this.description = medS.getDescription();
            this.dateOfOrder = medS.getDate();
            this.amt = medS.getAmt();
            this.cost = medS.getCost();
            this.suppliersName = medS.getSuppliersName();
            
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicalSupplies other = (MedicalSupplies) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

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
public class GeneralSupplies implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String suppliersID;
    private String suppliersName;
    private String equipmentID;
    private String description;
    private String date;
    private int amt;
    private int cost;

    public GeneralSupplies() {
    }
    
    public GeneralSupplies(Builder builder){
        
        id = builder.id;
        suppliersID = builder.suppliersID;
        suppliersName = builder.suppliersName;
        equipmentID = builder.equipmentID;
        description = builder.description;
        amt = builder.amt;
        date = builder.date;
        cost = builder.cost;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public String getId() {
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
        return date;
    }

    public int getAmt() {
        return amt;
    }

    public int getCost() {
        return cost;
    }
    
    public static class Builder{
        
        private String id;
        private String suppliersID;
        private String equipmentID;
        private String description;
        private String date;
        private int amt;
        private int cost;
        private String suppliersName;
        
        public Builder id(String val){
            
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
            
            this.date = val;
            
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
        
        public GeneralSupplies build(){
            
            return new GeneralSupplies(this);
        }
        
        public Builder genSupplier(GeneralSupplies genS){
            
            this.id = genS.getId();
            this.suppliersID = genS.getSuppliersID();
            this.equipmentID = genS.getEquipmentID();
            this.description = genS.getDescription();
            this.date = genS.getDate();
            this.amt = genS.getAmt();
            this.cost = genS.getCost();
            this.suppliersName = genS.getSuppliersName();
            
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
        final GeneralSupplies other = (GeneralSupplies) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

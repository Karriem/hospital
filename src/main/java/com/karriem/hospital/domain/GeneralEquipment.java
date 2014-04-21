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
public class GeneralEquipment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String equipID;
    private String equipName;
    private int quantity;
    private String quality;

    public GeneralEquipment() {
    }
    
    public GeneralEquipment(Builder builder){
        
        id = builder.id;
        equipID = builder.equipID;
        equipName = builder.equipName;
        quantity = builder.quantity;
        quality = builder.quality;
    }

    public String getId() {
        return id;
    }

    public String getEquipID() {
        return equipID;
    }

    public String getEquipName() {
        return equipName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuality() {
        return quality;
    }
    
    public static class Builder{
        
        private String id;
        private String equipID;
        private String equipName;
        private int quantity;
        private String quality;
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder equipID(String val){
            
            this.equipID = val;
            
            return this;
        }
        
        public Builder equipName(String val){
            
            this.equipName = val;
            
            return this;
        }
        
        public Builder quantity(int val){
            
            this.quantity = val;
            
            return this;
        }
        
        public Builder condition(String val){
            
            this.quality = val;
            
            return this;
        }
        
        public GeneralEquipment build(){
            
            return new GeneralEquipment(this);
        }
        
        public Builder genEquipment(GeneralEquipment equip){
            
            this.id = equip.getId();
            this.equipID = equip.getEquipID();
            this.equipName = equip.getEquipName();
            this.quantity = equip.getQuantity();
            this.quality = equip.getQuality();
            
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
        final GeneralEquipment other = (GeneralEquipment) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

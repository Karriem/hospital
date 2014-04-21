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
public class Medicine implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String medID;
    private String medDescription;
    private int quantity;
    
    public Medicine(Builder builder){
        
        id = builder.id;
        medID = builder.medID;
        medDescription = builder.medDescription;
        quantity = builder.quantity;
    }

    public String getId() {
        return id;
    }

    public String getMedID() {
        return medID;
    }

    public String getMedDescription() {
        return medDescription;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public static class Builder{
    
        private String id;
        private String medID;
        private String medDescription;
        private int quantity;
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder medID(String val){
            
            this.medID = val;
            
            return this;
        }
        
        public Builder medDescription(String val){
            
            this.medDescription = val;
            
            return this;
        }
        
        public Builder quantity(int val){
            
            this.quantity = val;
            
            return this;
        }
        
        public Medicine build(){
            
            return new Medicine(this);
        }
        
        public Builder medicine(Medicine med){
            
            this.id = med.getId();
            this.medDescription = med.getMedDescription();
            this.medID = med.getMedID();
            this.quantity = med.getQuantity();
            
            return this;
        }
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Medicine other = (Medicine) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

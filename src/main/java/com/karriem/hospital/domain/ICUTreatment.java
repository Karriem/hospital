/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author karriem
 */
@Embeddable
public class ICUTreatment implements Serializable{
    
    private String id;
    private String treatmentID;
    private String treatmentDescription;
    private int cost;
    
    public ICUTreatment(Builder builder){
        
        id = builder.id;
        treatmentID = builder.treatmetnID;
        treatmentDescription = builder.treatmentDescription;
        cost = builder.cost;
    }

    public String getId() {
        return id;
    }

    public String getTreatmentID() {
        return treatmentID;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public int getCost() {
        return cost;
    }
    
    public static class Builder{
        
        private String id;
        private String treatmetnID;
        private String treatmentDescription;
        private int cost;
        
        public Builder id(String val){
            
            this.id = val;
                    
            return this;        
        }
        
        public Builder treatmetnID(String val){
            
            this.treatmetnID = val;
                    
            return this;        
        }
        
        public Builder treatmentDescription(String val){
            
            this.treatmentDescription = val;
                    
            return this;        
        }
        
        public Builder cost(int val){
            
            this.cost = val;
                    
            return this;        
        }
        
        public ICUTreatment build(){
            
            return new ICUTreatment(this);
        }
        
        public Builder icuTreatment(ICUTreatment icuT){
            
            this.id = icuT.getId();
            this.treatmetnID = icuT.getTreatmentID();
            this.treatmentDescription = icuT.getTreatmentDescription();
            this.cost = icuT.getCost();
            
            return this;
        }               
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ICUTreatment other = (ICUTreatment) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

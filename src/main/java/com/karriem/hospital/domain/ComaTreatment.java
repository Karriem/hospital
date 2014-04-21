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
public class ComaTreatment implements Serializable{
    
    private String id;
    private String treatmetnID;
    private String treatmentDescription;
    private int cost;

    public ComaTreatment() {
    }
    
    public ComaTreatment(Builder builder){
        
        id = builder.id;
        treatmetnID = builder.treatmetnID;
        treatmentDescription = builder.treatmentDescription;
        cost = builder.cost;
    }

    public String getId() {
        return id;
    }

    public String getTreatmetnID() {
        return treatmetnID;
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
        
        public ComaTreatment build(){
            
            return new ComaTreatment(this);
        }
        
        public Builder comaTreatment(ComaTreatment comaT){
            
            this.id = comaT.getId();
            this.treatmetnID = comaT.getTreatmetnID();
            this.treatmentDescription = comaT.getTreatmentDescription();
            this.cost = comaT.getCost();
            
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
        final ComaTreatment other = (ComaTreatment) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

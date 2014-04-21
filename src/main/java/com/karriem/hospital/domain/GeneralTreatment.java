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
public class GeneralTreatment implements Serializable{
    
    private String id;
    private String treatmetnID;
    private String treatmentDescription;
    private int cost;
    
    public GeneralTreatment(Builder builder){
        
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

    public  String getTreatmentDescription() {
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
        
        public GeneralTreatment build(){
            
            return new GeneralTreatment(this);
        }
        
        public Builder genTreatment(GeneralTreatment genT){
            
            this.id = genT.getId();
            this.treatmetnID = genT.getTreatmetnID();
            this.treatmentDescription = genT.getTreatmentDescription();
            this.cost = genT.getCost();
            
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
        final GeneralTreatment other = (GeneralTreatment) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

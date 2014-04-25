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
 * @author Karriem
 */
@Entity
public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String treatmentId;
    private String description;
    private float cost;

    public Treatment() {
    }
    
    public Treatment(Builder build){
        
        id = build.id;
        treatmentId = build.treatmentId;
        description = build.description;
        cost = build.cost;
    }
    
    public Long getId() {
        return id;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getDescription() {
        return description;
    }

    public float getCost() {
        return cost;
    }
    
    public static class Builder{
        
        private Long id;
        private String treatmentId;
        private String description;
        private float cost;
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder treatmentId(String val){
            
            this.treatmentId = val;
            
            return this;
        }
        
        public Builder description(String val){
            
            this.description = val;
            
            return this;
        }
        
        public Builder cost(float val){
            
            this.cost = val;
            
            return this;
        }
        
        public Treatment build(){
            
            return new Treatment(this);
        }
        
        public Builder treatment(Treatment treat){
            
            this.cost = treat.getCost();
            this.description = treat.getDescription();
            this.id = treat.getId();
            this.treatmentId = treat.getTreatmentId();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.karriem.hospital.domain.Treatment[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
    private int cost;
    @OneToMany
    @JoinColumn(columnDefinition = "MEDEQUIP_ID")
    private List<MedicalEquipment> medEquip;
    @OneToMany
    @JoinColumn(columnDefinition = "MED_ID")
    private List<Medicine> med;

    public Treatment() {
    }
    
    public Treatment(Builder build){
        
        id = build.id;
        treatmentId = build.treatmentId;
        description = build.description;
        cost = build.cost;
        medEquip = build.medEquip;
        med = build.med;        
    }
    
    public Long getId() {
        return id;
    }

    public List<MedicalEquipment> getMedEquip() {
        return medEquip;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public List<Medicine> getMed() {
        return med;
    }
    
    public static class Builder{
        
        private Long id;
        private String treatmentId;
        private String description;
        private int cost;
        private List<MedicalEquipment> medEquip;
        private List<Medicine> med;
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder treatmentId(String val){
            
            this.treatmentId = val;
            
            return this;
        }
        
        public Builder medicalEquip(List<MedicalEquipment> val){
            
            this.medEquip = val;
            
            return this;
        }
        
        public Builder medicine(List<Medicine> val){
            
            this.med = val;
            
            return this;
        }
        
        public Builder description(String val){
            
            this.description = val;
            
            return this;
        }
        
        public Builder cost(int val){
            
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
            this.med = treat.getMed();
            this.medEquip = treat.getMedEquip();
            
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

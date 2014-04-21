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
public class MedicalAid implements Serializable{
    
    private String id;
    private String medicalAidNo;
    private String patientID;
    private String lastName;
    private String medicalAidName;
    private String typeCover;
    private int amtCover;
    
    public MedicalAid(Builder builder){
        
        id = builder.id;
        medicalAidNo = builder.medicalAidNo;
        patientID = builder.patientID;
        lastName = builder.lastName;
        medicalAidName = builder.medicalAidName;
        typeCover = builder.typeCover;
        amtCover = builder.amtCover;
    }

    public String getId() {
        return id;
    }

    public String getMedicalAidNo() {
        return medicalAidNo;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public String getTypeCover() {
        return typeCover;
    }

    public int getAmtCover() {
        return amtCover;
    }
    
    public static class Builder{
        
        private String id;
        private String medicalAidNo;
        private String patientID;
        private String lastName;
        private String medicalAidName;
        private String typeCover;
        private int amtCover;
        
        public Builder id(String val){
            
           this.id = val;
           
           return this;
        }
        
        public Builder medicalAidNo(String val){
            
           this.medicalAidNo = val;
           
           return this;
        }
        
        public Builder patientID(String val){
            
           this.patientID = val;
           
           return this;
        }
        
        public Builder lastName(String val){
            
           this.lastName = val;
           
           return this;
        }
        
        public Builder medicalAidName(String val){
            
           this.medicalAidName = val;
           
           return this;
        }
        
        public Builder typeCover(String val){
            
           this.typeCover = val;
           
           return this;
        }
        
        public Builder amtCover(int val){
            
           this.amtCover = val;
           
           return this;
        }
        
        public MedicalAid build(){
            
            return new MedicalAid(this);
        }
        
        public Builder medicalAid(MedicalAid medical){
         
            this.id = medical.getId();
            this.patientID = medical.getPatientID();
            this.amtCover = medical.getAmtCover();
            this.lastName = medical.getLastName();
            this.medicalAidName = medical.getMedicalAidName();
            this.medicalAidNo = medical.getMedicalAidNo();
            this.typeCover = medical.getTypeCover();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MedicalAid other = (MedicalAid) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

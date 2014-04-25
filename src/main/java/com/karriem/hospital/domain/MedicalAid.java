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
    
    private String medicalAidNo;
    private String medicalAidName;
    private String typeCover;
    private int amtCover;

    public MedicalAid() {
    }
    
    public MedicalAid(Builder builder){
        
        medicalAidNo = builder.medicalAidNo;
        medicalAidName = builder.medicalAidName;
        typeCover = builder.typeCover;
        amtCover = builder.amtCover;
    }

    public String getMedicalAidNo() {
        return medicalAidNo;
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
        
        private String medicalAidNo;
        private String medicalAidName;
        private String typeCover;
        private int amtCover;
               
        public Builder medicalAidNo(String val){
            
           this.medicalAidNo = val;
           
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
         
            this.amtCover = medical.getAmtCover();
            this.medicalAidName = medical.getMedicalAidName();
            this.medicalAidNo = medical.getMedicalAidNo();
            this.typeCover = medical.getTypeCover();
            
            return this;
        }
    }
    
}

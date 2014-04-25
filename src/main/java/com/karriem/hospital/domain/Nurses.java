/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author karriem
 */
@Entity
public class Nurses implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nurID;
    private String jobDescription;
    private String ward;
    @Embedded
    private ContactDetails contact;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;

    public Nurses() {
    }

    private Nurses(Builder builder) {
        
        id = builder.id;
        nurID = builder.nurID;
        jobDescription = builder.jobDescription;
        demo = builder.demo;
        name = builder.name;
        contact = builder.contact;
        ward = builder.ward;
    }

    public Names getName() {
        return name;
    }

    public Demographic getDemo() {
        return demo;
    }
    
    public Long getId() {
        return id;
    }

    public String getNurID() {
        return nurID;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public String getWard() {
        return ward;
    }    
   
    public static class Builder{
        
        private Long id;
        private String nurID;
        private String jobDescription;
        private ContactDetails contact;
        private String ward;
        private Names name;
        private Demographic demo;
        
        public Builder() {
            
        }
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder nurID(String val){
            
            this.nurID = val;
            
            return this;
        }
        
        public Builder jobDescription(String val){
            
            this.jobDescription = val;
            
            return this;
        }
        
        public Builder contactDetails(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public Builder ward(String val){
            
            this.ward = val;
            
            return this;
        }
        
        public Builder names(Names name){
            
            this.name = name;
            
            return this;
        }
        
        public Builder demographic(Demographic demo){
            
            this.demo = demo;
            
            return this;
        }
        
        public Nurses build(){
            
            return new Nurses(this);
        }
        
        public Builder nurse(Nurses nurse){
            
            this.id = nurse.getId();
            this.nurID = nurse.getNurID();
            this.jobDescription = nurse.getJobDescription();
            this.contact = nurse.getContact();
            this.ward = nurse.getWard();
            this.demo = nurse.getDemo();
            this.name = nurse.getName();
            
            return this;
        }
    } 
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Nurses other = (Nurses) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

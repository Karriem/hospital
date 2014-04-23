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
public class CleaningStaff implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cleanID;
    private Names name;
    private Demographic demo;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;

    public CleaningStaff() {
    }

    public CleaningStaff(Builder builder){
        
        id = builder.id;
        cleanID = builder.cleanID;
        name = builder.name;
        demo = builder.demo;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
    }

    public Long getId() {
        return id;
    }

    public String getCleanID() {
        return cleanID;
    }

    public Names getName() {
        return name;
    }

    public Demographic getDemo() {
        return demo;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public ContactDetails getContact() {
        return contact;
    }
    
    public static class Builder{
        
        private Long id;
        private String cleanID;
        private Names name;
        private Demographic demo;
        private String jobDescription;
        private ContactDetails contact;
        
        public Builder() {
        
        }
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder cleanID(String val){
            
            this.cleanID = val;
            
            return this;
        }        
        
        public Builder names(Names val){
            
            this.name = val;
            
            return this;
        } 
        
        public Builder demographic(Demographic demo){
            
            this.demo = demo;
            
            return this;
        }
        
        public Builder jobDescription(String val){
            
            this.jobDescription = val;
            
            return this;
        }
        
        public Builder contact(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public CleaningStaff build(){
            
            return new CleaningStaff(this);
        }
        
        public Builder cleaningStaff(CleaningStaff clean){
            
            this.id = clean.getId();
            this.cleanID = clean.getCleanID();
            this.name = clean.getName();
            this.demo = clean.getDemo();
            this.jobDescription = clean.getJobDescription();
            this.contact = clean.getContact();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final CleaningStaff other = (CleaningStaff) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }    
}

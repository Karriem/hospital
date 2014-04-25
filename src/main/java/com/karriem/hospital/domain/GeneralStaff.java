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
public class GeneralStaff implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String genID;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;
    private float salary;

    public GeneralStaff() {
    }

    private GeneralStaff(Builder builder) {
        
        id = builder.id;
        genID = builder.genID;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        demo = builder.demo;
        name = builder.name;
        salary = builder.salary;
    }
    
    public Long getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    public String getGenID() {
        return genID;
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
        private String genID;
        private Names name;
        private Demographic demo;
        private String jobDescription;
        private ContactDetails contact;
        private float salary;
        
        public Builder() {
            
        }
        
        public Builder salary(float salary){
            
            this.salary = salary;
            
            return this;
        }
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder genID(String val){
            
            this.genID = val;
            
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
        
        public Builder jobDescription(String val){
            
            this.jobDescription = val;
            
            return this;
        }
        
        public Builder contactDetails(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public GeneralStaff build(){
            
            return new GeneralStaff(this);
        }
        
        public Builder generalStaff(GeneralStaff mainten){
            
            this.id = mainten.getId();
            this.genID = mainten.getGenID();
            this.demo = mainten.getDemo();
            this.name = mainten.getName();
            this.jobDescription = mainten.getJobDescription();
            this.contact = mainten.getContact();
            this.salary = mainten.getSalary();
            
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
        final GeneralStaff other = (GeneralStaff) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

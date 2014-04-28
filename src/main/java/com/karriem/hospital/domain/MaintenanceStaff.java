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
public class MaintenanceStaff implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mID;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;
    private double salary;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;

    public MaintenanceStaff() {
    }

    private MaintenanceStaff(Builder builder) {
        
        id = builder.id;
        mID = builder.mID;
        name = builder.name;
        demo = builder.demo;
        salary = builder.salary;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
    }
    
    public Long getId() {
        return id;
    }

    public Names getName() {
        return name;
    }

    public Demographic getDemo() {
        return demo;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }  

    public String getmID() {
        return mID;
    }

    public ContactDetails getContact() {
        return contact;
    }
   
    public static class Builder{
        
        private Long id;
        private String mID;
        private Names name;
        private Demographic demo;
        private double salary;
        private String jobDescription;
        private ContactDetails contact;

        public Builder() {
            
        }
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder mID(String val){
            
            this.mID = val;
            
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
        
        public Builder salary(double val){
            
            this.salary = val;
            
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
        
        public MaintenanceStaff build(){
            
            return new MaintenanceStaff(this);
        }
        
        public Builder maintenance(MaintenanceStaff mainten){
            
            this.id = mainten.getId();
            this.mID = mainten.getmID();
            this.demo = mainten.getDemo();
            this.name = mainten.getName();
            this.salary = mainten.getSalary();
            this.jobDescription = mainten.getJobDescription();
            this.contact = mainten.getContact();
            
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
        final MaintenanceStaff other = (MaintenanceStaff) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

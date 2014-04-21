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
    private String id;
    private String mID;
    private String firstName;
    private String lastName;
    private int age;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;

    public MaintenanceStaff() {
    }

    private MaintenanceStaff(Builder builder) {
        
        id = builder.id;
        mID = builder.mID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
    }
    
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
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
        
        private String id;
        private String mID;
        private String firstName;
        private String lastName;
        private int age;
        private String jobDescription;
        private ContactDetails contact;

        public Builder() {
            
        }
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder mID(String val){
            
            this.mID = val;
            
            return this;
        }
        
        public Builder firstName(String val){
            
            this.firstName = val;
            
            return this;
        }
        
        public Builder lastName(String val){
            
            this.lastName = val;
            
            return this;
        }
        
        public Builder age(int val){
            
            this.age = val;
            
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
            this.firstName = mainten.getFirstName();
            this.lastName = mainten.getLastName();
            this.age = mainten.getAge();
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

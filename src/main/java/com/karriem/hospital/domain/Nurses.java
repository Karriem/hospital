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
 * @author karriem
 */
@Entity
public class Nurses implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nurID;
    private String firstName;
    private String lastName;
    private int age;
    private String jobDescription;
    private ContactDetails contact;
    private String ward;

    public Nurses() {
    }

    private Nurses(Builder builder) {
        
        id = builder.id;
        nurID = builder.nurID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        ward = builder.ward;
    }
    
    public String getId() {
        return id;
    }

    public String getNurID() {
        return nurID;
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

    public ContactDetails getContact() {
        return contact;
    }

    public String getWard() {
        return ward;
    }    
   
    public static class Builder{
        
        private String id;
        private String nurID;
        private String firstName;
        private String lastName;
        private int age;
        private String jobDescription;
        private ContactDetails contact;
        private String ward;

        public Builder() {
            
        }
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder nurID(String val){
            
            this.nurID = val;
            
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
        
        public Builder ward(String val){
            
            this.ward = val;
            
            return this;
        }
        
        public Nurses build(){
            
            return new Nurses(this);
        }
        
        public Builder nurse(Nurses nurse){
            
            this.id = nurse.getId();
            this.nurID = nurse.getNurID();
            this.firstName = nurse.getFirstName();
            this.lastName = nurse.getLastName();
            this.age = nurse.getAge();
            this.jobDescription = nurse.getJobDescription();
            this.contact = nurse.getContact();
            this.ward = nurse.getWard();
            
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

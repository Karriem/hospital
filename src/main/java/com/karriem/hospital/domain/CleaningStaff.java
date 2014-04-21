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
    private String id;
    private String cleanID;
    private String firstName;
    private String lastName;
    private int age;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;
    @Embedded
    private GeneralEquipment equip;

    public CleaningStaff() {
    }

    public CleaningStaff(Builder builder){
        
        id = builder.id;
        cleanID = builder.cleanID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        equip = builder.equip;
    }

    public String getId() {
        return id;
    }

    public String getCleanID() {
        return cleanID;
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

    public GeneralEquipment getEquip() {
        return equip;
    }

    
    public static class Builder{
        
        private String id;
        private String cleanID;
        private String firstName;
        private String lastName;
        private int age;
        private String jobDescription;
        private ContactDetails contact;
        private GeneralEquipment equip;
        
        public Builder() {
        
        }
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder cleanID(String val){
            
            this.cleanID = val;
            
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
        
        public Builder contact(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public Builder equip(GeneralEquipment equip){
            
            this.equip = equip;
            
            return this;
        }
        
        public CleaningStaff build(){
            
            return new CleaningStaff(this);
        }
        
        public Builder cleaningStaff(CleaningStaff clean){
            
            this.id = clean.getId();
            this.cleanID = clean.getCleanID();
            this.firstName = clean.getFirstName();
            this.lastName = clean.getLastName();
            this.age = clean.getAge();
            this.jobDescription = clean.getJobDescription();
            this.contact = clean.getContact();
            this.equip = clean.getEquip();
            
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

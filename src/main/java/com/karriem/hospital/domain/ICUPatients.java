/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author karriem
 */
@Embeddable
public class ICUPatients implements Serializable{
 
    private String id;
    private String patID;
    private String firstName;
    private String lastName;
    private int age;
    @Embedded
    private ContactDetails contact;
    private String illness;
    @OneToOne
    private Treatment treatment;
    private String doctorID;
    @OneToMany
    private Medicine medicine;
    private String bedNumber;

    public ICUPatients() {
    }

    public ICUPatients(Builder builder) {
        
        id = builder.id;
        patID = builder.patID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        contact = builder.contact;
        illness = builder.illness;
        treatment = builder.treatment;
        doctorID = builder.doctorID;
        medicine = builder.medicine;
        bedNumber = builder.bedNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public String getId() {
        return id;
    }

    public String getPatID() {
        return patID;
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

    public ContactDetails getContact() {
        return contact;
    }
    
    public String getIllness() {
        return illness;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public static class Builder{
        
        private String id;
        private String patID;
        private String firstName;
        private String lastName;
        private int age;
        private ContactDetails contact;
        private String illness;
        private Treatment treatment;
        private String doctorID;
        private Medicine medicine;  
        private String bedNumber;
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder patID(String val){
            
            this.patID = val;
            
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
        
        public Builder contactDetails (ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public Builder illness(String val){
            
            this.illness = val;
            
            return this;
        }
        public Builder treatment(Treatment val){
            
            this.treatment = val;
            
            return this;
        }
        public Builder doctorID(String val){
            
            this.doctorID = val;
            
            return this;
        }
        public Builder medicine(Medicine val){
            
            this.medicine = val;
            
            return this;
        }
        
        public Builder bedNumber(String val){
            
            this.bedNumber = val;
            
            return this;
        }
        
        public ICUPatients build(){
            
            return new ICUPatients(this);
        }
        
        public Builder icuPatients(ICUPatients icu){
            
            this.id = icu.getId();
            this.patID = icu.getPatID();
            this.firstName = icu.getFirstName();
            this.lastName = icu.getLastName();
            this.age = icu.getAge();
            this.contact = icu.getContact();
            this.illness = icu.getIllness();
            this.treatment = icu.getTreatment();
            this.medicine = icu.getMedicine();
            this.doctorID = icu.getDoctorID();
            this.bedNumber = icu.getBedNumber();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ICUPatients other = (ICUPatients) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    
}

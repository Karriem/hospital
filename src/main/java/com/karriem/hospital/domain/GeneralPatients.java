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
public class GeneralPatients implements Serializable {
    
    private String id;
    private String patID;
    private String firstName;
    private String lastName;
    private int age;
    private String illness;
    @OneToOne
    private Treatment treatment;
    @OneToMany
    private Medicine medicine;
    private String doctorID;
    @Embedded
    private ContactDetails contact;
    
    public GeneralPatients(){
        
    }
    
    public GeneralPatients(Builder builder){
        
        id = builder.id;
        patID = builder.patID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        illness = builder.illness;
        doctorID = builder.doctorID;
        treatment = builder.treatment;
        medicine = builder.medicine;
        contact = builder.contact;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public ContactDetails getContact() {
        return contact;
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

    public String getIllness() {
        return illness;
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
        private String illness;
        private Treatment treatment;
        private Medicine medicine;
        private String doctorID;
        private ContactDetails contact;
        
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
        
        public Builder illness(String val){
            
            this.illness = val;
            
            return this;
        }
        
        public Builder doctorID(String val){
            
            this.doctorID = val;
            
            return this;
        }
        
        public Builder treatment(Treatment treatment){
            
            this.treatment = treatment;
            
            return this;
        }
        
        public Builder medicine(Medicine medicine){
            
            this.medicine = medicine;
            
            return this;
        }
        
        public Builder contact(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public GeneralPatients build(){
            
            return new GeneralPatients(this);
        }
        
        public Builder patients(GeneralPatients pat){
            
            this.id = pat.getId();
            this.patID = pat.getPatID();
            this.firstName = pat.getFirstName();
            this.lastName = pat.getLastName();
            this.age = pat.getAge();
            this.illness = pat.getIllness();
            this.doctorID = pat.getDoctorID();
            this.treatment = pat.getTreatment();
            this.medicine = pat.getMedicine();
            this.contact = pat.getContact();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final GeneralPatients other = (GeneralPatients) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

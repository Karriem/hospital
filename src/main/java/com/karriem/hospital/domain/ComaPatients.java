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
public class ComaPatients implements Serializable{
    
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
    private String durationOfComa;
    private String bedNumber;

    public ComaPatients() {
    }

    public ComaPatients(Builder build){
        
        id = build.id;
        patID = build.patID;
        firstName = build.firstName;
        lastName = build.lastName;
        age = build.age;
        illness = build.illness;
        treatment = build.treatment;
        medicine = build.medicine;
        doctorID = build.doctorID;
        contact = build.contact;
        durationOfComa = build.durationOfComa;
        bedNumber = build.bedNumber;
    }
    
    public Medicine getMedicine() {
        return medicine;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public String getBedNumber() {
        return bedNumber;
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

    public Treatment getTreatment() {
        return treatment;
    }

    public String getDoctorID() {
        return doctorID;
    }


    public String getDurationOfComa() {
        return durationOfComa;
    }
   
    public static class Builder{
        
        private String id;
        private String patID;
        private String firstName;
        private String lastName;
        private int age;
        private String illness;
        private Treatment treatment;
        private String doctorID;
        private String durationOfComa;
        private String bedNumber;
        private Medicine medicine; 
        private ContactDetails contact;
        
        public Builder id(String val){
            
            this.id = val;
            
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
        
        public Builder treatment(Treatment treat){
            
            this.treatment = treat;
            
            return this;
        }
        
        public Builder doctorID(String val){
            
            this.doctorID = val;
            
            return this;
        }
        
        public Builder durationOfComa(String val){
            
            this.durationOfComa = val;
            
            return this;
        }
        
        public Builder bedNumber(String val){
            
            this.bedNumber = val;
            
            return this;
        }
        
        public ComaPatients build(){
            
            return new ComaPatients(this);
        }
        
        public Builder comaPatients(ComaPatients coma){
            
            this.id = coma.getId();
            this.patID = coma.getPatID();
            this.firstName = coma.getFirstName();
            this.lastName = coma.getLastName();
            this.age = coma.getAge();
            this.illness = coma.getIllness();
            this.treatment = coma.getTreatment();
            this.doctorID = coma.getDoctorID();
            this.durationOfComa = coma.getDurationOfComa();
            this.bedNumber = coma.getBedNumber();
            this.contact = coma.getContact();
            this.medicine = coma.getMedicine();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ComaPatients other = (ComaPatients) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

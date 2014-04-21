/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author karriem
 */
@Embeddable
public class TerminalPatients implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String timeLeft;
    private String bedNumber;

    public TerminalPatients() {
    }

    public TerminalPatients (Builder builder){
        
        id = builder.id;
        patID = builder.patID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        illness = builder.illness;
        treatment = builder.treatment;
        medicine = builder.medicine;
        doctorID = builder.doctorID;
        contact = builder.contact;
        timeLeft = builder.timeLeft;
        bedNumber = builder.bedNumber;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public ContactDetails getConatact() {
        return contact;
    }
    
    public String getTimeLeft() {
        return timeLeft;
    }

    public String getBedNumber() {
        return bedNumber;
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
        private String timeLeft;
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
        
        public Builder illness(String val){
            
            this.illness = val;
            
            return this;
        }
        
        public Builder treatment(Treatment val){
            
            this.treatment = val;
            
            return this;
        }
        
        public Builder medicine(Medicine val){
            
            this.medicine = val;
            
            return this;
        }
        
        public Builder doctorID(String val){
            
            this.doctorID = val;
            
            return this;
        }
        
        public Builder contactDetails(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public Builder timeLeft(String val){
            
            this.timeLeft = val;
            
            return this;
        }
        
        public Builder bedNumber(String val){
            
            this.bedNumber = val;
            
            return this;
        }
        
        public TerminalPatients build(){
            
            return new TerminalPatients(this);
        }
        
        public Builder terminalPatients(TerminalPatients tPat){
            
            this.id = tPat.getId();
            this.patID = tPat.getPatID();
            this.firstName = tPat.getFirstName();
            this.lastName = tPat.getLastName();
            this.age = tPat.getAge();
            this.illness = tPat.getIllness();
            this.treatment = tPat.getTreatment();
            this.medicine = tPat.getMedicine();
            this.doctorID = tPat.getDoctorID();
            this.contact = tPat.getConatact();
            this.timeLeft = tPat.getTimeLeft();
            this.bedNumber = tPat.getBedNumber();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TerminalPatients other = (TerminalPatients) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

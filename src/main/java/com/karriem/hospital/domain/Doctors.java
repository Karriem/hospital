/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author karriem
 */
@Entity
public class Doctors implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String docID;
    private String firstName;
    private String lastName;
    private int age;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;
    @OneToMany
    private List<Patients> patientsList;

    public Doctors(Builder builder){
        
        id = builder.id;
        docID = builder.docID;
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        patientsList = builder.patientsList;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public List<Patients> getPatientsList() {
        return patientsList;
    }
        
    public String getId() {
        return id;
    }

    public String getDocID() {
        return docID;
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

    public static class Builder {
        
        private String id;
        private String docID;
        private String firstName;
        private String lastName;
        private int age;
        private String jobDescription;
        private ContactDetails contact;
        private List<Patients> patientsList;
        
        public Builder() {
        }

        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }  
        
        public Builder docId(String val){
            
            this.docID = val;
            
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
        
        public Builder jobDescription(String val){
            
            this.jobDescription = val;
            
            return this;
        }
        
        public Builder age(int val){
            
            this.age = val;
            
            return this;
        }
        
        public Builder contactDetails(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        } 
        
        public Builder patientsList(List val){
            
            this.patientsList = val;
            
            return this;
        }
        
        public Doctors build(){
            
            return new Doctors(this);
        }
        
        public Builder doctor(Doctors doctor){
            
            this.id = doctor.getId();
            this.docID = doctor.getDocID();
            this.firstName = doctor.getFirstName();
            this.lastName = doctor.getLastName();
            this.age = doctor.getAge();
            this.jobDescription = doctor.getJobDescription();
            this.patientsList = doctor.getPatientsList();
            this.contact = doctor.getContact();
            
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
        final Doctors other = (Doctors) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }  

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

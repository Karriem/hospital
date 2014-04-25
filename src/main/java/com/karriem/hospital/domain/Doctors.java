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
public class Doctors implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String docID;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;
    private double salary;

    public Doctors() {
    }

    public Doctors(Builder builder){
        
        id = builder.id;
        docID = builder.docID;
        name = builder.name;
        demo = builder.demo;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        salary = builder.salary;
    }

    public double getSalary() {
        return salary;
    }

    public ContactDetails getContact() {
        return contact;
    }
        
    public Long getId() {
        return id;
    }

    public String getDocID() {
        return docID;
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

    public static class Builder {
        
        private Long id;
        private String docID;
        private Names name;
        private Demographic demo;
        private String jobDescription;
        private ContactDetails contact;
        private double salary;
        
        public Builder() {
        }

        public Builder(Long id) {
            this.id = id;
        }

        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }  
        
        public Builder salary(double val){
            
            this.salary = val;
            
            return this;
        }
        
        public Builder docId(String val){
            
            this.docID = val;
            
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
        
        public Doctors build(){
            
            return new Doctors(this);
        }
        
        public Builder doctor(Doctors doctor){
            
            this.id = doctor.getId();
            this.docID = doctor.getDocID();
            this.demo = doctor.getDemo();
            this.name = doctor.getName();
            this.jobDescription = doctor.getJobDescription();
            this.contact = doctor.getContact();
            this.salary = doctor.getSalary();
            
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

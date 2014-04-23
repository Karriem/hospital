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
 * @author Karriem
 */
@Entity
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patientID;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;
    @Embedded
    private ContactDetails contact;
    private String patientType;
    private String illness;
    private String treatmentID;
    private String medicineID;
    private String roomNo;
    private PaymentMethod pay;

    public Patients() {
    }
   
    public Patients(Builder build){
        
        id = build.id;
        patientID = build.patientID;
        name = build.names;
        demo = build.demo;
        contact = build.contact;
        patientType = build.patientType;
        illness = build.illness;
        treatmentID = build.treatmentID;
        medicineID = build.medicineID;
        roomNo = build.roomNo;
        pay = build.pay;
    }
    
    public Long getId() {
        return id;
    }

    public PaymentMethod getPay() {
        return pay;
    }

    public String getPatientID() {
        return patientID;
    }

    public Names getName() {
        return name;
    }

    public Demographic getDemo() {
        return demo;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public String getPatientType() {
        return patientType;
    }

    public String getIllness() {
        return illness;
    }

    public String getTreatmentID() {
        return treatmentID;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public static class Builder{
        
        private Long id;
        private String patientID;
        private Names names;
        private Demographic demo;
        private ContactDetails contact;
        private String patientType;
        private String illness;
        private String treatmentID;
        private String medicineID;
        private String roomNo;
        private PaymentMethod pay;
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder paymentMethod(PaymentMethod pay){
            
            this.pay = pay;
            
            return this;
        }
        
        public Builder patientID(String val){
            
            this.patientID = val;
            
            return this;
        }
        
        public Builder names(Names val){
            
            this.names = val;
            
            return this;
        }
        
        public Builder demographic(Demographic val){
            
            this.demo = val;
            
            return this;
        }
        
        public Builder contactDetails(ContactDetails val){
            
            this.contact = val;
            
            return this;
        }
        
        public Builder patientType(String val){
            
            this.patientType = val;
            
            return this;
        }
        
        public Builder illness(String val){
            
            this.illness = val;
            
            return this;
        }
        
        public Builder treatmentID(String val){
            
            this.treatmentID = val;
            
            return this;
        }
        
        public Builder medicineID(String val){
            
            this.medicineID = val;
            
            return this;
        }
        
        public Builder roomNo(String val){
            
            this.roomNo = val;
            
            return this;
        }       
        
        public Patients build(){
            
            return new Patients(this);
        }
        
        public Builder patients(Patients pat){
            
            this.contact = pat.getContact();
            this.demo = pat.getDemo();
            this.id = pat.getId();
            this.illness = pat.getIllness();
            this.medicineID = pat.getMedicineID();
            this.names = pat.getName();
            this.patientID = pat.getPatientID();
            this.patientType = pat.getPatientType();
            this.roomNo = pat.getRoomNo();
            this.treatmentID = pat.getTreatmentID();
            this.pay = pat.getPay();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.karriem.hospital.domain.Patients[ id=" + id + " ]";
    }
    
}

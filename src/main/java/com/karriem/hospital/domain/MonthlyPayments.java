/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author karriem
 */
@Embeddable
public class MonthlyPayments implements Serializable{
    
    private String id;
    private String paymentID;
    private int treatmentCost;
    private int monthlyInstallments;
    private String patientID;
    private int months;

    public MonthlyPayments() {
    }

    public MonthlyPayments(Builder builder){
        
        id = builder.id;
        paymentID = builder.paymentID;
        treatmentCost = builder.treatmentCost;
        monthlyInstallments = builder.monthlyInstallments;
        patientID = builder.patientID;
        months = builder.months;
    }

    public int getMonths() {
        return months;
    }

    public String getId() {
        return id;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public int getTreatmentCost() {
        return treatmentCost;
    }

    public int getMonthlyInstallments() {
        return monthlyInstallments;
    }

    public String getPatientID() {
        return patientID;
    }
    
    public static class Builder{
        
        private String id;
        private String paymentID;
        private int treatmentCost;
        private int monthlyInstallments;
        private String patientID;
        private int months;
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder paymentID(String val){
            
            this.paymentID = val;
            
            return this;
        }
        
        public Builder treatmentCost(int val){
            
            this.treatmentCost = val;
            
            return this;
        }
        
        public Builder monthlyInstallments(int val){
            
            this.monthlyInstallments = val;
            
            return this;
        }
        
        public Builder patientID(String val){
            
            this.patientID = val;
            
            return this;
        }
        
        public Builder months(int val){
            
            this.months = val;
            
            return this;
        }
        
        public MonthlyPayments build(){
            
            return new MonthlyPayments(this);
        }
        
        public Builder monthlyPayments(MonthlyPayments mp){
            
            this.id = mp.getId();
            this.paymentID = mp.getPaymentID();
            this.treatmentCost = mp.getTreatmentCost();
            this.monthlyInstallments = mp.getMonthlyInstallments();
            this.patientID = mp.getPatientID();
            this.months = mp.getMonths();
            
            return this;
        } 
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MonthlyPayments other = (MonthlyPayments) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
}

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
    
    private String paymentID;
    private int treatmentCost;
    private int monthlyInstallments;
    private int months;

    public MonthlyPayments() {
    }

    public MonthlyPayments(Builder builder){
        
        paymentID = builder.paymentID;
        treatmentCost = builder.treatmentCost;
        monthlyInstallments = builder.monthlyInstallments;
        months = builder.months;
    }

    public int getMonths() {
        return months;
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
    
    public static class Builder{
        
        private String paymentID;
        private int treatmentCost;
        private int monthlyInstallments;
        private int months;
               
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
        
        public Builder months(int val){
            
            this.months = val;
            
            return this;
        }
        
        public MonthlyPayments build(){
            
            return new MonthlyPayments(this);
        }
        
        public Builder monthlyPayments(MonthlyPayments mp){
            
            this.paymentID = mp.getPaymentID();
            this.treatmentCost = mp.getTreatmentCost();
            this.monthlyInstallments = mp.getMonthlyInstallments();
            this.months = mp.getMonths();
            
            return this;
        } 
    }
    
}

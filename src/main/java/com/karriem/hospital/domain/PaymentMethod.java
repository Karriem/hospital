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
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Embedded
    private CreditCard credit;
    @Embedded
    private MedicalAid aid;
    @Embedded
    private MonthlyPayments mon; 

    public PaymentMethod() {
    }
    
    public PaymentMethod(Builder build){
        
        credit = build.credit;
        aid = build.aid;
        mon = build.mon;
    }
    
    public String getId() {
        return id;
    }

    public CreditCard getCredit() {
        return credit;
    }

    public MedicalAid getAid() {
        return aid;
    }

    public MonthlyPayments getMon() {
        return mon;
    }

    public static class Builder{
        
        private CreditCard credit;        
        private MedicalAid aid;        
        private MonthlyPayments mon; 
        
        public Builder(){
            
        }
        
        public Builder creditCard(CreditCard credit){
            
            this.credit = credit;
            
            return this;
        }
        
        public Builder medicalAid(MedicalAid aid){
            
            this.aid = aid;
            
            return this;
        }
        
        public Builder monthlyPayments(MonthlyPayments mon){
            
            this.mon = mon;
            
            return this;
        }
        
        public PaymentMethod build(){
            
            return new PaymentMethod(this);
        }
        
        public Builder paymentMethod(PaymentMethod pay){
            
            this.aid = pay.getAid();
            this.credit = pay.getCredit();
            this.mon = pay.getMon();
            
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
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.karriem.hospital.domain.PaymentMethod[ id=" + id + " ]";
    }
    
}

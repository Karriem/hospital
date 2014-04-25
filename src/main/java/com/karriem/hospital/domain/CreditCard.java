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
public class CreditCard implements Serializable{
    
    private String creditCardID;
    private String creditCardType;
    private String creditCardNo;
    private String accountHolder;

    public CreditCard() {
    }
    
    public CreditCard(Builder builder){
        
        creditCardID = builder.creditCardID;
        creditCardType = builder.creditCardType;
        creditCardNo = builder.creditCardNo;
        accountHolder = builder.accountHolder;
    }

    public String getCreditCardID() {
        return creditCardID;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
    
    public static class Builder{
        
        private String creditCardID;
        private String creditCardType;
        private String creditCardNo;
        private String accountHolder;
                
        public Builder creditCardID(String val){
            
            this.creditCardID = val;
            
            return this;
        }
        
        public Builder creditCardType(String val){
            
            this.creditCardType = val;
            
            return this;
        }
        
        public Builder creditCardNo(String val){
            
            this.creditCardNo = val;
            
            return this;
        }
        
        public Builder accountHolder(String val){
            
            this.accountHolder = val;
            
            return this;
        }
        
        public CreditCard build(){
            
            return new CreditCard(this);
        }
        
        public Builder creditCard(CreditCard cc){
            
            this.creditCardID = cc.getCreditCardID();
            this.creditCardType = cc.getCreditCardType();
            this.creditCardNo = cc.getCreditCardNo();
            this.accountHolder = cc.getAccountHolder();
            
            return this;
        }
    }

}

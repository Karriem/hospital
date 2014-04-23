/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Karriem
 */
@Embeddable
public class ContactDetails implements Serializable{
    
    private String postalAddress;
    private String landLine;
    private String cellNumber;
    @Column(unique = true)
    private String email;

    public ContactDetails() {
    }

    public ContactDetails(Builder builder){
        
        postalAddress = builder.postalAddress;
        landLine = builder.landLine;
        cellNumber = builder.cellNumber;
        email = builder.email;
    }
    
    public String getLandLine() {
        return landLine;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getEmail() {
        return email;
    }
    
    public static class Builder {
        
        private String postalAddress;
        private String landLine;
        private String cellNumber;
        @Column(unique = true)
        private String email;

        public Builder() {
        }
        
        public Builder postalAddress(String val){
            
            this.postalAddress = val;
            
            return this;
        }
        
        public Builder landLine(String val){
            
            this.landLine = val;
            
            return this;
        }
        
        public Builder cellnumber(String val){
            
            this.cellNumber = val;
            
            return this;
        }
        
        public Builder email(String val){
            
            this.email = val;
            
            return this;
        }
        
        public ContactDetails build(){
            
            return new ContactDetails(this);
        }
        
        public Builder contactDetails(ContactDetails contact){
            
            this.cellNumber = contact.getCellNumber();
            this.email = contact.getEmail();
            this.landLine = contact.getLandLine();
            this.postalAddress = contact.getPostalAddress();
            
            return this;
        }
    } 
}

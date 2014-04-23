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
 * @author Karriem
 */
@Embeddable
public class Names implements Serializable{
    
    private String firstName;
    private String lastName;

    public Names() {
    }

    public Names(Builder build){
        
        firstName = build.firstName;
        lastName = build.lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public static class Builder {
        
        private String firstName;
        private String lastName;
        
        public Builder firstName(String val){
            
            this.firstName = val;
            
            return this;
        }
        
        public Builder lastName(String val){
            
            this.lastName = val;
            
            return this;
        }
        
        public Names build(){
            
            return new Names(this);
        }
        
        public Builder names(Names name){
            
            this.firstName = name.getFirstName();
            this.lastName = name.getLastName();
            
            return this;
        }
    }
}

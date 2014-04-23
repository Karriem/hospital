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
public class Demographic implements Serializable{
    
    private String gender;
    private int age;

    public Demographic() {
    }

    public Demographic(Builder build){
        
        gender = build.gender;
        age = build.age;
    }
    
    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    
    public static class Builder {
        
        private String gender;
        private int age;
        
        public Builder gender(String val){
            
            this.gender = val;
            
            return this;
        }
        
        public Builder age(int val){
            
            this.age = val;
            
            return this;
        }
        
        public Demographic build(){
            
            return new Demographic(this);
        }
        
        public Builder demographic(Demographic demo){
            
            this.gender = demo.getGender();
            this.age = demo.getAge();
            
            return this;
        }
    }
}

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author karriem
 */
@Entity
public class CleaningStaff implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cleanID;
    @Embedded
    private Names name;
    @Embedded
    private Demographic demo;
    private String jobDescription;
    @Embedded
    private ContactDetails contact;
    @OneToMany
    @JoinColumn(columnDefinition = "GENEQUIP_ID")
    private List<GeneralEquipment> genEquip;
    private double salary;

    public CleaningStaff() {
    }

    public CleaningStaff(Builder builder){
        
        id = builder.id;
        cleanID = builder.cleanID;
        name = builder.name;
        demo = builder.demo;
        jobDescription = builder.jobDescription;
        contact = builder.contact;
        salary = builder.salary;
        genEquip = builder.genEquip;
    }

    public Long getId() {
        return id;
    }

    public List<GeneralEquipment> getGenEquip() {
        return genEquip;
    }

    public double getSalary() {
        return salary;
    }

    public String getCleanID() {
        return cleanID;
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

    public ContactDetails getContact() {
        return contact;
    }
    
    public static class Builder{
        
        private Long id;
        private String cleanID;
        private Names name;
        private Demographic demo;
        private String jobDescription;
        private ContactDetails contact;
        private double salary;
        private List<GeneralEquipment> genEquip;
        
        public Builder() {
        }

        public Builder(Long id) {
            this.id = id;
        }
        
        public Builder id(Long val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder salary(double salary){
            
            this.salary = salary;
            
            return this;
        }
        
        public Builder cleanID(String val){
            
            this.cleanID = val;
            
            return this;
        }        
        
        public Builder names(Names val){
            
            this.name = val;
            
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
        
        public Builder contact(ContactDetails contact){
            
            this.contact = contact;
            
            return this;
        }
        
        public Builder generalEquipment(List<GeneralEquipment> eEquip){
            
            this.genEquip = eEquip;
            
            return this;
        }
        
        public CleaningStaff build(){
            
            return new CleaningStaff(this);
        }
        
        public Builder cleaningStaff(CleaningStaff clean){
            
            this.id = clean.getId();
            this.cleanID = clean.getCleanID();
            this.name = clean.getName();
            this.demo = clean.getDemo();
            this.jobDescription = clean.getJobDescription();
            this.contact = clean.getContact();
            this.salary = clean.getSalary();
            this.genEquip = clean.getGenEquip();
            
            return this;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final CleaningStaff other = (CleaningStaff) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }    
}

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
public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Embedded
    private ComaTreatment coma;
    @Embedded
    private ICUTreatment icu;
    @Embedded
    private GeneralTreatment general;
    
    public Treatment (Builder build){
        
        id = build.id;
        coma = build.coma;
        icu = build.icu;
        general = build.general;
    }
    
    public String getId() {
        return id;
    }

    public ComaTreatment getComa() {
        return coma;
    }

    public ICUTreatment getIcu() {
        return icu;
    }

    public GeneralTreatment getGeneral() {
        return general;
    }

    public class Builder {
        
        private String id;
        @Embedded
        private ComaTreatment coma;
        @Embedded
        private ICUTreatment icu;
        @Embedded
        private GeneralTreatment general;
        
        public Builder (){
            
        }
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder comaTreatment(ComaTreatment coma){
            
            this.coma = coma;
            
            return this;
        }
        
        public Builder icuTreatment(ICUTreatment icu){
            
            this.icu = icu;
            
            return this;
        }
        
        public Builder generalTreatment(GeneralTreatment general){
            
            this.general = general;
            
            return this;
        }
        
        public Treatment build(){
            
            return new Treatment(this);
        }
        
        public Builder treatment(Treatment treat){
            
            this.id = treat.getId();
            this.coma = treat.getComa();
            this.icu = treat.getIcu();
            this.general = treat.getGeneral();
            
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
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.karriem.hospital.domain.Treatment[ id=" + id + " ]";
    }
    
}

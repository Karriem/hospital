/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domain;

import java.io.Serializable;
import java.util.Objects;
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
public class Patients implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Embedded
    private GeneralPatients generalp;
    @Embedded
    private ComaPatients coma;
    @Embedded
    private ICUPatients icu;
    @Embedded
    private TerminalPatients terminal;

    public Patients() {
    }

    public Patients (Builder builder){
        
        id = builder.id;
        generalp = builder.general;
        coma = builder.coma;
        icu = builder.icu;
        terminal = builder.terminal;
    }

    public TerminalPatients getTerminal() {
        return terminal;
    }

    public GeneralPatients getGeneralp() {
        return generalp;
    }

    public ComaPatients getComa() {
        return coma;
    }

    public ICUPatients getIcu() {
        return icu;
    }

    public String getId() {
        return id;
    }
    
    public static class Builder {
        
        private String id;
        private GeneralPatients general;
        private ComaPatients coma;
        private ICUPatients icu;
        private TerminalPatients terminal;
        
        public Builder(){
            
        }
        
        public Builder id(String val){
            
            this.id = val;
            
            return this;
        }
        
        public Builder generalPatients(GeneralPatients general){
            
            this.general = general;
            
            return this;
        }
        
        public Builder comaPatients(ComaPatients coma){
            
            this.coma = coma;
            
            return this;
        }
        
        public Builder icuPatients(ICUPatients icu){
            
            this.icu = icu;
            
            return this;
        }
        
        public Builder terminalPatients(TerminalPatients terminal){
            
            this.terminal = terminal;
            
            return this;
        }
        
        public Patients build(){
            
            return new Patients(this);
        }
        
        public Builder patients(Patients patient){
            
            this.id = patient.getId();
            this.coma = patient.getComa();
            this.general = patient.getGeneralp();
            this.icu = patient.getIcu();
            this.terminal = patient.getTerminal();
            
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Patients other = (Patients) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

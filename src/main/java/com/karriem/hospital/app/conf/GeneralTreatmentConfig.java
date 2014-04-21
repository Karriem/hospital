/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.GeneralTreatmentService;
import com.karriem.hospital.services.Impl.GeneralTreatmentServiceImpl;
import com.karriem.hospital.services.crud.GeneralTreatmentCrudService;
import com.karriem.hospital.services.crud.Impl.GeneralTreatmentCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class GeneralTreatmentConfig {
    
    @Bean (name = "genTreat")
    public GeneralTreatmentService getGeneral(){
        
        return new GeneralTreatmentServiceImpl();
    }
    
    @Bean (name = "generalTreatmentCrud")
    public GeneralTreatmentCrudService getGeneralTreatCrud(){
        
        return new GeneralTreatmentCrudServiceImpl();
    }
}

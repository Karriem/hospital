/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.ICUTreatmentService;
import com.karriem.hospital.services.Impl.ICUTreatmentServiceImpl;
import com.karriem.hospital.services.crud.ICUTreatmentCrudService;
import com.karriem.hospital.services.crud.Impl.ICUTreatmentCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class ICUTreatmentConfig {
    
    @Bean (name = "ICUTreat")
    public ICUTreatmentService getICU(){
        
        return new ICUTreatmentServiceImpl();
    }
    
    @Bean (name ="ICUCrud")
    public ICUTreatmentCrudService getICUCrud(){
        
        return new ICUTreatmentCrudServiceImpl();
    }
}

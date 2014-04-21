/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;



import com.karriem.hospital.services.ComaTreatmentService;
import com.karriem.hospital.services.Impl.ComaTreatmentServiceImpl;
import com.karriem.hospital.services.crud.ComaTreatmentCrudService;
import com.karriem.hospital.services.crud.Impl.ComaTreatmentCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class ComaTreatmentConfig {
    
    @Bean (name ="comaT")
    public ComaTreatmentService getComa(){
        
        return new ComaTreatmentServiceImpl();
    }
    
    @Bean (name = "comaCrud")
    public ComaTreatmentCrudService getComaTreatCrud(){
        
        return new ComaTreatmentCrudServiceImpl();
    }
}

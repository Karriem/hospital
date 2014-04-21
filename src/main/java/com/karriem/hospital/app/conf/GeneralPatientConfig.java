/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.GeneralPatientService;
import com.karriem.hospital.services.Impl.GeneralPatientServiceImpl;
import com.karriem.hospital.services.crud.GeneralPatientCrudService;
import com.karriem.hospital.services.crud.Impl.GeneralPatientCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class GeneralPatientConfig {
    
    @Bean (name = "genPat")
    public GeneralPatientService getGen(){
        
        return new GeneralPatientServiceImpl();
    }
    
    @Bean (name = "generalPatCrud")
    public GeneralPatientCrudService getGeneralCrud(){
        
        return new GeneralPatientCrudServiceImpl();
    }
}

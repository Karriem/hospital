/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.DoctorService;
import com.karriem.hospital.services.Impl.DoctorServiceImpl;
import com.karriem.hospital.services.crud.DoctorCrudService;
import com.karriem.hospital.services.crud.Impl.DoctorCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author karriem
 */
@Configuration
public class DoctorConfig {
    
    @Bean (name = "createDoc")    
    public DoctorService getDoctor(){
        
        return new DoctorServiceImpl();
    }
    
    @Bean (name = "doctorCrud")
    public DoctorCrudService getDoctorCrud(){
        
        return new DoctorCrudServiceImpl();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MedicineServiceImpl;
import com.karriem.hospital.services.MedicineService;
import com.karriem.hospital.services.crud.Impl.MedicineCrudServiceImpl;
import com.karriem.hospital.services.crud.MedicineCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MedicineConfig {
    
    @Bean (name = "medicine")
    public MedicineService getmed(){
        
        return new MedicineServiceImpl();
    }
    
    @Bean (name = "MedicineCrud")
    public MedicineCrudService getMedicineCrud(){
        
        return new MedicineCrudServiceImpl();
    }
}

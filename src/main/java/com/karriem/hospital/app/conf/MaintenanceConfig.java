/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MaintenanceServiceImpl;
import com.karriem.hospital.services.MaintenanceService;
import com.karriem.hospital.services.crud.Impl.MaintenanceCrudServiceImpl;
import com.karriem.hospital.services.crud.MaintenanceCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MaintenanceConfig {
    
    @Bean (name = "main")
    public MaintenanceService getMain(){
        
        return new MaintenanceServiceImpl();
    }
    
    @Bean (name = "mainCrud")
    public MaintenanceCrudService getMainCrud(){
        
        return new MaintenanceCrudServiceImpl();
    }
}

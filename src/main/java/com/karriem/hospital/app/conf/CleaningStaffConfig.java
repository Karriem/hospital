/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.CleaningStaffService;
import com.karriem.hospital.services.Impl.CleaningStaffServiceImpl;
import com.karriem.hospital.services.crud.CleaningStaffCrudService;
import com.karriem.hospital.services.crud.Impl.CleaningStaffCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class CleaningStaffConfig {
    
    @Bean (name = "cleaner")
    public CleaningStaffService getCleaner(){
        
       return new CleaningStaffServiceImpl();
    }
    
    @Bean (name = "CleanCrud")
    public CleaningStaffCrudService getCleanCrud(){
        
        return new CleaningStaffCrudServiceImpl();
    }
}

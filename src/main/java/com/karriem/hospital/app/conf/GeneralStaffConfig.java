/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.GeneralStaffService;
import com.karriem.hospital.services.Impl.GeneralStaffServiceImpl;
import com.karriem.hospital.services.crud.GeneralStaffCrudService;
import com.karriem.hospital.services.crud.Impl.GeneralStaffCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class GeneralStaffConfig {
    
    @Bean (name = "gen")
    public GeneralStaffService getGeneralStaff(){
        
        return new GeneralStaffServiceImpl();
    }
    
    @Bean (name = "generalCrud")
    public GeneralStaffCrudService getGeneralStaffCrud(){
        
        return new GeneralStaffCrudServiceImpl();
    }
}

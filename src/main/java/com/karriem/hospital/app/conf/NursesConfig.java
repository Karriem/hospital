/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.NursesServiceImpl;
import com.karriem.hospital.services.NursesService;
import com.karriem.hospital.services.crud.Impl.NursesCrudServiceImpl;
import com.karriem.hospital.services.crud.NursesCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class NursesConfig {
    
    @Bean (name = "nur")
    public NursesService getNurse(){
        
        return new NursesServiceImpl();
    }
    
    @Bean (name = "nurseCrud")
    public NursesCrudService getNurseCrud(){
        
        return new NursesCrudServiceImpl();
    }
}

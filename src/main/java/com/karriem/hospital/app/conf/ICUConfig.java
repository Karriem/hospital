/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.ICUService;
import com.karriem.hospital.services.Impl.ICUServcieImpl;
import com.karriem.hospital.services.crud.ICUCrudService;
import com.karriem.hospital.services.crud.Impl.ICUCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class ICUConfig {
    
    @Bean (name = "ICU")
    public ICUService getICU(){
        
        return new ICUServcieImpl();
    }
    
    @Bean (name = "ICUCrud")
    public ICUCrudService getICUCrud(){
        
        return new ICUCrudServiceImpl();
    }
}

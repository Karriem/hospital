/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.ComaService;
import com.karriem.hospital.services.Impl.ComaServiceImpl;
import com.karriem.hospital.services.crud.ComaCrudService;
import com.karriem.hospital.services.crud.Impl.ComaCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class ComaConfig {
    
    @Bean (name = "coma")
    public ComaService getComa(){
        
        return new ComaServiceImpl();
    }
    
    @Bean (name = "comaCrud")
    public ComaCrudService getComaCrud(){
        
        return new ComaCrudServiceImpl();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.GeneralSuppliersService;
import com.karriem.hospital.services.Impl.GeneralSuppliersServiceImpl;
import com.karriem.hospital.services.crud.GeneralSuppliersCrudService;
import com.karriem.hospital.services.crud.Impl.GeneralSuppliersCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class GeneralSuppliersConfig {
    
    @Bean (name = "gen")
    public GeneralSuppliersService getGenSup(){
        
        return new GeneralSuppliersServiceImpl();
    }
    
    public GeneralSuppliersCrudService getGenSuppliersCrud(){
        
        return new GeneralSuppliersCrudServiceImpl();
    }
}

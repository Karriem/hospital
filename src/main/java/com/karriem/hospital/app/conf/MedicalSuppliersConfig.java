/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MedicalSuppliersServiceImpl;
import com.karriem.hospital.services.MedicalSuppliersService;
import com.karriem.hospital.services.crud.Impl.MedicalSuppliersCrudServiceImpl;
import com.karriem.hospital.services.crud.MedicalSuppliersCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MedicalSuppliersConfig {
    
    @Bean (name = "med")
    public MedicalSuppliersService getMedSup(){
        
        return new MedicalSuppliersServiceImpl();
    }
    
    @Bean (name = "medicalSuppliersCrud")
    public MedicalSuppliersCrudService getMedicalSuppliersCrud(){
        
        return new MedicalSuppliersCrudServiceImpl();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MedicalAidServiceImpl;
import com.karriem.hospital.services.MedicalAidService;
import com.karriem.hospital.services.crud.Impl.MedicalAidCrudServiceImpl;
import com.karriem.hospital.services.crud.MedicalAidCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MedicalAidConfig {
    
    @Bean (name = "aid")
    public MedicalAidService getMedicalAid(){
        
        return new MedicalAidServiceImpl();
    }
    
    @Bean (name = "medicalAidCrud")
    public MedicalAidCrudService getMedicalAidCrud(){
        
        return new MedicalAidCrudServiceImpl();
    }
}

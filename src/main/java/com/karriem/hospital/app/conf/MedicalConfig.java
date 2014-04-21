/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MedicalServiceImpl;
import com.karriem.hospital.services.MedicalEquipmentService;
import com.karriem.hospital.services.crud.Impl.MedicalEquipmentCrudServiceImpl;
import com.karriem.hospital.services.crud.MedicalEquipmentCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MedicalConfig {
    
    @Bean (name = "med")
    public MedicalEquipmentService getMedical(){
        
        return new MedicalServiceImpl();
    }
    
    @Bean (name = "medicalEquipCrud")
    public MedicalEquipmentCrudService getMedicalCrud(){
        
        return new MedicalEquipmentCrudServiceImpl();
    }
}

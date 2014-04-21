/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.GeneralEquipmentService;
import com.karriem.hospital.services.Impl.GeneralServiceImpl;
import com.karriem.hospital.services.crud.GeneralEquipmentCrudService;
import com.karriem.hospital.services.crud.Impl.GeneralEquipmentCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class GeneralConfig {
    
    @Bean (name = "genEquip")
    public GeneralEquipmentService getGenEquip(){
        
        return new GeneralServiceImpl();
    }
    
    @Bean (name = "generalEquipCrud")
    public GeneralEquipmentCrudService getEquipCrud(){
        
        return new GeneralEquipmentCrudServiceImpl();
    }
}

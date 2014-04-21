/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.CreditCardService;
import com.karriem.hospital.services.Impl.CreditCardServiceImpl;
import com.karriem.hospital.services.crud.CreditCardCrudService;
import com.karriem.hospital.services.crud.Impl.CreditCardCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class CreditCardConfig {
    
    @Bean (name = "credit")
    public CreditCardService getCredit(){
        
        return new CreditCardServiceImpl();
    }
    
    @Bean (name = "creditCrud")
    public CreditCardCrudService getCreditCardCrud(){
        
        return new CreditCardCrudServiceImpl();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.MonthlyPaymentServiceImpl;
import com.karriem.hospital.services.MonthlyPaymentService;
import com.karriem.hospital.services.crud.Impl.MonthlyPaymentCrudServiceImpl;
import com.karriem.hospital.services.crud.MonthlyPaymentCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class MonthlyPaymentConfig {
    
    @Bean (name = "monthly")
    public MonthlyPaymentService getMonthly(){
        
        return new MonthlyPaymentServiceImpl();
    }
    
    @Bean (name = "monthlyCrud")
    public MonthlyPaymentCrudService getMonthlyCrud(){
        
        return new MonthlyPaymentCrudServiceImpl();
    }
}

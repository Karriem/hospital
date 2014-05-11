/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.repository.MedicalSuppliesRepository;
import com.karriem.hospital.services.MedicalSuppliersQuantityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Karriem
 */
public class MedicalSuppliersQuantityNGTest {
    
    private static ApplicationContext ctx;
    private MedicalSuppliesRepository repo;
    private MedicalSuppliersQuantityService service;
    
    public MedicalSuppliersQuantityNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getQuantity() {
     
         repo = ctx.getBean(MedicalSuppliesRepository.class);
         service = ctx.getBean(MedicalSuppliersQuantityService.class);
         
         MedicalSupplies med = new MedicalSupplies.Builder()
                                    .amt(45)
                                    .build();
         
         MedicalSupplies med2= new MedicalSupplies.Builder()
                                    .amt(35)
                                    .build();
         
         MedicalSupplies med3 = new MedicalSupplies.Builder()
                                    .amt(45)
                                    .build();
         repo.save(med);
         repo.save(med2);
         repo.save(med3);
         
         Assert.assertEquals(service.getQuantity(35).size(), 1);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        
        repo = ctx.getBean(MedicalSuppliesRepository.class);
        repo.deleteAll();
    }
}

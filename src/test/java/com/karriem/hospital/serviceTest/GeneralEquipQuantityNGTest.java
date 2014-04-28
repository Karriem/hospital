/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.GeneralEquipment;
import com.karriem.hospital.repository.GeneralEquipmentRepository;
import com.karriem.hospital.services.GeneralEquipQuantityService;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Karriem
 */
public class GeneralEquipQuantityNGTest {
    
    private static ApplicationContext ctx;
    private GeneralEquipmentRepository repo;
    private GeneralEquipQuantityService service;
    
    public GeneralEquipQuantityNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getGeneralEquipQuantity() {
     
         repo = ctx.getBean(GeneralEquipmentRepository.class);
         service = ctx.getBean(GeneralEquipQuantityService.class);
         
         GeneralEquipment genEquip = new GeneralEquipment.Builder()
                                            .quantity(4)
                                            .build();
         
         GeneralEquipment genEquip2 = new GeneralEquipment.Builder()
                                            .quantity(0)
                                            .build();
         
         GeneralEquipment genEquip3 = new GeneralEquipment.Builder()
                                            .quantity(25)
                                            .build();
         repo.save(genEquip);
         repo.save(genEquip2);
         repo.save(genEquip3);
         
         Assert.assertEquals(1, service.getQuantity(0).size());
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
        repo = ctx.getBean(GeneralEquipmentRepository.class);
        repo.deleteAll();
    }
}

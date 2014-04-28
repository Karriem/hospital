/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.repository.MedicineRepository;
import com.karriem.hospital.services.MedicineIDService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class MedicineIDtNGTest {
    
    private static ApplicationContext ctx;
    private MedicineRepository repo;
    private MedicineIDService service;
    
    public MedicineIDtNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void findId() {
     
         repo = ctx.getBean(MedicineRepository.class);
         service = ctx.getBean(MedicineIDService.class);
         
         Medicine med = new Medicine.Builder()
                            .medID("M1001")
                            .build();
         
         Medicine med2 = new Medicine.Builder()
                            .medID("M1002")
                            .build();
         
         Medicine med3 = new Medicine.Builder()
                            .medID("M1003")
                            .build();
         repo.save(med);
         repo.save(med2);
         repo.save(med3);
         
         Assert.assertEquals(service.findID("M1003").size(), 1);
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
        
        repo = ctx.getBean(MedicineRepository.class);
        repo.deleteAll();
    }
}

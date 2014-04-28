/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.MedicalEquipment;
import com.karriem.hospital.repository.MedicalEquipmentRepository;
import com.karriem.hospital.services.MedicalEquipQualityService;
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
public class MedicalEquipQualityNGTest {
    
    private static ApplicationContext ctx;
    private MedicalEquipmentRepository repo;
    private MedicalEquipQualityService service;
    
    public MedicalEquipQualityNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getQuality() {
     
         repo = ctx.getBean(MedicalEquipmentRepository.class);
         service = ctx.getBean(MedicalEquipQualityService.class);
         
         MedicalEquipment med = new MedicalEquipment.Builder()
                                    .condition("Used")
                                    .build();
         
         MedicalEquipment med2 = new MedicalEquipment.Builder()
                                    .condition("New")
                                    .build();
         
         MedicalEquipment med3 = new MedicalEquipment.Builder()
                                    .condition("Used")
                                    .build();
         
         repo.save(med);
         repo.save(med2);
         repo.save(med3);
         
         Assert.assertEquals(2, service.getMedicalEquipCost("Used").size());
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
        
        repo = ctx.getBean(MedicalEquipmentRepository.class);
        repo.deleteAll();
    }
}

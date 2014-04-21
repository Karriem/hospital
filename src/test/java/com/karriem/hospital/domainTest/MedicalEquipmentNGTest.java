/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.MedicalConfig;
import com.karriem.hospital.services.MedicalEquipmentService;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author karriem
 */
public class MedicalEquipmentNGTest {
    
    private static ApplicationContext ctx;
    private static MedicalEquipmentService service;
    
    public MedicalEquipmentNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMedical() {
         
         Assert.assertEquals(service.createMedicalEquipment().get(0).getQuality(), "Used");
     }
     
     @Test
     public void updateMedical() {
         
         Assert.assertEquals(service.createNewMedicalEquipment().get(0).getQuality(), "Used");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(MedicalConfig.class);
        service = (MedicalEquipmentService)ctx.getBean("med");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

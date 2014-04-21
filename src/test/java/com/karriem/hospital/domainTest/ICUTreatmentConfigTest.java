/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.ICUTreatmentConfig;
import com.karriem.hospital.services.ICUTreatmentService;
import org.junit.Assert;
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
public class ICUTreatmentConfigTest {
    
    private static ApplicationContext ctx;
    private static ICUTreatmentService service;
    
    public ICUTreatmentConfigTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createICU() {
     
       //  Assert.assertEquals(service.createICU().get(0).getCost(), 100);
     }
     
     @Test
     public void updateICU() {
     
      //   Assert.assertEquals(service.createNewICU().get(0).getCost(), 100);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ICUTreatmentConfig.class);
        service = (ICUTreatmentService)ctx.getBean("ICUTreat");
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

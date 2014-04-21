/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.ICUConfig;
import com.karriem.hospital.services.ICUService;
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
 * @author karriem
 */
public class ICUNGTest {
    
    private static ApplicationContext ctx;
    private static ICUService service;
    
    public ICUNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void createICU() {
     
         Assert.assertEquals(service.createICU().get(0).getFirstName(), "Jack");
     }
     
     @Test
     public void updateICU() {
     
         Assert.assertEquals(service.createNewICU().get(0).getFirstName(), "Jack");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ICUConfig.class);
        service = (ICUService)ctx.getBean("ICU");
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

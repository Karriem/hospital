/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.GeneralSuppliersConfig;
import com.karriem.hospital.services.GeneralSuppliersService;
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
public class GeneralSuppliersNGTest {
    
    private static ApplicationContext ctx;
    private static GeneralSuppliersService service;
    
    public GeneralSuppliersNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGenSup() {
         
         Assert.assertEquals(service.createGenSupplies().get(0).getDate(), "25 October 2014");
     }
     
     @Test
     public void updateGenSup() {
     
         Assert.assertEquals(service.createNewGenSupplies().get(0).getDate(), "25 October 2014");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(GeneralSuppliersConfig.class);
        service = (GeneralSuppliersService)ctx.getBean("gen");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.GeneralTreatmentConfig;
import com.karriem.hospital.services.GeneralTreatmentService;
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
public class GeneralTreatmentNGTest {
    
    private static ApplicationContext ctx;
    private static GeneralTreatmentService service;
    
    public GeneralTreatmentNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGeneral() {
     
        // Assert.assertEquals(service.createGeneral().get(0).getCost(), 22);
     }
     
     @Test
     public void updateGeneral() {
     
        // Assert.assertEquals(service.createNewGeneral().get(0).getCost(), 141);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(GeneralTreatmentConfig.class);
        service = (GeneralTreatmentService)ctx.getBean("genTreat");
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

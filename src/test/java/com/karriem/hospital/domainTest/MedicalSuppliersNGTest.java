/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.MedicalSuppliersConfig;
import com.karriem.hospital.services.MedicalSuppliersService;
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
public class MedicalSuppliersNGTest {
    
    private static ApplicationContext ctx;
    private static MedicalSuppliersService service;
    
    public MedicalSuppliersNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMedSup() {
     
         Assert.assertEquals(service.createMed().get(0).getDate(), "25 October 2014");
     }
     
     @Test
     public void updateMedSup() {
         
         Assert.assertEquals(service.createNewMed().get(0).getDate(), "25 October 2014");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(MedicalSuppliersConfig.class);
        service = (MedicalSuppliersService)ctx.getBean("med");
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

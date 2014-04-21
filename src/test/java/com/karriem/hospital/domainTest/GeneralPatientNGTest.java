/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.GeneralPatientConfig;
import com.karriem.hospital.services.GeneralPatientService;
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
public class GeneralPatientNGTest {
    
    private static ApplicationContext ctx;
    private static GeneralPatientService service;
    
    public GeneralPatientNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGenPat() {
     
         Assert.assertEquals(service.createGeneral().get(0).getDoctorID(), "D1001");
     }
     
      @Test
     public void updateGenPat() {
     
         Assert.assertEquals(service.createNewGeneral().get(0).getDoctorID(), "D1001");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(GeneralPatientConfig.class);
        service = (GeneralPatientService)ctx.getBean("genPat");
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

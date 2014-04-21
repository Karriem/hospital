/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.GeneralStaffConfig;
import com.karriem.hospital.services.GeneralStaffService;
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
public class GeneralStaffNGTest {
    
    private static ApplicationContext ctx;
    private static GeneralStaffService service;
    
    public GeneralStaffNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGeneral() {
         
         Assert.assertEquals(service.createGeneralStaff().get(0).getGenID(), "G1001");
     }
     
     @Test
     public void updateGeneral(){
         
         Assert.assertEquals(service.createNewGeneralStaff().get(0).getGenID(), "G1001");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(GeneralStaffConfig.class);
        service = (GeneralStaffService)ctx.getBean("gen");
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

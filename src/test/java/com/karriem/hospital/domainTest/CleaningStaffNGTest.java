/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.CleaningStaffConfig;
import com.karriem.hospital.services.CleaningStaffService;
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
public class CleaningStaffNGTest {
    
    private static ApplicationContext ctx;
    private static CleaningStaffService service;
    
    public CleaningStaffNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCleaner() {
         
         Assert.assertEquals(service.createCleaner().get(0).getAge(), 24);
     }
     
     @Test
     public void updateCleaner() {
         
        Assert.assertEquals(service.createNewCleaner().get(0).getAge(), 24);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(CleaningStaffConfig.class);
        service = (CleaningStaffService)ctx.getBean("cleaner");
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

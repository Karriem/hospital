/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.MonthlyPaymentConfig;
import com.karriem.hospital.services.MonthlyPaymentService;
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
public class MonthlyPaymentNGTest {
    
    private static ApplicationContext ctx;
    private static MonthlyPaymentService service;
    
    public MonthlyPaymentNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMonthly() {
     
         Assert.assertEquals(service.createMonthly().get(0).getPatientID(), "P1001");
     }
     
     @Test
     public void updateMonthly() {
     
         Assert.assertEquals(service.createNewMonthly().get(0).getPatientID(), "P1001");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(MonthlyPaymentConfig.class);
        service = (MonthlyPaymentService)ctx.getBean("monthly");
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

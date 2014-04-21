/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.CreditCardConfig;
import com.karriem.hospital.services.CreditCardService;
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
public class CreditCardNGTest {
    
    private static ApplicationContext ctx;
    private static CreditCardService service;
    
    public CreditCardNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCredit() {
     
         Assert.assertEquals(service.createCredit().get(0).getCreditCardType(), "Full");
     }
     
     @Test
     public void updateCredit(){
         
         Assert.assertEquals(service.createNewCredit().get(0).getCreditCardType(), "Full");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(CreditCardConfig.class);
        service = (CreditCardService)ctx.getBean("credit");
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

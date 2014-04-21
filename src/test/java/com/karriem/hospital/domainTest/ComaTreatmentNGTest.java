/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;




import com.karriem.hospital.app.conf.ComaTreatmentConfig;
import com.karriem.hospital.services.ComaTreatmentService;
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
public class ComaTreatmentNGTest {
    
    private static ApplicationContext ctx;
    private static ComaTreatmentService service;
    
    public ComaTreatmentNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createComa() {
         
         Assert.assertEquals(service.createComa().get(0).getTreatmetnID(), "T1001");
     }
     
     @Test
     public void updateComa() {
     
         Assert.assertEquals(service.createNewComa().get(0).getTreatmetnID(), "T1001");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ComaTreatmentConfig.class);
        service = (ComaTreatmentService)ctx.getBean("comaT");
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

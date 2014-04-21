/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.domainTest;


import com.karriem.hospital.app.conf.DoctorConfig;
import com.karriem.hospital.services.DoctorService;
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
public class DoctorNGTest {
    
    private static ApplicationContext ctx;
    private static DoctorService service;
    
    public DoctorNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() {
     
        Assert.assertEquals(service.createDoctor().get(0).getDocID(), "D1001");
        Assert.assertEquals(service.createDoctor().get(0).getFirstName(), "Karriem");
        Assert.assertEquals(service.createDoctor().get(0).getLastName(), "Petersen");
        Assert.assertEquals(service.createDoctor().get(0).getAge(), 25);
        Assert.assertEquals(service.createDoctor().get(0).getJobDescription(), "Heart Surgeon");
     }
     
     @Test
     public void update(){
         
        Assert.assertEquals(service.createNewDoctor().get(0).getDocID(), "D1001");
        Assert.assertEquals(service.createNewDoctor().get(0).getFirstName(), "Karriem");
        Assert.assertEquals(service.createNewDoctor().get(0).getLastName(), "Petersen");
        Assert.assertEquals(service.createNewDoctor().get(0).getAge(), 25);
        Assert.assertEquals(service.createNewDoctor().get(0).getJobDescription(), "Heart Surgeon");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(DoctorConfig.class);
        service = (DoctorService)ctx.getBean("createDoc");
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

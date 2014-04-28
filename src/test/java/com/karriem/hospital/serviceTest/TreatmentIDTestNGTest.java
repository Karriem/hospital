/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.Treatment;
import com.karriem.hospital.repository.TreatmentRepository;
import com.karriem.hospital.services.TreatmentIDService;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Karriem
 */
public class TreatmentIDTestNGTest {
    
    private static ApplicationContext ctx;
    private TreatmentRepository repo;
    private TreatmentIDService service;
    
    public TreatmentIDTestNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void searchID() {
     
         repo = ctx.getBean(TreatmentRepository.class);
         service = ctx.getBean(TreatmentIDService.class);
         
         Treatment treat = new Treatment.Builder()
                                .treatmentId("T1001")
                                .build();
         
         Treatment treat2 = new Treatment.Builder()
                                .treatmentId("T1002")
                                .build();
         
         Treatment treat3 = new Treatment.Builder()
                                .treatmentId("T1003")
                                .build();
         
         repo.save(treat);
         repo.save(treat2);
         repo.save(treat3);
         
         Assert.assertEquals(1, service.searchID("T1001").size());
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        
        repo = ctx.getBean(TreatmentRepository.class);
        repo.deleteAll();
    }
}

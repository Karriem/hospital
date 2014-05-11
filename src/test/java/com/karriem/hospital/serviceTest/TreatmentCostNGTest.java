/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.Treatment;
import com.karriem.hospital.repository.TreatmentRepository;
import com.karriem.hospital.services.TreatmentCostService;
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
 * @author Karriem
 */
public class TreatmentCostNGTest {
    
    private static ApplicationContext ctx;
    private TreatmentRepository repo;
    private TreatmentCostService service;
    
    public TreatmentCostNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getTreatmentCost() {
     
         service = ctx.getBean(TreatmentCostService.class);
         repo = ctx.getBean(TreatmentRepository.class);
         
         Treatment treat1 = new Treatment.Builder()
                                .cost(45000)
                                .description("Heals Aids")
                                .treatmentId("T1001")
                                .build();
         
         Treatment treat2 = new Treatment.Builder()
                                .cost(43000)
                                .description("Heals Aids")
                                .treatmentId("T1002")
                                .build();
         
         Treatment treat3 = new Treatment.Builder()
                                .cost(67000)
                                .description("Heals Aids")
                                .treatmentId("T1003")
                                .build();
         repo.save(treat1);
         repo.save(treat2);
         repo.save(treat3);
         
         Assert.assertEquals(67000, service.getTreatmentCost("T1003").get(0).getCost());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.GeneralSupplies;
import com.karriem.hospital.repository.GeneralSuppliesRepository;
import com.karriem.hospital.services.GeneralSuppliesNameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class GeneralSuppliesNameNGTest {
    
    private static ApplicationContext ctx;
    private GeneralSuppliesRepository repo; 
    private GeneralSuppliesNameService service;    
    
    public GeneralSuppliesNameNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getSuppliersName() {
         
         repo = ctx.getBean(GeneralSuppliesRepository.class);
         service = ctx.getBean(GeneralSuppliesNameService.class);
         
         GeneralSupplies sup = new GeneralSupplies.Builder()
                                    .suppliersName("CNA")
                                    .build();
         
         GeneralSupplies sup2 = new GeneralSupplies.Builder()
                                    .suppliersName("CNA")
                                    .build();
         
         GeneralSupplies sup3 = new GeneralSupplies.Builder()
                                    .suppliersName("CNA")
                                    .build();
         
         repo.save(sup);
         repo.save(sup2);
         repo.save(sup3);
         
         Assert.assertEquals(service.getSuppliersName("CNA").size(), 3);
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
        
        repo = ctx.getBean(GeneralSuppliesRepository.class);
        repo.deleteAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.GeneralEquipment;
import com.karriem.hospital.repository.GeneralEquipmentRepository;
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
public class GeneralEquipmentRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private GeneralEquipmentRepository repo;
    private final Long id = 1L;
    
    public GeneralEquipmentRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGeneralEquipment() {
         
         repo = ctx.getBean(GeneralEquipmentRepository.class);
         
         GeneralEquipment gen = new GeneralEquipment.Builder()
                                    .condition("New")
                                    .equipID("E1001")
                                    .equipName("Broom")
                                    .quantity(5)
                                    .build();
         
         repo.save(gen);
         Assert.assertNotNull(gen);
     }
     
     @Test(dependsOnMethods="createGeneralEquipment")
     public void readGeneralEquipment(){
         
         repo = ctx.getBean(GeneralEquipmentRepository.class);
         
         GeneralEquipment gen = repo.findOne(id);
         Assert.assertEquals("E1001", gen.getEquipID());
     }
     
     @Test(dependsOnMethods="readGeneralEquipment")
     public void updateGeneralEquipment(){
         
         repo = ctx.getBean(GeneralEquipmentRepository.class);
         
         GeneralEquipment gen = repo.findOne(id);
         
         GeneralEquipment updateGen = new GeneralEquipment.Builder().genEquipment(gen)
                                            .equipName("Tony Tony")
                                            .build();
         repo.save(updateGen);
         
         GeneralEquipment newGen = repo.findOne(id);
         Assert.assertEquals("Tony Tony", newGen.getEquipName());
     }
     
     @Test(dependsOnMethods="updateGeneralEquipment")
     public void deleteGeneralEquipment(){
         
        repo = ctx.getBean(GeneralEquipmentRepository.class);
        
        GeneralEquipment gen = repo.findOne(id);
        repo.delete(gen);
        
        GeneralEquipment deleteGen = repo.findOne(id);
        Assert.assertNull(deleteGen);
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
    }
}

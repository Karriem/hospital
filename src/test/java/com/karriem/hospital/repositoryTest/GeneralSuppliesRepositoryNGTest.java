/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.GeneralSupplies;
import com.karriem.hospital.repository.GeneralSuppliesRepository;
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
public class GeneralSuppliesRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private GeneralSuppliesRepository repo;
    private final Long id = 1L;
    
    public GeneralSuppliesRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createGeneralSupplies() {
     
         repo = ctx.getBean(GeneralSuppliesRepository.class);
         
         GeneralSupplies sup = new GeneralSupplies.Builder()
                                    .amt(25)
                                    .cost(4500)
                                    .dateOfOrder("25 April 2014")
                                    .description("Boxes of ponados")
                                    .equipmentID("E1001")
                                    .suppliersID("GSP1001")
                                    .suppliersName("Pharmercy")
                                    .build();
         
         repo.save(sup);
         Assert.assertNotNull(sup);
     }

     @Test(dependsOnMethods="createGeneralSupplies")
     public void readGeneralSupplies(){
         
         repo = ctx.getBean(GeneralSuppliesRepository.class);
         
         GeneralSupplies sup = repo.findOne(id);
         Assert.assertEquals("E1001", sup.getEquipmentID());
     }
     
     @Test(dependsOnMethods="readGeneralSupplies")
     public void updateGeneralSupplies(){
         
         repo = ctx.getBean(GeneralSuppliesRepository.class);
         
         GeneralSupplies sup = repo.findOne(id);
         
         GeneralSupplies updateSup = new GeneralSupplies.Builder().genSupplier(sup)
                                            .cost(7800)
                                            .build();         
         repo.save(updateSup);
         
         GeneralSupplies newSup = repo.findOne(id);
         
         Assert.assertEquals(7800, newSup.getCost());
     }
     
     @Test(dependsOnMethods="updateGeneralSupplies")
     public void deleteGeneralSupplies(){
         
         repo = ctx.getBean(GeneralSuppliesRepository.class);
         
         GeneralSupplies sup = repo.findOne(id);         
         repo.delete(id);
         
         GeneralSupplies deleteSup = repo.findOne(id);
         Assert.assertNull(deleteSup);
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

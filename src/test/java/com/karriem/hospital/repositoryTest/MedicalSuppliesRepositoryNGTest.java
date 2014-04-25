/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.repository.MedicalSuppliesRepository;
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
public class MedicalSuppliesRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private MedicalSuppliesRepository repo;
    private final Long id = 1L;
    
    public MedicalSuppliesRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMedicalSupplies() {
     
         repo = ctx.getBean(MedicalSuppliesRepository.class);
         
         MedicalSupplies sup = new MedicalSupplies.Builder()
                                    .amt(25)
                                    .cost(4500)
                                    .date("25 April 2014")
                                    .description("Boxes of ponados")
                                    .equipmentID("M1001")
                                    .suppliersID("GSP1001")
                                    .suppliersName("Pharmercy")
                                    .build();
         
         repo.save(sup);
         Assert.assertNotNull(sup);
     }

     @Test(dependsOnMethods="createMedicalSupplies")
     public void readMedicalSupplies(){
         
         repo = ctx.getBean(MedicalSuppliesRepository.class);
         
         MedicalSupplies sup = repo.findOne(id);
         Assert.assertEquals("M1001", sup.getEquipmentID());
     }
     
     @Test(dependsOnMethods="readMedicalSupplies")
     public void updateMedicalSupplies(){
         
         repo = ctx.getBean(MedicalSuppliesRepository.class);
         
         MedicalSupplies sup = repo.findOne(id);
         
         MedicalSupplies updateSup = new MedicalSupplies.Builder().medSupplier(sup)
                                            .cost(7800)
                                            .build();         
         repo.save(updateSup);
         
         MedicalSupplies newSup = repo.findOne(id);
         
         Assert.assertEquals(7800, newSup.getCost());
     }
     
     @Test(dependsOnMethods="updateMedicalSupplies")
     public void deleteMedicalSupplies(){
         
         repo = ctx.getBean(MedicalSuppliesRepository.class);
         
         MedicalSupplies sup = repo.findOne(id);         
         repo.delete(id);
         
         MedicalSupplies deleteSup = repo.findOne(id);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.repository.MedicineRepository;
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
public class MedicineRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private MedicineRepository repo;
    private final Long id = 1L;
    
    public MedicineRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() {
     
         repo = ctx.getBean(MedicineRepository.class);
         
         Medicine med = new Medicine.Builder()
                            .medDescription("Kills Cancer")
                            .medID("MD1001")
                            .quantity(45)
                            .build();
         
         repo.save(med);
         Assert.assertNotNull(med);
     }

     @Test(dependsOnMethods="create")
     public void read(){
         
         repo = ctx.getBean(MedicineRepository.class);
         
         Medicine med = repo.findOne(id);
         Assert.assertEquals("MD1001", med.getMedID());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         
         repo = ctx.getBean(MedicineRepository.class);
         
         Medicine med = repo.findOne(id);
         
         Medicine updateMed = new Medicine.Builder().medicine(med)
                                    .quantity(2)
                                    .build();
         repo.save(updateMed);
         
         Medicine newMed = repo.findOne(id);
         Assert.assertEquals(newMed.getQuantity(), 2);
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         
        repo = ctx.getBean(MedicineRepository.class);
         
         Medicine med = repo.findOne(id);
        repo.delete(id);
        
        Medicine deleteMed = repo.findOne(id);
        Assert.assertNull(deleteMed);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.MedicalEquipment;
import com.karriem.hospital.repository.MedicalEquipmentRepository;
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
public class MedicalEquipmentRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private MedicalEquipmentRepository repo;
    private final Long id = 1L;
    
    public MedicalEquipmentRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void create() {
     
         repo = ctx.getBean(MedicalEquipmentRepository.class);
         
         MedicalEquipment medE = new MedicalEquipment.Builder()
                                        .condition("New")
                                        .equipID("ME1001")
                                        .equipName("Scaple")
                                        .quantity(45)
                                        .build();
         
         repo.save(medE);
         Assert.assertNotNull(medE);
     }

     @Test(dependsOnMethods="create")
     public void read(){
         
        repo = ctx.getBean(MedicalEquipmentRepository.class);
         
        MedicalEquipment medE = repo.findOne(id);
        Assert.assertEquals("ME1001", medE.getEquipID());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         
        repo = ctx.getBean(MedicalEquipmentRepository.class);
         
        MedicalEquipment medE = repo.findOne(id);
        
        MedicalEquipment updateMed = new MedicalEquipment.Builder().medEquipment(medE)
                                        .condition("Used")
                                        .build();
        repo.save(updateMed);
        
        MedicalEquipment newMed = repo.findOne(id);
        Assert.assertEquals("Used", newMed.getQuality());
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         
         repo = ctx.getBean(MedicalEquipmentRepository.class);
         
        MedicalEquipment medE = repo.findOne(id);
        repo.delete(id);
        
        MedicalEquipment deleteMed = repo.findOne(id);
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

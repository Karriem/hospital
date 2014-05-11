/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.MedicalEquipment;
import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.domain.Treatment;
import com.karriem.hospital.repository.TreatmentRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
public class TreatmentRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private TreatmentRepository repo;
    private final Long id = 1L;
    
    public TreatmentRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
     public void create() {
     
         repo = ctx.getBean(TreatmentRepository.class);
         
         List<Medicine> medicine = new ArrayList<>();
         List<MedicalEquipment> medEquip = new ArrayList<>();
         
         Treatment med = new Treatment.Builder()
                            .cost(20000)
                            .description("Lung Surgeory")
                            .treatmentId("T1001")  
                            .medicalEquip(medEquip)
                            .medicine(medicine)
                            .build();
         
         repo.save(med);
         Assert.assertNotNull(med);
     }

     @Test(dependsOnMethods="create")
     public void read(){
         
         repo = ctx.getBean(TreatmentRepository.class);
         
         Treatment med = repo.findOne(id);
         Assert.assertEquals("T1001", med.getTreatmentId());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         
         repo = ctx.getBean(TreatmentRepository.class);
         
         Treatment med = repo.findOne(id);
         
         Treatment updateMed = new Treatment.Builder().treatment(med)
                                    .treatmentId("T1002")
                                    .build();
         repo.save(updateMed);
         
         Treatment newMed = repo.findOne(id);
         Assert.assertEquals(newMed.getTreatmentId(), "T1002");
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         
        repo = ctx.getBean(TreatmentRepository.class);
         
         Treatment med = repo.findOne(id);
        repo.delete(id);
        
        Treatment deleteMed = repo.findOne(id);
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

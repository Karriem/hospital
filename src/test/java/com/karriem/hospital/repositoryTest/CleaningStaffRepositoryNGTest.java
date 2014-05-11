/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.GeneralEquipment;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.repository.CleaningStaffRepository;
import java.util.ArrayList;
import java.util.List;
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
public class CleaningStaffRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private final Long id = 1L;
    private CleaningStaffRepository repo;
    
    public CleaningStaffRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCleaningStaff() {
     
         repo = ctx.getBean(CleaningStaffRepository.class);
         
         ContactDetails contact = new ContactDetails.Builder()
                                   .cellnumber("02475544554")
                                   .email("mikhail.sissing@gmail.com")
                                   .landLine("548945645")
                                   .postalAddress("23 Grassy Park 73489")
                                   .build();
         
         Names names = new Names.Builder()
                            .firstName("Mikhail")
                            .lastName("Sissing")
                            .build();
         
         Demographic demo = new Demographic.Builder()
                                .gender("Male")
                                .age(35)
                                .build();
         
         List<GeneralEquipment> eEquip = new ArrayList<>();
                  
         CleaningStaff clean = new CleaningStaff.Builder(id)
                                   .names(names)
                                   .demographic(demo)
                                   .cleanID("C1001")
                                   .jobDescription("Cleaner")
                                   .contact(contact)
                                   .salary(10000)
                                   .generalEquipment(eEquip)
                                   .build();
         repo.save(clean);
         Assert.assertNotNull(clean);
     }

     @Test(dependsOnMethods = "createCleaningStaff")
     public void readCleaningStaff(){
         
         repo = ctx.getBean(CleaningStaffRepository.class);
         
         CleaningStaff clean = repo.findOne(id);
         Assert.assertEquals(clean.getCleanID(), "C1001");
     }
     
     @Test(dependsOnMethods = "readCleaningStaff")
     public void updateCleaningStaff(){
         
         repo = ctx.getBean(CleaningStaffRepository.class);
         
         CleaningStaff clean = repo.findOne(id);
         
         CleaningStaff newClean = new CleaningStaff.Builder().cleaningStaff(clean)
                                        .cleanID("C1002")
                                        .build();
         repo.save(newClean);
         
         CleaningStaff updateClean = repo.findOne(id);
         Assert.assertEquals(updateClean.getCleanID(), "C1002");
     }
     
     @Test(dependsOnMethods = "updateCleaningStaff")
     public void deleteCleaningStaff(){
         
         repo = ctx.getBean(CleaningStaffRepository.class);
         
         CleaningStaff clean = repo.findOne(id);
         repo.delete(clean);
         
         CleaningStaff deleteClean = repo.findOne(id);
         Assert.assertNull(deleteClean);
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

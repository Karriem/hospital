/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.MaintenanceStaff;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.repository.MaintenanceStaffRepository;
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
public class MaintenenceStaffRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private MaintenanceStaffRepository repo;
    private final Long id = 1L;
    
    public MaintenenceStaffRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createMaintenenceStaff() {
    
        repo = ctx.getBean(MaintenanceStaffRepository.class);
        
        ContactDetails contact = new ContactDetails.Builder()
                                        .cellnumber("2545125")
                                        .email("jkhsdnjbn dg")
                                        .landLine("45454")
                                        .postalAddress("jbghkhjabdgaviaih")
                                        .build();
        
        Names name = new Names.Builder()
                            .firstName("Pete")
                            .lastName("Pete")
                            .build();
        
        Demographic demo = new Demographic.Builder()
                                .age(78)
                                .gender("Female")
                                .build();
        
        MaintenanceStaff main = new MaintenanceStaff.Builder()
                                    .contactDetails(contact)
                                    .demographic(demo)
                                    .jobDescription("Repairman")
                                    .mID("M1001")
                                    .names(name)
                                    .salary(4500)
                                    .build();
        
        repo.save(main);
        Assert.assertNotNull(main);
    }

     @Test(dependsOnMethods="createMaintenenceStaff")
     public void readMaintenenceStaff(){
         
         repo = ctx.getBean(MaintenanceStaffRepository.class);
         
         MaintenanceStaff main = repo.findOne(id);
         Assert.assertEquals(4500, main.getSalary());
     }
     
     @Test(dependsOnMethods="readMaintenenceStaff")
     public void updateMaintenenceStaff(){
         
         repo = ctx.getBean(MaintenanceStaffRepository.class);
         
         MaintenanceStaff main = repo.findOne(id);
         
         MaintenanceStaff updateMain = new MaintenanceStaff.Builder().maintenance(main)
                                            .jobDescription("Cleaner")
                                            .build();
         
         repo.save(updateMain);
         
         MaintenanceStaff newMain = repo.findOne(id);
         Assert.assertEquals("Cleaner", newMain.getJobDescription());
     }
     
     @Test(dependsOnMethods="updateMaintenenceStaff")
     public void deleteMaintenenceStaff(){
         
         repo = ctx.getBean(MaintenanceStaffRepository.class);
         
         MaintenanceStaff main = repo.findOne(id);
         
         repo.delete(id);
         
         MaintenanceStaff deleteMain = repo.findOne(id);
         Assert.assertNull(deleteMain);
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

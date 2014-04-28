/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.MaintenanceStaff;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.repository.MaintenanceStaffRepository;
import com.karriem.hospital.services.MaintenanceStaffNameService;
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
public class MaintenanceStaffNameNGTest {
    
    private static ApplicationContext ctx;
    private MaintenanceStaffRepository repo;
    private MaintenanceStaffNameService service;
    
    public MaintenanceStaffNameNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getMaintenanceStaffName() {
     
         repo = ctx.getBean(MaintenanceStaffRepository.class);
         service = ctx.getBean(MaintenanceStaffNameService.class);
         
         Names name = new Names.Builder()
                            .lastName("Lucifar")
                            .build();
         
         Names name2 = new Names.Builder()
                            .lastName("Petersen")
                            .build();
         
         Names name3 = new Names.Builder()
                            .lastName("Lucifar")
                            .build();
         
         ContactDetails contact = new ContactDetails.Builder()
                                        .email("Yes1")
                                        .build();
         
         ContactDetails contact2 = new ContactDetails.Builder()
                                        .email("Yes2")
                                        .build();
         
         ContactDetails contact3 = new ContactDetails.Builder()
                                        .email("Yes3")
                                        .build();
         
         Demographic demo = new Demographic.Builder()
                                        .age(25)      
                                        .gender("Male")
                                        .build();
         
         Demographic demo2 = new Demographic.Builder()
                                        .age(25)      
                                        .gender("Female")
                                        .build();
         
         Demographic demo3 = new Demographic.Builder()
                                        .age(25)      
                                        .gender("Male")
                                        .build();
         
         MaintenanceStaff staff = new MaintenanceStaff.Builder()
                                        .contactDetails(contact)
                                        .demographic(demo)
                                        .names(name)
                                        .build();
         
         MaintenanceStaff staff2 = new MaintenanceStaff.Builder()
                                        .contactDetails(contact2)
                                        .demographic(demo2)
                                        .names(name2)
                                        .build();
         
         MaintenanceStaff staff3 = new MaintenanceStaff.Builder()
                                        .contactDetails(contact3)
                                        .demographic(demo3)
                                        .names(name3)
                                        .build();
         repo.save(staff);
         repo.save(staff2);
         repo.save(staff3);
         
         Assert.assertEquals(service.getStaffName("Lucifar").size(), 2);
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
        
        repo = ctx.getBean(MaintenanceStaffRepository.class);
        repo.deleteAll();
    }
}

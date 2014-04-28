/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.repository.CleaningStaffRepository;
import com.karriem.hospital.services.CleaningStaffSalaryService;
import java.util.List;
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
public class CleaningStaffSalaryNGTest {
    
    private static ApplicationContext ctx;
    private CleaningStaffSalaryService service;
    private CleaningStaffRepository repo;
    
    public CleaningStaffSalaryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getSalaryBelow() {
     
         service = ctx.getBean(CleaningStaffSalaryService.class);
         repo = ctx.getBean(CleaningStaffRepository.class);
         
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
         
         CleaningStaff staff1 = new CleaningStaff.Builder()
                                    .contact(contact)
                                    .demographic(demo)
                                    .salary(8000)
                                    .build();
         
         CleaningStaff staff2 = new CleaningStaff.Builder()
                                    .contact(contact2)
                                    .demographic(demo2)
                                    .salary(3000)
                                    .build();
         
         CleaningStaff staff3 = new CleaningStaff.Builder()
                                    .contact(contact3)
                                    .demographic(demo3)
                                    .salary(2000)
                                    .build();
         
         repo.save(staff1);
         repo.save(staff2);
         repo.save(staff3);
         
         List<CleaningStaff> cleanStaff = service.getSalaryBelow(5000);
         
         Assert.assertEquals(2, cleanStaff.size());
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
        
        repo = ctx.getBean(CleaningStaffRepository.class);
        repo.deleteAll();
    }
}

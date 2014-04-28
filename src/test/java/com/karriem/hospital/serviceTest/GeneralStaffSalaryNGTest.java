/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.repository.GeneralStaffRepository;
import com.karriem.hospital.services.GeneralStaffSalaryService;
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
public class GeneralStaffSalaryNGTest {
    
    private static ApplicationContext ctx;
    private GeneralStaffRepository repo;
    private GeneralStaffSalaryService service;
    
    public GeneralStaffSalaryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getGeneralStaffSalary() {
     
         repo = ctx.getBean(GeneralStaffRepository.class);
         service = ctx.getBean(GeneralStaffSalaryService.class);
         
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
         
         GeneralStaff staff = new GeneralStaff.Builder()
                                    .contactDetails(contact)
                                    .demographic(demo)
                                    .salary(10000)
                                    .build();
         
         GeneralStaff staff2 = new GeneralStaff.Builder()
                                    .contactDetails(contact2)
                                    .demographic(demo2)
                                    .salary(5000)
                                    .build();
         
         GeneralStaff staff3 = new GeneralStaff.Builder()
                                    .contactDetails(contact3)
                                    .demographic(demo3)
                                    .salary(8000)
                                    .build();
         
         repo.save(staff);
         repo.save(staff2);
         repo.save(staff3);
         
         Assert.assertEquals(1, service.getGenStaffSalary(8000).size(), 0);
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
        
        repo = ctx.getBean(GeneralStaffRepository.class);
        repo.deleteAll();
    }
}

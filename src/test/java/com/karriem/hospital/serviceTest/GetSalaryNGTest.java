/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.repository.DoctorsRepository;
import com.karriem.hospital.services.GetSalaryService;
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
public class GetSalaryNGTest {
    
    private static ApplicationContext ctx;
    private DoctorsRepository repo;
    private GetSalaryService service;
    
    public GetSalaryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getSalary() {
     
         repo = ctx.getBean(DoctorsRepository.class);
         service = ctx.getBean(GetSalaryService.class);
         
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
         
         Doctors doc = new Doctors.Builder()
                            .contactDetails(contact)
                            .demographic(demo)
                            .docId("D1001")
                            .salary(20000)
                            .build();
         
         Doctors doc2 = new Doctors.Builder()
                            .contactDetails(contact2)
                            .demographic(demo2)
                            .docId("D1002")
                            .salary(35000)
                            .build();
         
         Doctors doc3 = new Doctors.Builder()
                            .contactDetails(contact3)
                            .demographic(demo3)
                            .docId("D1003")
                            .salary(25000)
                            .build();
         
         repo.save(doc);
         repo.save(doc2);
         repo.save(doc3);
         
         Assert.assertEquals(service.getIDSalary("D1003"), 25000.0, 0);
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
        
        repo = ctx.getBean(DoctorsRepository.class);
        repo.deleteAll();
    }
}

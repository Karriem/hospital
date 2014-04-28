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
import com.karriem.hospital.services.DoctorsJobService;
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
public class DoctorsJobNGTest {
    
    private static ApplicationContext ctx;
    private DoctorsRepository repo;
    private DoctorsJobService service;
    
    public DoctorsJobNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getDoctorsJob() {
     
         repo = ctx.getBean(DoctorsRepository.class);
         service = ctx.getBean(DoctorsJobService.class);
         
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
                            .jobDescription("Surgeon")
                            .build();
         
         Doctors doc2 = new Doctors.Builder()
                            .contactDetails(contact2)
                            .demographic(demo2)
                            .jobDescription("General")
                            .build();
         
         Doctors doc3 = new Doctors.Builder()
                            .contactDetails(contact3)
                            .demographic(demo3)
                            .jobDescription("Surgeon")
                            .build();
         
         repo.save(doc);
         repo.save(doc2);
         repo.save(doc3);
         
         Assert.assertEquals(2, service.getDoctorsJobDesciption("Surgeon").size());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.serviceTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.Patients;
import com.karriem.hospital.repository.PatientsRepository;
import com.karriem.hospital.services.TerminalPatientsService;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Karriem
 */
public class TerminalPatientsNGTest {
    
    private static ApplicationContext ctx;
    private PatientsRepository repo;
    private TerminalPatientsService service;
    
    public TerminalPatientsNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getType() {
     
         repo = ctx.getBean(PatientsRepository.class);
         service = ctx.getBean(TerminalPatientsService.class);
         
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
         
         Patients pat = new Patients.Builder()
                            .contactDetails(contact)
                            .demographic(demo)
                            .patientType("Terminal")
                            .build();
         
          Patients pat2 = new Patients.Builder()
                            .contactDetails(contact2)
                            .demographic(demo2)
                            .patientType("General")
                            .build();
          
           Patients pat3 = new Patients.Builder()
                            .contactDetails(contact3)
                            .demographic(demo3)
                            .patientType("Terminal")
                            .build();
           
           repo.save(pat);
           repo.save(pat2);
           repo.save(pat3);
           
           Assert.assertEquals(2, service.getPatientsType("Terminal").size());
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
        
        repo = ctx.getBean(PatientsRepository.class);
        repo.deleteAll();
    }
}

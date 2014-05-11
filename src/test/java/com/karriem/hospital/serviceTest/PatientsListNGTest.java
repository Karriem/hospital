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
import com.karriem.hospital.services.PatientsListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Karriem
 */
public class PatientsListNGTest {
    
    private static ApplicationContext ctx;
    private PatientsRepository repo;
    private PatientsListService service;
    
    public PatientsListNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getListOfPatietns() {
     
         repo = ctx.getBean(PatientsRepository.class);
         service = ctx.getBean(PatientsListService.class);
         
         ContactDetails contact = new ContactDetails.Builder()
                                        .cellnumber("454584545")
                                        .email("jhasdjfk@sdmkfh")
                                        .landLine("54545")
                                        .postalAddress("jkashkdjfnlho")
                                        .build();
         
         ContactDetails contact2 = new ContactDetails.Builder()
                                        .cellnumber("454584545")
                                        .email("2jhasdjfk@sdmkfh")
                                        .landLine("54545")
                                        .postalAddress("jkashkdjfnlho")
                                        .build();
         
         ContactDetails contact3 = new ContactDetails.Builder()
                                        .cellnumber("454584545")
                                        .email("3jhasdjfk@sdmkfh")
                                        .landLine("54545")
                                        .postalAddress("jkashkdjfnlho")
                                        .build();
         
         Demographic demo = new Demographic.Builder()
                                .age(45)
                                .gender("Female")
                                .build();
         
         Demographic demo2 = new Demographic.Builder()
                                .age(45)
                                .gender("Female")
                                .build();
         
         Demographic demo3 = new Demographic.Builder()
                                .age(45)
                                .gender("Female")
                                .build();
         
         Patients pat = new Patients.Builder()
                            .contactDetails(contact)
                            .demographic(demo)
                            .build();
         
         Patients pat2 = new Patients.Builder()
                            .contactDetails(contact2)
                            .demographic(demo2)
                            .build();
         
         Patients pat3 = new Patients.Builder()
                            .contactDetails(contact3)
                            .demographic(demo3)
                            .build();
         
         repo.save(pat);
         repo.save(pat2);
         repo.save(pat3);
         
         Assert.assertEquals(service.getListOfPatients().size(), 3);
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

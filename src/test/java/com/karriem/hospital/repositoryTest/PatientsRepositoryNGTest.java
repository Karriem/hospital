/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.CreditCard;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.MedicalAid;
import com.karriem.hospital.domain.MonthlyPayments;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.domain.Patients;
import com.karriem.hospital.repository.PatientsRepository;
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
public class PatientsRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private PatientsRepository repo;
    private final Long id = 1L;
    private List<Patients> listPat = new ArrayList();
    public PatientsRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void create() {
         
         repo = ctx.getBean(PatientsRepository.class);
         
         ContactDetails contact = new ContactDetails.Builder()
                                        .cellnumber("0810479280")
                                        .email("Uzamaki.Naruto@gmail.com")
                                        .landLine("0217018556")
                                        .postalAddress("Konoha")
                                        .build();
         
         Names name = new Names.Builder()
                            .firstName("Naruto")
                            .lastName("Uzamaki")
                            .build();
         
         Demographic demo = new Demographic.Builder()
                                .age(45)
                                .gender("Male")
                                .build(); 
         
         Patients pat = new Patients.Builder()
                            .contactDetails(contact)
                            .demographic(demo)
                            .illness("Cancer")
                            .names(name)
                            .patientID("P1001")
                            .patientType("Terminal Patient")
                            .roomNo("D5")
                            .treatmentID("T1001")
                            .paymentID("CD1001")
                            .build();
         
         repo.save(pat);
         Assert.assertNotNull(pat);
     }

     @Test(dependsOnMethods="create")
     public void read(){
         
         repo = ctx.getBean(PatientsRepository.class);
         
         Patients doc = repo.findOne(id);
         Assert.assertEquals("P1001", doc.getPatientID());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         
         repo = ctx.getBean(PatientsRepository.class);
         
         Patients doc = repo.findOne(id);
         
         Patients updateDoc = new Patients.Builder().patients(doc)
                                    .patientID("P1002")
                                    .build();
         repo.save(updateDoc);
         Patients newDoc = repo.findOne(id);
         Assert.assertEquals("P1002", newDoc.getPatientID());
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         
        repo = ctx.getBean(PatientsRepository.class);
        
        Patients doc = repo.findOne(id);
        repo.delete(doc);
        
        Patients deleteDoc = repo.findOne(id);
        Assert.assertNull(deleteDoc);
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

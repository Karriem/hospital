/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.domain.Patients;
import com.karriem.hospital.repository.DoctorsRepository;
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
public class DoctorsRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private DoctorsRepository repo;
    private final Long id = 1L;
    
    public DoctorsRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createDoctors() {
         
         repo = ctx.getBean(DoctorsRepository.class);
         
         ContactDetails contact = new ContactDetails.Builder()
                                        .cellnumber("0810479280")
                                        .email("petersen.karriem@gmail.com")
                                        .landLine("0217018556")
                                        .postalAddress("9 Emerald Crescent 7945")
                                        .build();
         
         Names name = new Names.Builder()
                            .firstName("Karriem")
                            .lastName("Petersen")
                            .build();
         
         Demographic demo = new Demographic.Builder()
                                .age(45)
                                .gender("Male")
                                .build();         
         
         List<Patients> patList = new ArrayList<>();
         
         Doctors doc = new Doctors.Builder(id)
                            .contactDetails(contact)
                            .demographic(demo)
                            .docId("D1001")
                            .jobDescription("Heart Surgeon")
                            .names(name) 
                            .patientList(patList)
                            .salary(22220)
                            .build();
         
         repo.save(doc);
         Assert.assertNotNull(doc);
     }

     @Test(dependsOnMethods="createDoctors")
     public void readDoctors(){
         
         repo = ctx.getBean(DoctorsRepository.class);
         
         Doctors doc = repo.findOne(id);
         Assert.assertEquals("D1001", doc.getDocID());
     }
     
     @Test(dependsOnMethods="readDoctors")
     public void updateDoctors(){
         
         repo = ctx.getBean(DoctorsRepository.class);
         
         Doctors doc = repo.findOne(id);
         
         Doctors updateDoc = new Doctors.Builder(id).doctor(doc)
                                    .docId("D1002")
                                    .build();
         repo.save(updateDoc);
         Doctors newDoc = repo.findOne(id);
         Assert.assertEquals("D1002", newDoc.getDocID());
     }
     
     @Test(dependsOnMethods="updateDoctors")
     public void deleteDoctors(){
         
        repo = ctx.getBean(DoctorsRepository.class);
        
        Doctors doc = repo.findOne(id);
        repo.delete(doc);
        
        Doctors deleteDoc = repo.findOne(id);
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
        
//        repo = ctx.getBean(DoctorsRepository.class);
//        repo.deleteAll();
    }
}

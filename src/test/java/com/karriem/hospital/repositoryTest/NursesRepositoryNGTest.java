/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.domain.Nurses;
import com.karriem.hospital.repository.NursesRepository;
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
public class NursesRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private NursesRepository repo;
    private final Long id = 1L;
    
    public NursesRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void create() {
         
         repo = ctx.getBean(NursesRepository.class);
         
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
         
         Nurses doc = new Nurses.Builder()
                            .contactDetails(contact)
                            .demographic(demo)
                            .nurID("N1001")
                            .jobDescription("General Nurse")
                            .names(name)
                            .build();
         
         repo.save(doc);
         Assert.assertNotNull(doc);
     }

     @Test(dependsOnMethods="create")
     public void read(){
         
         repo = ctx.getBean(NursesRepository.class);
         
         Nurses doc = repo.findOne(id);
         Assert.assertEquals("N1001", doc.getNurID());
     }
     
     @Test(dependsOnMethods="read")
     public void update(){
         
         repo = ctx.getBean(NursesRepository.class);
         
         Nurses doc = repo.findOne(id);
         
         Nurses updateDoc = new Nurses.Builder().nurse(doc)
                                    .nurID("N1002")
                                    .build();
         repo.save(updateDoc);
         Nurses newDoc = repo.findOne(id);
         Assert.assertEquals("N1002", newDoc.getNurID());
     }
     
     @Test(dependsOnMethods="update")
     public void delete(){
         
        repo = ctx.getBean(NursesRepository.class);
        
        Nurses doc = repo.findOne(id);
        repo.delete(doc);
        
        Nurses deleteDoc = repo.findOne(id);
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

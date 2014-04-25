/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repositoryTest;

import com.karriem.hospital.app.conf.ConnectionConfig;
import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.domain.ContactDetails;
import com.karriem.hospital.domain.Demographic;
import com.karriem.hospital.domain.Names;
import com.karriem.hospital.repository.GeneralStaffRepository;
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
public class GeneralStaffRepositoryNGTest {
    
    private static ApplicationContext ctx;
    private GeneralStaffRepository repo;
    private final Long id = 1L;
    
    public GeneralStaffRepositoryNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void createGeneralStaff(){
        
        repo = ctx.getBean(GeneralStaffRepository.class);
        
        ContactDetails conatact = new ContactDetails.Builder()
                                        .cellnumber("8376892")
                                        .email("Sasuke.Uchiha@gmail.com")
                                        .landLine("455454")
                                        .postalAddress("Konoha")
                                        .build();
        
        Names name = new Names.Builder()
                            .firstName("Sasuke")
                            .lastName("Uchiha")
                            .build();
        
        Demographic demo = new Demographic.Builder()
                                .age(25)
                                .gender("Male")
                                .build();
        
        GeneralStaff genS = new GeneralStaff.Builder()
                                .contactDetails(conatact)
                                .demographic(demo)
                                .genID("GS1001")
                                .jobDescription("Security")
                                .names(name)
                                .salary(8000)
                                .build();
        
        repo.save(genS);
        Assert.assertNotNull(genS);
    }
    
    @Test(dependsOnMethods="createGeneralStaff")
    public void readGeneralStaff(){
        
        repo = ctx.getBean(GeneralStaffRepository.class);
        
        GeneralStaff genS = repo.findOne(id);
        
        Assert.assertEquals(genS.getGenID(), "GS1001");
    }
    
    @Test(dependsOnMethods="readGeneralStaff")
    public void updateGeneralStaff(){
        
        repo = ctx.getBean(GeneralStaffRepository.class);
        
        GeneralStaff genS = repo.findOne(id);
        
        GeneralStaff newGen = new GeneralStaff.Builder().generalStaff(genS)
                                    .jobDescription("Secretary")
                                    .build();        
        repo.save(newGen);
        
        GeneralStaff updateGen = repo.findOne(id);
        Assert.assertEquals("Secretary", updateGen.getJobDescription());
    }
    
    @Test(dependsOnMethods="updateGeneralStaff")
    public void deleteGeneralStaff(){
        
        repo = ctx.getBean(GeneralStaffRepository.class);
        
        GeneralStaff genS = repo.findOne(id);
        
        repo.delete(id);
        
        GeneralStaff deleteGen = repo.findOne(id);
        Assert.assertNull(deleteGen);
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

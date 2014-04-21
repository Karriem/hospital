/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.MedicalAid;
import com.karriem.hospital.services.crud.MedicalAidCrudService;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author karriem
 */
public class MedicalAidCrudNGTest {
    
    @Mock
    private MedicalAidCrudService crudService;
    
    public MedicalAidCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
     public void testCreate() {
     
         MedicalAid cSP = new MedicalAid.Builder()
                              .amtCover(5000)
                              .lastName("Petersen")
                              .medicalAidName("LifeCover")
                              .medicalAidNo("15456164894")
                              .patientID("P1001")
                              .typeCover("Full")
                              .build();
         MedicalAid cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         MedicalAid cSP = new MedicalAid.Builder()
                              .medicalAidNo("15456164894")
                              .build();
         MedicalAid cSP2 = crudService.find(cSP.getMedicalAidNo());
         when(crudService.find(cSP.getMedicalAidNo())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getMedicalAidNo());
      
     }
     
     @Test
     public void testUpdate(){
         
         MedicalAid old = new MedicalAid.Builder()
                              .amtCover(5000)
                              .lastName("Petersen")
                              .medicalAidName("LifeCover")
                              .medicalAidNo("15456164894")
                              .patientID("P1001")
                              .typeCover("Full")
                              .build();
         
         MedicalAid update = new MedicalAid.Builder()
                                 .medicalAid(old)
                                 .amtCover(8000)
                                 .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);         
     }
     
     @Test
     public void testDelete(){
         
         MedicalAid cSP = new MedicalAid.Builder()
                                         .medicalAidNo("15456164894")
                                         .build();
         MedicalAid cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MedicalAidCrudService.class);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.Nurses;
import com.karriem.hospital.services.crud.NursesCrudService;
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
public class NursesCrudNGTest {
    
    @Mock
    private NursesCrudService crudService;
    
    public NursesCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
     public void testCreate() {
     
         Nurses cSP = new Nurses.Builder()
                                         .age(25)
                                         .nurID("N1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Nurse")
                                         .lastName("Sissing")
                                         .build();
         Nurses cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         Nurses cSP = new Nurses.Builder()
                                         .nurID("N1001")
                                         .build();
         Nurses cSP2 = crudService.find(cSP.getNurID());
         when(crudService.find(cSP.getNurID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getNurID());
      
     }
     
     @Test
     public void testUpdate(){
     
         Nurses old = new Nurses.Builder()
                                         .age(25)
                                         .nurID("N1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Nurse")
                                         .lastName("Sissing")
                                         .build();
         
         Nurses update = new Nurses.Builder()
                                  .nurse(old)
                                  .age(26)
                                  .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         Nurses gSP = new Nurses.Builder()
                                         .nurID("N1001")
                                         .build();
         Nurses gSP2 = crudService.remove(gSP);
         when(crudService.remove(gSP)).thenReturn(gSP2);
         Mockito.verify(crudService).remove(gSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(NursesCrudService.class);
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

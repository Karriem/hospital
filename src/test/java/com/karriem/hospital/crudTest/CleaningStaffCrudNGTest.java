/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.services.crud.CleaningStaffCrudService;

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
public class CleaningStaffCrudNGTest {
    
    @Mock
    private CleaningStaffCrudService crudService;
    
    public CleaningStaffCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreate() {
     
         CleaningStaff cSP = new CleaningStaff.Builder()
                                         .age(25)
                                         .cleanID("C1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Cleaner")
                                         .lastName("Sissing")
                                         .build();
         CleaningStaff cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         CleaningStaff cSP = new CleaningStaff.Builder()
                                         .cleanID("C1001")
                                         .build();
         CleaningStaff cSP2 = crudService.find(cSP.getCleanID());
         when(crudService.find(cSP.getCleanID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getCleanID());
      
     }
     
     @Test
     public void testUpdate(){
         
          CleaningStaff cSPOld = new CleaningStaff.Builder()
                                         .age(25)
                                         .cleanID("C1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Cleaner")
                                         .lastName("Sissing")
                                         .build();
   
         CleaningStaff cSP = new CleaningStaff.Builder()
                                         .cleaningStaff(cSPOld)
                                         .age(26)
                                         .build();
         
         cSPOld = crudService.merge(cSP);
         when(crudService.merge(cSP)).thenReturn(cSPOld);
         Mockito.verify(crudService).merge(cSP);   
         
     }
     
     @Test
     public void testDelete(){
         
         CleaningStaff cSP = new CleaningStaff.Builder()
                                         .cleanID("C1001")
                                         .build();
         CleaningStaff cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(CleaningStaffCrudService.class);
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

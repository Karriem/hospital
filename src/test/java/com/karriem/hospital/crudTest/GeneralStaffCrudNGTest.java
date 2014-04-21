/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.services.crud.GeneralStaffCrudService;
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
public class GeneralStaffCrudNGTest {
    
    @Mock
    private GeneralStaffCrudService crudService;
    
    public GeneralStaffCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         GeneralStaff cSP = new GeneralStaff.Builder()
                                         .age(25)
                                         .genID("G1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Secretary")
                                         .lastName("Sissing")
                                         .build();
         GeneralStaff cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         GeneralStaff cSP = new GeneralStaff.Builder()
                                         .genID("G1001")
                                         .build();
         GeneralStaff cSP2 = crudService.find(cSP.getGenID());
         when(crudService.find(cSP.getGenID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getGenID());
      
     }
     
     @Test
     public void testUpdate(){
         
         GeneralStaff cSP = new GeneralStaff.Builder()
                                         .age(25)
                                         .genID("G1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Secretary")
                                         .lastName("Sissing")
                                         .build();
         
         GeneralStaff cSP2 = new GeneralStaff.Builder()
                                         .generalStaff(cSP)
                                         .firstName("Karriem")
                                         .build();
         
         cSP = crudService.merge(cSP2);
         when(crudService.merge(cSP2)).thenReturn(cSP);
         Mockito.verify(crudService).merge(cSP2);  
     }
     
     @Test
     public void testDelete(){
         
         GeneralStaff gSP = new GeneralStaff.Builder()
                                         .genID("G1001")
                                         .build();
         GeneralStaff gSP2 = crudService.remove(gSP);
         when(crudService.remove(gSP)).thenReturn(gSP2);
         Mockito.verify(crudService).remove(gSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(GeneralStaffCrudService.class);
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

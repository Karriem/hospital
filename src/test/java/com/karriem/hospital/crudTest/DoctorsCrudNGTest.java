/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.services.crud.DoctorCrudService;
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
public class DoctorsCrudNGTest {
    
    @Mock
    private DoctorCrudService crudService;
    
    public DoctorsCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreate() {
     
         Doctors dP = new Doctors.Builder()
                                         .age(25)
                                         .docId("D1001")
                                         .firstName("Mikhail")
                                         .jobDescription("GP")
                                         .lastName("Sissing")
                                         .build();
         Doctors dP2 = crudService.persist(dP);
         when(crudService.persist(dP)).thenReturn(dP2);
         Mockito.verify(crudService).persist(dP);
     }
     
     @Test
     public void testRead(){
         
         Doctors dP = new Doctors.Builder()
                                         .docId("D1001")
                                         .build();
         Doctors dP2 = crudService.find(dP.getDocID());
         when(crudService.find(dP.getDocID())).thenReturn(dP2);
         Mockito.verify(crudService).find(dP.getDocID());
      
     }
     
     @Test
     public void testUpdate(){
   
         Doctors dPOld = new Doctors.Builder()
                                         .age(25)
                                         .docId("D1001")
                                         .firstName("Mikhail")
                                         .jobDescription("GP")
                                         .lastName("Sissing")
                                         .build();
         
         Doctors dp2 = new Doctors.Builder()
                                   .doctor(dPOld)
                                   .docId("D1101")
                                   .build();
         
         dPOld = crudService.merge(dp2);
         when(crudService.merge(dp2)).thenReturn(dPOld);
         Mockito.verify(crudService).merge(dp2);
     }
     
     @Test
     public void testDelete(){
         
         Doctors dP = new Doctors.Builder()
                                         .docId("C1001")
                                         .build();
         Doctors dP2 = crudService.remove(dP);
         when(crudService.remove(dP)).thenReturn(dP2);
         Mockito.verify(crudService).remove(dP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(DoctorCrudService.class);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.ComaTreatment;
import com.karriem.hospital.services.crud.ComaTreatmentCrudService;
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
public class ComaTreatmentCrudNGTest {
    
    @Mock
    private ComaTreatmentCrudService crudService;
    
    public ComaTreatmentCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
        ComaTreatment cSP = new ComaTreatment.Builder()
                                .cost(4500)
                                .treatmentDescription("Surgeory to left eye")
                                .treatmetnID("T1001")
                                .build();
                            
         ComaTreatment cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         ComaTreatment cSP = new ComaTreatment.Builder()
                              .treatmetnID("T1001")
                              .build();
         ComaTreatment cSP2 = crudService.find(cSP.getTreatmetnID());
         when(crudService.find(cSP.getTreatmetnID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getTreatmetnID());
      
     }
     
     @Test
     public void testUpdate(){
         
         ComaTreatment old = new ComaTreatment.Builder()
                                .cost(4500)
                                .treatmentDescription("Surgeory to left eye")
                                .treatmetnID("T1001")
                                .build();
         
         ComaTreatment update = new ComaTreatment.Builder()
                                    .comaTreatment(old)
                                    .cost(4555500)
                                    .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         ComaTreatment cSP = new ComaTreatment.Builder()
                            .treatmetnID("T1001")
                            .build();
         ComaTreatment cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(ComaTreatmentCrudService.class);
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

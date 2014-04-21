/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.ICUTreatment;
import com.karriem.hospital.services.crud.ICUTreatmentCrudService;
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
public class ICUTreatmentCrudNGTest {
    
    @Mock
    private ICUTreatmentCrudService crudService;
    
    public ICUTreatmentCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
        ICUTreatment cSP = new ICUTreatment.Builder()
                                    .cost(1000)
                                    .treatmentDescription("Recovering from heart surgeory")
                                    .treatmetnID("T1001")
                                    .build();
                            
         ICUTreatment cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         ICUTreatment cSP = new ICUTreatment.Builder()
                              .treatmetnID("T1001")
                              .build();
         ICUTreatment cSP2 = crudService.find(cSP.getTreatmentID());
         when(crudService.find(cSP.getTreatmentID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getTreatmentID());
      
     }
     
     @Test
     public void testUpdate(){
      
         ICUTreatment old = new ICUTreatment.Builder()
                                    .cost(1000)
                                    .treatmentDescription("Recovering from heart surgeory")
                                    .treatmetnID("T1001")
                                    .build();
         
         ICUTreatment update = new ICUTreatment.Builder()
                                   .icuTreatment(old)
                                   .treatmentDescription("Recovering from transplant")
                                   .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         ICUTreatment cSP = new ICUTreatment.Builder()
                            .treatmetnID("T1001")
                            .build();
         ICUTreatment cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(ICUTreatmentCrudService.class);
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

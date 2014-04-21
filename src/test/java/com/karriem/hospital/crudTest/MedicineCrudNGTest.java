/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.services.crud.MedicineCrudService;
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
public class MedicineCrudNGTest {
    
    @Mock
    private MedicineCrudService crudService;
    
    public MedicineCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
     public void testCreate() {
     
         Medicine cSP = new Medicine.Builder()
                            .medDescription("Heals HeadAches")
                            .medID("PA1001")
                            .quantity(50)
                            .build();
         Medicine cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         Medicine cSP = new Medicine.Builder()
                              .medID("PA1001")
                              .build();
         Medicine cSP2 = crudService.find(cSP.getMedID());
         when(crudService.find(cSP.getMedID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getMedID());
      
     }
     
     @Test
     public void testUpdate(){
         
         Medicine old = new Medicine.Builder()
                            .medDescription("Heals HeadAches")
                            .medID("PA1001")
                            .quantity(50)
                            .build();
         
         Medicine update = new Medicine.Builder()
                               .medicine(old)
                               .quantity(23)
                               .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         Medicine cSP = new Medicine.Builder()
                            .medID("PA1001")
                            .build();
         Medicine cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MedicineCrudService.class);
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

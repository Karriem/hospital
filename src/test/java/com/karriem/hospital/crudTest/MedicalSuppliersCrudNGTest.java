/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.services.crud.MedicalSuppliersCrudService;
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
public class MedicalSuppliersCrudNGTest {
    
    @Mock
    private MedicalSuppliersCrudService crudService;
    
    public MedicalSuppliersCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
        MedicalSupplies cSP = new MedicalSupplies.Builder()
                                   .amt(25)
                                   .cost(5000)
                                   .date("25 December")
                                   .description("Medical Supplies")
                                   .equipmentID("M1001")
                                   .suppliersID("S1001")
                                   .suppliersName("Yes")
                                   .build();
                            
         MedicalSupplies cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         MedicalSupplies cSP = new MedicalSupplies.Builder()
                              .suppliersID("S1001")
                              .build();
         MedicalSupplies cSP2 = crudService.find(cSP.getSuppliersID());
         when(crudService.find(cSP.getSuppliersID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getSuppliersID());
      
     }
     
     @Test
     public void testUpdate(){
         
         MedicalSupplies old = new MedicalSupplies.Builder()
                                   .amt(25)
                                   .cost(5000)
                                   .date("25 December")
                                   .description("Medical Supplies")
                                   .equipmentID("M1001")
                                   .suppliersID("S1001")
                                   .suppliersName("Yes")
                                   .build();
         
         MedicalSupplies update = new MedicalSupplies.Builder()
                                      .medSupplier(old)
                                      .cost(7800)
                                      .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         MedicalSupplies cSP = new MedicalSupplies.Builder()
                            .suppliersID("S1001")
                            .build();
         MedicalSupplies cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MedicalSuppliersCrudService.class);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.GeneralSupplies;
import com.karriem.hospital.services.crud.GeneralSuppliersCrudService;
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
public class GeneralSuppliersCrudNGTest {
    
    @Mock
    private GeneralSuppliersCrudService crudService;
    
    public GeneralSuppliersCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         GeneralSupplies cSP = new GeneralSupplies.Builder()
                                   .amt(25)
                                   .cost(5000)
                                   .date("25 December")
                                   .description("General Suppliers")
                                   .equipmentID("E1001")
                                   .suppliersID("S1001")
                                   .suppliersName("Yes")
                                   .build();
                            
         GeneralSupplies cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         GeneralSupplies cSP = new GeneralSupplies.Builder()
                              .suppliersID("S1001")
                              .build();
         GeneralSupplies cSP2 = crudService.find(cSP.getSuppliersID());
         when(crudService.find(cSP.getSuppliersID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getSuppliersID());
      
     }
     
     @Test
     public void testUpdate(){
         
         GeneralSupplies old = new GeneralSupplies.Builder()
                                   .amt(25)
                                   .cost(5000)
                                   .date("25 December")
                                   .description("General Suppliers")
                                   .equipmentID("E1001")
                                   .suppliersID("S1001")
                                   .suppliersName("Yes")
                                   .build();
         
         GeneralSupplies update = new GeneralSupplies.Builder()
                                      .genSupplier(old)
                                      .date("26 August")
                                      .build();
                 
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         GeneralSupplies cSP = new GeneralSupplies.Builder()
                            .suppliersID("S1001")
                            .build();
         GeneralSupplies cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(GeneralSuppliersCrudService.class);
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

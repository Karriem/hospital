/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.GeneralEquipment;
import com.karriem.hospital.services.crud.GeneralEquipmentCrudService;
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
public class GeneralEquipmentCrudNGTest {
    
    @Mock
    private GeneralEquipmentCrudService crudService;
    
    public GeneralEquipmentCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         GeneralEquipment cSP = new GeneralEquipment.Builder()
                                    .condition("New")
                                    .equipID("E1001")
                                    .equipName("Broom")
                                    .quantity(10)
                                    .build();
         GeneralEquipment cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         GeneralEquipment cSP = new GeneralEquipment.Builder()
                                         .equipID("E1001")
                                         .build();
         GeneralEquipment cSP2 = crudService.find(cSP.getEquipID());
         when(crudService.find(cSP.getEquipID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getEquipID());
      
     }
     
     @Test
     public void testUpdate(){
         
         GeneralEquipment old = new GeneralEquipment.Builder()
                                    .condition("New")
                                    .equipID("E1001")
                                    .equipName("Broom")
                                    .quantity(10)
                                    .build();
         
         GeneralEquipment update = new GeneralEquipment.Builder()
                                       .genEquipment(old)
                                       .equipName("Bucket")
                                       .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         GeneralEquipment cSP = new GeneralEquipment.Builder()
                                         .equipID("E1001")
                                         .build();
         GeneralEquipment cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(GeneralEquipmentCrudService.class);
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

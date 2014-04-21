/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.MedicalEquipment;
import com.karriem.hospital.services.crud.MedicalEquipmentCrudService;
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
public class MedicalEquipmentCrudNGTest {
    
    @Mock
    private MedicalEquipmentCrudService crudService;
    
    public MedicalEquipmentCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         MedicalEquipment cSP = new MedicalEquipment.Builder()
                                    .condition("New")
                                    .equipID("M1001")
                                    .equipName("Broom")
                                    .quantity(10)
                                    .build();
         MedicalEquipment cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         MedicalEquipment cSP = new MedicalEquipment.Builder()
                                         .equipID("M1001")
                                         .build();
         MedicalEquipment cSP2 = crudService.find(cSP.getEquipID());
         when(crudService.find(cSP.getEquipID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getEquipID());
      
     }
     
     @Test
     public void testUpdate(){
         
         MedicalEquipment old = new MedicalEquipment.Builder()
                                    .condition("New")
                                    .equipID("M1001")
                                    .equipName("Broom")
                                    .quantity(10)
                                    .build();
         
         MedicalEquipment update = new MedicalEquipment.Builder()
                                       .medEquipment(old)
                                       .condition("Used")
                                       .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         MedicalEquipment cSP = new MedicalEquipment.Builder()
                                         .equipID("M1001")
                                         .build();
         MedicalEquipment cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MedicalEquipmentCrudService.class);
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

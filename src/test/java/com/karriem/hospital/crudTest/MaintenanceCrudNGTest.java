/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.MaintenanceStaff;
import com.karriem.hospital.services.crud.MaintenanceCrudService;
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
public class MaintenanceCrudNGTest {
    
    @Mock
    private MaintenanceCrudService crudService;
    
    public MaintenanceCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreate() {
     
         MaintenanceStaff cSP = new MaintenanceStaff.Builder()
                                         .age(25)
                                         .mID("M1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Repairman")
                                         .lastName("Sissing")
                                         .build();
         MaintenanceStaff cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         MaintenanceStaff cSP = new MaintenanceStaff.Builder()
                                         .mID("M1001")
                                         .build();
         MaintenanceStaff cSP2 = crudService.find(cSP.getmID());
         when(crudService.find(cSP.getmID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getmID());
      
     }
     
     @Test
     public void testUpdate(){
     
         MaintenanceStaff old = new MaintenanceStaff.Builder()
                                         .age(25)
                                         .mID("M1001")
                                         .firstName("Mikhail")
                                         .jobDescription("Repairman")
                                         .lastName("Sissing")
                                         .build();
         
         MaintenanceStaff update = new MaintenanceStaff.Builder()
                                          .maintenance(old)
                                          .lastName("Uchiha")
                                          .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
                                       
     }
     
     @Test
     public void testDelete(){
         
         MaintenanceStaff gSP = new MaintenanceStaff.Builder()
                                         .mID("M1001")
                                         .build();
         MaintenanceStaff gSP2 = crudService.remove(gSP);
         when(crudService.remove(gSP)).thenReturn(gSP2);
         Mockito.verify(crudService).remove(gSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MaintenanceCrudService.class);
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

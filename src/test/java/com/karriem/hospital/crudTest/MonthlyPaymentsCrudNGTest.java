/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.MonthlyPayments;
import com.karriem.hospital.services.crud.MonthlyPaymentCrudService;
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
public class MonthlyPaymentsCrudNGTest {
    
    @Mock
    private MonthlyPaymentCrudService crudService;
    
    public MonthlyPaymentsCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         MonthlyPayments cSP = new MonthlyPayments.Builder()
                                   .monthlyInstallments(500)
                                   .months(5)
                                   .patientID("P1001")
                                   .paymentID("Pay1001")
                                   .treatmentCost(2500)
                                   .build();
                            
         MonthlyPayments cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         MonthlyPayments cSP = new MonthlyPayments.Builder()
                              .paymentID("Pay1001")
                              .build();
         MonthlyPayments cSP2 = crudService.find(cSP.getPaymentID());
         when(crudService.find(cSP.getPaymentID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getPaymentID());
      
     }
     
     @Test
     public void testUpdate(){
         
         MonthlyPayments old = new MonthlyPayments.Builder()
                                   .monthlyInstallments(500)
                                   .months(5)
                                   .patientID("P1001")
                                   .paymentID("Pay1001")
                                   .treatmentCost(2500)
                                   .build();
         
         MonthlyPayments update = new MonthlyPayments.Builder()
                                      .monthlyPayments(old)
                                      .months(8)
                                      .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         MonthlyPayments cSP = new MonthlyPayments.Builder()
                            .paymentID("Pay1001")
                            .build();
         MonthlyPayments cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(MonthlyPaymentCrudService.class);
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

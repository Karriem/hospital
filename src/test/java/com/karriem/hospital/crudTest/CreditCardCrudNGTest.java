/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.crudTest;


import com.karriem.hospital.domain.CreditCard;
import com.karriem.hospital.services.crud.CreditCardCrudService;
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
public class CreditCardCrudNGTest {
    
    @Mock
    private CreditCardCrudService crudService;
    
    public CreditCardCrudNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testCreate() {
     
         CreditCard cSP = new CreditCard.Builder()
                              .accountHolder("S.Smith")
                              .creditCardID("C101")
                              .creditCardNo("4845488asfas4")
                              .creditCardType("Mastercard")
                              .build();
                            
         CreditCard cSP2 = crudService.persist(cSP);
         when(crudService.persist(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).persist(cSP);
     }
     
     @Test
     public void testRead(){
         
         CreditCard cSP = new CreditCard.Builder()
                              .creditCardID("C101")
                              .build();
         CreditCard cSP2 = crudService.find(cSP.getCreditCardID());
         when(crudService.find(cSP.getCreditCardID())).thenReturn(cSP2);
         Mockito.verify(crudService).find(cSP.getCreditCardID());
      
     }
     
     @Test
     public void testUpdate(){
         
         CreditCard old = new CreditCard.Builder()
                              .accountHolder("S.Smith")
                              .creditCardID("C101")
                              .creditCardNo("4845488asfas4")
                              .creditCardType("Mastercard")
                              .build();
         
         CreditCard update = new CreditCard.Builder()
                                 .creditCard(old)
                                 .creditCardType("Pink")
                                 .build();
         
         old = crudService.merge(update);
         when(crudService.merge(update)).thenReturn(old);
         Mockito.verify(crudService).merge(update);
     }
     
     @Test
     public void testDelete(){
         
         CreditCard cSP = new CreditCard.Builder()
                            .creditCardID("C101")
                            .build();
         CreditCard cSP2 = crudService.remove(cSP);
         when(crudService.remove(cSP)).thenReturn(cSP2);
         Mockito.verify(crudService).remove(cSP);
     }

    @BeforeClass
    public void setUpClass() throws Exception {
        
        MockitoAnnotations.initMocks(this);
        crudService = Mockito.mock(CreditCardCrudService.class);
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

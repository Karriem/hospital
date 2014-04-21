/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.CreditCard;
import com.karriem.hospital.services.CreditCardService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class CreditCardServiceImpl implements CreditCardService{

    private List<CreditCard> creditList = new ArrayList<CreditCard>();
    
    @Override
    public List<CreditCard> createCredit() {
        
        CreditCard creditObj = new CreditCard.Builder()
                                    .accountHolder("S. Smith")
                                    .creditCardID("C1001")
                                    .creditCardNo("447741184415")
                                    .creditCardType("Full")
                                    .build();
        
        creditList.add(creditObj);
        
        return creditList;
    }

    @Override
    public List<CreditCard> createNewCredit() {
        
        CreditCard newCreditObj = new CreditCard.Builder()
                                        .creditCard(new CreditCardServiceImpl().createCredit().get(0))
                                        .creditCardType("General")
                                        .build();
        
        creditList.add(newCreditObj);
        
        return creditList;
    }
    
}

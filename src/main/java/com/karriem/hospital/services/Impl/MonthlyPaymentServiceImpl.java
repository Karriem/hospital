/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.MonthlyPayments;
import com.karriem.hospital.services.MonthlyPaymentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class MonthlyPaymentServiceImpl implements MonthlyPaymentService{

    private List<MonthlyPayments> monthlyList = new ArrayList<MonthlyPayments>();
    
    @Override
    public List<MonthlyPayments> createMonthly() {
        
        MonthlyPayments monthlyObj = new MonthlyPayments.Builder()
                                            .paymentID("PAy10001")
                                            .months(12)
                                            .monthlyInstallments(400)
                                            .treatmentCost(4800)
                                            .build();
                                            
        monthlyList.add(monthlyObj);
        
        return monthlyList;
    }

    @Override
    public List<MonthlyPayments> createNewMonthly() {
        
        MonthlyPayments newMonthlyObj = new MonthlyPayments.Builder()
                                            .monthlyPayments(new MonthlyPaymentServiceImpl().createMonthly().get(0))
                                            .treatmentCost(5800)
                                            .build();                                       
        
        monthlyList.add(newMonthlyObj);
        
        return monthlyList;
    }
    
}

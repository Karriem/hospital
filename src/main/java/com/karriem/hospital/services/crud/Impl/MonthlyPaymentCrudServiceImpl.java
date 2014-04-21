/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.MonthlyPayments;
import com.karriem.hospital.services.crud.MonthlyPaymentCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class MonthlyPaymentCrudServiceImpl implements MonthlyPaymentCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public MonthlyPayments find(String id) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public MonthlyPayments persist(MonthlyPayments entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public MonthlyPayments merge(MonthlyPayments entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MonthlyPayments remove(MonthlyPayments entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MonthlyPayments> findAll() {
         
        return null;
    }

   
}

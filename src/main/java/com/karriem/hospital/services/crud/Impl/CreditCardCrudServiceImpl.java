/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.CreditCard;
import com.karriem.hospital.services.crud.CreditCardCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class CreditCardCrudServiceImpl implements CreditCardCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CreditCard find(String id) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public CreditCard persist(CreditCard entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CreditCard merge(CreditCard entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CreditCard remove(CreditCard entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<CreditCard> findAll() {
         
        return null;
    }

        
}

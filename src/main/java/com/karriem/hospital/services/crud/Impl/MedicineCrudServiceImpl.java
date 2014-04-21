/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.services.crud.MedicineCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class MedicineCrudServiceImpl implements MedicineCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Medicine find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Medicine persist(Medicine entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Medicine merge(Medicine entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Medicine remove(Medicine entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Medicine> findAll() {
        
        return null;
    }

    
}

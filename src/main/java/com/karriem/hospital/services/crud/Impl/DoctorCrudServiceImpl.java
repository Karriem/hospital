/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.services.crud.DoctorCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class DoctorCrudServiceImpl implements DoctorCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Doctors find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Doctors persist(Doctors entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Doctors merge(Doctors entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Doctors remove(Doctors entity) {
       
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Doctors> findAll() {
        
        return null;
    }
    
}

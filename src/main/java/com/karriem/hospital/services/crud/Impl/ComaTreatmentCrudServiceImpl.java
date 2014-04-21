/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.ComaTreatment;
import com.karriem.hospital.services.crud.ComaTreatmentCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class ComaTreatmentCrudServiceImpl implements ComaTreatmentCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ComaTreatment find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public ComaTreatment persist(ComaTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ComaTreatment merge(ComaTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ComaTreatment remove(ComaTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ComaTreatment> findAll() {
        
        return null;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.GeneralTreatment;
import com.karriem.hospital.services.crud.GeneralTreatmentCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class GeneralTreatmentCrudServiceImpl implements GeneralTreatmentCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public GeneralTreatment find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public GeneralTreatment persist(GeneralTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public GeneralTreatment merge(GeneralTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GeneralTreatment remove(GeneralTreatment entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<GeneralTreatment> findAll() {
        
        return null;
    }

   
    
}

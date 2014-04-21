/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.MedicalAid;
import com.karriem.hospital.services.crud.MedicalAidCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class MedicalAidCrudServiceImpl implements MedicalAidCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public MedicalAid find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public MedicalAid persist(MedicalAid entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public MedicalAid merge(MedicalAid entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MedicalAid remove(MedicalAid entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MedicalAid> findAll() {
        
        return null;
    }

}

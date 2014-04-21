/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.services.crud.MedicalSuppliersCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class MedicalSuppliersCrudServiceImpl implements MedicalSuppliersCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public MedicalSupplies find(String id) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public MedicalSupplies persist(MedicalSupplies entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public MedicalSupplies merge(MedicalSupplies entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public MedicalSupplies remove(MedicalSupplies entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MedicalSupplies> findAll() {
        
        return null;
    }
}

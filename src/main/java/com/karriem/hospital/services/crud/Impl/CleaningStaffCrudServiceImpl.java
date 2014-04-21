/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.services.crud.CleaningStaffCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class CleaningStaffCrudServiceImpl implements CleaningStaffCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CleaningStaff find(String id) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public CleaningStaff persist(CleaningStaff entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CleaningStaff merge(CleaningStaff entity) {
        
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CleaningStaff remove(CleaningStaff entity) {
         
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<CleaningStaff> findAll() {
         
        return null;
    }    
}

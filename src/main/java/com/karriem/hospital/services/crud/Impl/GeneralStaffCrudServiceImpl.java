/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.services.crud.GeneralStaffCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class GeneralStaffCrudServiceImpl implements GeneralStaffCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public GeneralStaff find(String id) {
           
        return null;
    }
    
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public GeneralStaff persist(GeneralStaff entity) {
           
        return null;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public GeneralStaff merge(GeneralStaff entity) {
           
        return null;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GeneralStaff remove(GeneralStaff entity) {
          
        return null;
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<GeneralStaff> findAll() {
          
        return null;
    }

}

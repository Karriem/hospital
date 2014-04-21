/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.crud.Impl;


import com.karriem.hospital.domain.Nurses;
import com.karriem.hospital.services.crud.NursesCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karriem
 */
public class NursesCrudServiceImpl implements NursesCrudService{

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Nurses find(String id) {
              
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Nurses persist(Nurses entity) {
              
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Nurses merge(Nurses entity) {
              
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Nurses remove(Nurses entity) {
              
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Nurses> findAll() {
              
        return null;
    }


}

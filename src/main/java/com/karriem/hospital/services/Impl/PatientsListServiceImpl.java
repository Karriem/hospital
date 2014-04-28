/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Patients;
import com.karriem.hospital.repository.PatientsRepository;
import com.karriem.hospital.services.PatientsListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class PatientsListServiceImpl implements PatientsListService{

    @Autowired
    private PatientsRepository repo;
    
    @Override
    public List<Patients> getListOfPatients() {
        
        List<Patients> patList = new ArrayList<>();
        List<Patients> allPatients = repo.findAll();
        
        for (Patients pat : allPatients){
            
            patList.add(pat);
        }
        
        return patList;
    }
    
}

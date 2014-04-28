/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Patients;
import com.karriem.hospital.repository.PatientsRepository;
import com.karriem.hospital.services.TerminalPatientsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class TerminalPatientsServiceImpl implements TerminalPatientsService{

    @Autowired
    private PatientsRepository repo;
    
    @Override
    public List<Patients> getPatientsType(String type) {
        
        List<Patients> patList = new ArrayList<>();
        List<Patients> allPatList = repo.findAll();
        
        for(Patients pat : allPatList){
         
            if (pat.getPatientType().equalsIgnoreCase(type)){
                
                patList.add(pat);
            }
        }       
        
        return patList;
    }    
}

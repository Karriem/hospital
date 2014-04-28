/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Treatment;
import com.karriem.hospital.repository.TreatmentRepository;
import com.karriem.hospital.services.TreatmentIDService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class TreatmentIDServiceImpl implements TreatmentIDService{

    @Autowired
    private TreatmentRepository repo;
    
    @Override
    public List<Treatment> searchID(String id) {
        
        List<Treatment> treatList = new ArrayList<>();
        List<Treatment> allTreatList = repo.findAll();
        
        for(Treatment treat : allTreatList){
            
            if(treat.getTreatmentId().equalsIgnoreCase(id)){
                
                treatList.add(treat);
            }
        }
        
        return treatList;
    }
    
    
}

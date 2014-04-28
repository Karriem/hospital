/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Treatment;
import com.karriem.hospital.repository.TreatmentRepository;
import com.karriem.hospital.services.TreatmentCostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class TreatmentCostServiceImpl implements TreatmentCostService{

    @Autowired
    private TreatmentRepository repo;
    
    @Override
    public List<Treatment> getTreatmentCost(String id) {
        
       List<Treatment> treatList = new ArrayList<>();
       List<Treatment> allTreat = repo.findAll();
       
       for (Treatment treat: allTreat){
           
           if (treat.getTreatmentId().equals(id)){
               
               treatList.add(treat);
               System.out.println(treatList.get(0).getCost());
           }
       }
       
       return treatList;
    }      
}

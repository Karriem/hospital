/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.repository.MedicineRepository;
import com.karriem.hospital.services.MedicineDescriptionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class MedicineDescriptionServiceImpl implements MedicineDescriptionService{
    
    @Autowired
    private MedicineRepository repo;

    @Override
    public List<Medicine> getDescription(String val) {
        
        List<Medicine> medList = new ArrayList<>();
        List<Medicine> allMedList = repo.findAll();
        
        for(Medicine med : allMedList){
            
            if(med.getMedDescription().equalsIgnoreCase(val)){
                
                medList.add(med);
            }
        }
        
        return medList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.MedicalEquipment;
import com.karriem.hospital.repository.MedicalEquipmentRepository;
import com.karriem.hospital.services.MedicalEquipQualityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class MedicalEquipQualityServiceImpl implements MedicalEquipQualityService{

    @Autowired
    private MedicalEquipmentRepository repo;
    
    @Override
    public List<MedicalEquipment> getMedicalEquipCost(String q) {
        
        List<MedicalEquipment> medList = new ArrayList<>();
        List<MedicalEquipment> allMedList = repo.findAll();
        
        for(MedicalEquipment med : allMedList){
            
            if (med.getQuality().equalsIgnoreCase(q)){
                
                medList.add(med);
            }
        }
        
        return medList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.GeneralEquipment;
import com.karriem.hospital.repository.GeneralEquipmentRepository;
import com.karriem.hospital.services.GeneralEquipQuantityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class GeneralEquipQuantityServiceImpl implements GeneralEquipQuantityService{

    @Autowired
    private GeneralEquipmentRepository repo;
    
    @Override
    public List<GeneralEquipment> getQuantity(int val) {
        
        List<GeneralEquipment> genList = new ArrayList<>();
        List<GeneralEquipment> allGen = repo.findAll();
        
        for (GeneralEquipment gen : allGen){
            
            if (gen.getQuantity() <= val){
                
                genList.add(gen);
            }             
        }
        
        return genList;
    }
    
}

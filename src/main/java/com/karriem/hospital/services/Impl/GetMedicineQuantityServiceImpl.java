/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.repository.MedicineRepository;
import com.karriem.hospital.services.GetMedicineQuantityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class GetMedicineQuantityServiceImpl implements GetMedicineQuantityService{
    
    @Autowired
    private MedicineRepository repo;

    @Override
    public int getQuantity(String id) {
        
        int medList = 0;
        List<Medicine> allMedList = repo.findAll();
        
        for (Medicine me : allMedList){
            
            if(me.getMedID().equalsIgnoreCase(id)){
                
                medList = me.getQuantity();
            }
        }
        
        return medList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.repository.MedicalSuppliesRepository;
import com.karriem.hospital.services.MedicalSuppliersQuantityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class MedicalSuppliersQuantityServiceImpl implements MedicalSuppliersQuantityService{

    @Autowired
    private MedicalSuppliesRepository repo;
    
    @Override
    public List<MedicalSupplies> getQuantity(int val) {
        
        List<MedicalSupplies> medList = new ArrayList<>();
        List<MedicalSupplies> allMedList = repo.findAll();
        
        for(MedicalSupplies med : allMedList){
            
            if(med.getAmt() <= val){
                
                medList.add(med);
            }
        }
        
        return medList;
    }
    
}

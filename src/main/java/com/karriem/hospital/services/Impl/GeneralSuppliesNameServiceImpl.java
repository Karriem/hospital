/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.GeneralSupplies;
import com.karriem.hospital.repository.GeneralSuppliesRepository;
import com.karriem.hospital.services.GeneralSuppliesNameService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class GeneralSuppliesNameServiceImpl implements GeneralSuppliesNameService{

    @Autowired
    private GeneralSuppliesRepository repo;
    
    @Override
    public List<GeneralSupplies> getSuppliersName(String suppliers) {
        
        List<GeneralSupplies> genSupList = new ArrayList();
        List<GeneralSupplies> allGenSup = repo.findAll();
        
        for(GeneralSupplies sup : allGenSup){
            
            if (sup.getSuppliersName().equalsIgnoreCase(suppliers)){
                
                genSupList.add(sup);
            }
        }
        
        return genSupList;
    }
    
}

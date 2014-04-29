/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.repository.DoctorsRepository;
import com.karriem.hospital.services.GetSalaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class GetSalaryServiceImpl implements GetSalaryService{
    
    @Autowired
    private DoctorsRepository repo;

    @Override
    public double getIDSalary(String id) {
        
        List<Doctors> allDocList = repo.findAll();
        double salary = 0;
        
        for (Doctors doc : allDocList){
            
            if(doc.getDocID().equalsIgnoreCase(id)){
                
                salary = doc.getSalary();
            }
        }
        
        return salary;
    }
}

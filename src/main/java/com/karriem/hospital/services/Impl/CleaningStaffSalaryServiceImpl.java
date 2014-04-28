/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.repository.CleaningStaffRepository;
import com.karriem.hospital.services.CleaningStaffSalaryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class CleaningStaffSalaryServiceImpl implements CleaningStaffSalaryService{

    @Autowired
    private CleaningStaffRepository repo;
    
    @Override
    public List<CleaningStaff> getSalaryBelow(double salary) {
        
        List<CleaningStaff> clean = new ArrayList<>();
        List<CleaningStaff> allCleaningStaff = repo.findAll();
        
        for (CleaningStaff staff: allCleaningStaff){
            
            if (staff.getSalary() < salary){
                clean.add(staff);
            }
        }
        
        return clean;
    }    
}

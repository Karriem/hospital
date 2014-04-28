/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.repository.GeneralStaffRepository;
import com.karriem.hospital.services.GeneralStaffSalaryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class GeneralStaffSalaryServiceImpl implements GeneralStaffSalaryService{

    @Autowired
    private GeneralStaffRepository repo;
    
    @Override
    public List<GeneralStaff> getGenStaffSalary(double salary) {
        
        List<GeneralStaff> genStaffList = new ArrayList<>();
        List<GeneralStaff> allGenStaff = repo.findAll();
        
        for (GeneralStaff staff : allGenStaff){
            
            if (staff.getSalary() < salary){
                
                genStaffList.add(staff);
            }
        }
        
        return genStaffList;
    }
    
}

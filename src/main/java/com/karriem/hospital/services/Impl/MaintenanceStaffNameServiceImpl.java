/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.MaintenanceStaff;
import com.karriem.hospital.repository.MaintenanceStaffRepository;
import com.karriem.hospital.services.MaintenanceStaffNameService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class MaintenanceStaffNameServiceImpl implements MaintenanceStaffNameService{

    @Autowired
    private MaintenanceStaffRepository repo;
    
    @Override
    public List<MaintenanceStaff> getStaffName(String lastName) {
        
        List<MaintenanceStaff> mainStaffList = new ArrayList<>();
        List<MaintenanceStaff> allMainStaff = repo.findAll();
        
        for (MaintenanceStaff staff : allMainStaff){
            
            if(staff.getName().getLastName().equalsIgnoreCase(lastName)){
                
                mainStaffList.add(staff);
            }
        }
        
        return mainStaffList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.MaintenanceStaff;
import com.karriem.hospital.services.MaintenanceService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class MaintenanceServiceImpl implements MaintenanceService{

    private List<MaintenanceStaff> mainList = new ArrayList<MaintenanceStaff>();
    
    @Override
    public List<MaintenanceStaff> createMain() {
       
        MaintenanceStaff mainObj = new MaintenanceStaff.Builder()
                                            .mID("M1001")
                                            .firstName("Lucifer")
                                            .lastName("Chrollo")
                                            .age(24)
                                            .jobDescription("Repairman")
                                            .build();
                                            
        
        mainList.add(mainObj);
        
        return mainList;
    }

    @Override
    public List<MaintenanceStaff> createNewMain() {
        
         MaintenanceStaff newMain = new MaintenanceStaff.Builder()
                                            .maintenance(new MaintenanceServiceImpl().createMain().get(0))
                                            .age(25)
                                            .build();
        
        mainList.add(newMain);
        
        return mainList;
    }
    
}

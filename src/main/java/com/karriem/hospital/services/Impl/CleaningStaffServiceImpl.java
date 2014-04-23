/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.CleaningStaff;
import com.karriem.hospital.services.CleaningStaffService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class CleaningStaffServiceImpl implements CleaningStaffService{
    
    private List<CleaningStaff> cleanList = new ArrayList<CleaningStaff>();
    
    @Override
    public List<CleaningStaff> createCleaner() {
        
        CleaningStaff cleanObj = new CleaningStaff.Builder()
                                            .cleanID("C1001")
                                            .jobDescription("Cleaner")
                                            .build();
        
        cleanList.add(cleanObj);
        
        return cleanList;
    }

    @Override
    public List<CleaningStaff> createNewCleaner() {
        
        CleaningStaff newClean = new CleaningStaff.Builder()
                                            .cleaningStaff(new CleaningStaffServiceImpl().createCleaner().get(0))
                                            .jobDescription("Mechanic")
                                            .build();                                       
        
        cleanList.add(newClean);
        
        return cleanList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.GeneralStaff;
import com.karriem.hospital.services.GeneralStaffService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class GeneralStaffServiceImpl implements GeneralStaffService{

    private List<GeneralStaff> genList = new ArrayList<GeneralStaff>();
    
    @Override
    public List<GeneralStaff> createGeneralStaff(){
        
        GeneralStaff genObj = new GeneralStaff.Builder()
                                            .genID("G1001")
                                            .firstName("Ippo")
                                            .lastName("Makunichi")
                                            .age(20)
                                            .jobDescription("Secretary")
                                            .build();                                            
        
        genList.add(genObj);
        
        return genList;
    }

    @Override
    public List<GeneralStaff> createNewGeneralStaff() {
        
        GeneralStaff newGen = new GeneralStaff.Builder()
                                            .generalStaff(new GeneralStaffServiceImpl().createGeneralStaff().get(0))
                                            .genID("G1002")
                                            .build();
        
        genList.add(newGen);
        
        return genList;
    }
    
}

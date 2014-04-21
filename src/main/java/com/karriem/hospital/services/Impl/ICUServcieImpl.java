/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.ICUPatients;
import com.karriem.hospital.services.ICUService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class ICUServcieImpl implements ICUService{

    private List<ICUPatients> ICUList = new ArrayList<ICUPatients>();
    
    @Override
    public List<ICUPatients> createICU() {
        
        ICUPatients ICUObj = new ICUPatients.Builder()
                                    .patID("P1002")
                                    .doctorID("D1001")
                                    .firstName("Jack")
                                    .illness("Flu")
                                    .lastName("Torture")
                                    .age(24)
                                    .bedNumber("7")
                                    .build();
        
        ICUList.add(ICUObj);
        
        return ICUList;
    }

    @Override
    public List<ICUPatients> createNewICU() {
        
        ICUPatients newICU= new ICUPatients.Builder()
                                    .icuPatients(new ICUServcieImpl().createICU().get(0))
                                    .firstName("Garrus")
                                    .build();
        
        ICUList.add(newICU);
        
        return ICUList;
    }
    
}

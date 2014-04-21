/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.ComaPatients;
import com.karriem.hospital.services.ComaService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class ComaServiceImpl implements ComaService{
    
    private List<ComaPatients> comaList = new ArrayList<ComaPatients>();
    
    @Override
    public List<ComaPatients> createComa() {
        
        ComaPatients comaObj = new ComaPatients.Builder()
                                    .patID("P1001")
                                    .bedNumber("45")
                                    .doctorID("D1001")
                                    .durationOfComa("45 Days")
                                    .firstName("phloid")
                                    .illness("Heart Rupture")
                                    .lastName("Mayweather")
                                    .age(97)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

    @Override
    public List<ComaPatients> createNewComa() {
        
        ComaPatients newComa = new ComaPatients.Builder()
                                    .comaPatients(new ComaServiceImpl().createComa().get(0))
                                    .bedNumber("78")
                                    .build();
        
        comaList.add(newComa);
        
        return comaList;
    }
}

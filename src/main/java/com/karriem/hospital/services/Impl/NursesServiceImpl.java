/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.Nurses;
import com.karriem.hospital.services.NursesService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class NursesServiceImpl implements NursesService{

    private List<Nurses> nurList = new ArrayList<Nurses>();
    
    @Override
    public List<Nurses> createNurse() {
        
        Nurses nurObj = new Nurses.Builder()
                                            .nurID("N1001")
                                            .firstName("Shamoodah")
                                            .lastName("Petersen")
                                            .age(26)
                                            .jobDescription("Sister")
                                            .build();
                                            
        
        nurList.add(nurObj);
        
        return nurList;
    }

    @Override
    public List<Nurses> createNewNurse() {
        
        Nurses newNur = new Nurses.Builder()
                                    .nurse(new NursesServiceImpl().createNurse().get(0))
                                    .age(25)
                                    .build();
        
        nurList.add(newNur);
        
        return nurList;
    }
    
}

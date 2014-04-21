/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.ComaTreatment;
import com.karriem.hospital.services.ComaTreatmentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class ComaTreatmentServiceImpl implements ComaTreatmentService{

    List<ComaTreatment> comaList = new ArrayList<ComaTreatment>();

    @Override
    public List<ComaTreatment> createComa() {
        
        ComaTreatment comaObj = new ComaTreatment.Builder()
                                    .treatmentDescription("Remove Eye ball")
                                    .treatmetnID("T1001")
                                    .cost(5000)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

    @Override
    public List<ComaTreatment> createNewComa() {
        
        ComaTreatment comaObj = new ComaTreatment.Builder()
                                    .comaTreatment(new ComaTreatmentServiceImpl().createComa().get(0))
                                    .treatmetnID("D1005")
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

    
}

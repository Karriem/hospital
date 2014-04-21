/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.ICUTreatment;
import com.karriem.hospital.services.ICUTreatmentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class ICUTreatmentServiceImpl implements ICUTreatmentService{

    List<ICUTreatment> comaList = new ArrayList<ICUTreatment>();

    @Override
    public List<ICUTreatment> createICU() {
        
        ICUTreatment comaObj = new ICUTreatment.Builder()
                                    .treatmentDescription("Remove Eye ball")
                                    .treatmetnID("T1001")
                                    .cost(5000)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

    @Override
    public List<ICUTreatment> createNewICU() {
        
        ICUTreatment comaObj = new ICUTreatment.Builder()
                                    .icuTreatment(new ICUTreatmentServiceImpl().createICU().get(0))
                                    .cost(20)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }
    
}

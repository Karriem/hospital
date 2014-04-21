/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.GeneralTreatment;
import com.karriem.hospital.services.GeneralTreatmentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class GeneralTreatmentServiceImpl implements GeneralTreatmentService{
    
    List<GeneralTreatment> comaList = new ArrayList<GeneralTreatment>();

    @Override
    public List<GeneralTreatment> createGeneral() {
        
        GeneralTreatment comaObj = new GeneralTreatment.Builder()
                                    .treatmentDescription("Remove Eye ball")
                                    .treatmetnID("T1001")
                                    .cost(5000)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

    @Override
    public List<GeneralTreatment> createNewGeneral() {
        
        GeneralTreatment comaObj = new GeneralTreatment.Builder()
                                    .genTreatment(new GeneralTreatmentServiceImpl().createGeneral().get(0))
                                    .cost(2000)
                                    .build();
        
        comaList.add(comaObj);
        
        return comaList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.MedicalAid;
import com.karriem.hospital.services.MedicalAidService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class MedicalAidServiceImpl implements MedicalAidService{

    private List<MedicalAid> medList = new ArrayList<MedicalAid>();
    
    @Override
    public List<MedicalAid> createMedicalAid() {
        
        MedicalAid medObj = new MedicalAid.Builder()
                                .medicalAidNo("Aid011444")
                                .lastName("Shepard")
                                .medicalAidName("EverCare")
                                .patientID("P1001")
                                .amtCover(5000)
                                .typeCover("General")
                                .build();
                                            
        
        medList.add(medObj);
        
        return medList;
    }

    @Override
    public List<MedicalAid> createNewMedicalAid() {
        
        MedicalAid newMed = new MedicalAid.Builder()
                                .medicalAid(new MedicalAidServiceImpl().createMedicalAid().get(0))
                                .lastName("Sheperd")
                                .build();
        
        medList.add(newMed);
        
        return medList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.services.DoctorService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class DoctorServiceImpl implements DoctorService{

    private List<Doctors> docList = new ArrayList<Doctors>();
    
    @Override
    public List<Doctors> createDoctor() {
        
        Doctors docObj = new Doctors.Builder().docId("D1001")
                                        .firstName("Karriem")
                                        .lastName("Petersen")
                                        .age(25)
                                        .jobDescription("Heart Surgeon")
                                        .build();
        
        docList.add(docObj);
        
        return docList;
    }

    @Override
    public List<Doctors> createNewDoctor() {
        
        Doctors newDoc = new Doctors.Builder()
                                        .doctor(new DoctorServiceImpl().createDoctor().get(0))
                                        .firstName("Luke")
                                        .build();
        
        docList.add(newDoc);
        
        return docList;
    }
    
}

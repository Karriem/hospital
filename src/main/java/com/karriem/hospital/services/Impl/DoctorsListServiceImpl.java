/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Doctors;
import com.karriem.hospital.repository.DoctorsRepository;
import com.karriem.hospital.services.DoctorsListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class DoctorsListServiceImpl implements DoctorsListService{

    @Autowired
    private DoctorsRepository repo;
    
    @Override
    public List<Doctors> listDoctors() {
        
        List<Doctors> docList = new ArrayList<>();
        List<Doctors> allDocList = repo.findAll();
        
        for (Doctors doc : allDocList){
            
            docList.add(doc);
        }
        
        return docList;
    }    
}

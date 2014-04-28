/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;

import com.karriem.hospital.domain.Nurses;
import com.karriem.hospital.repository.NursesRepository;
import com.karriem.hospital.services.NursesListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karriem
 */
@Service
public class NursesListServiceImpl implements NursesListService{
    
    @Autowired
    private NursesRepository repo;

    @Override
    public List<Nurses> getNursesList() {
        
        List<Nurses> nurList = new ArrayList<>();
        List<Nurses> allNurList = repo.findAll();
        
        for (Nurses nur : allNurList){
            
            nurList.add(nur);
        }
        
        return nurList;
    }
}

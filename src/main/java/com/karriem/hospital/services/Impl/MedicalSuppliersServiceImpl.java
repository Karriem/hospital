/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.MedicalSupplies;
import com.karriem.hospital.services.MedicalSuppliersService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class MedicalSuppliersServiceImpl implements MedicalSuppliersService{
    
    List<MedicalSupplies> medList = new ArrayList<MedicalSupplies>();
    
    @Override
    public List<MedicalSupplies> createMed() {
       
        MedicalSupplies medObj = new MedicalSupplies.Builder()
                                        .amt(250)
                                        .date("25 October 2014")
                                        .description("Suppliers of general items")
                                        .equipmentID("E1001")
                                        .suppliersID("S1001")
                                        .suppliersName("SuperArt")
                                        .cost(10000)
                                        .build();
        
        medList.add(medObj);
        
        return medList;
    }

    @Override
    public List<MedicalSupplies> createNewMed() {
        
        MedicalSupplies newMedObj = new MedicalSupplies.Builder()
                                            .medSupplier(new MedicalSuppliersServiceImpl().createMed().get(0))
                                            .date("27 October 2014")
                                            .build();
        
        medList.add(newMedObj);
        
        return medList;
    }
}

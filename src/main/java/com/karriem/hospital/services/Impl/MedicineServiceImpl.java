/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.Medicine;
import com.karriem.hospital.services.MedicineService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class MedicineServiceImpl implements MedicineService{
    
    private List<Medicine> medList = new ArrayList<Medicine>();
    
    @Override
    public List<Medicine> createMedicine() {
        
        Medicine medObj = new Medicine.Builder()
                              .medID("783fgsdg")
                              .medDescription("Used To Heal Burns")
                              .quantity(5)
                              .build();
        
        medList.add(medObj);
        
        return medList;
    }

    @Override
    public List<Medicine> createNewMedicine() {
        
        Medicine newMed = new Medicine.Builder()
                              .medicine(new MedicineServiceImpl().createMedicine().get(0))
                              .quantity(8)
                              .build();
        
        medList.add(newMed);
        
        return medList;
    }
}

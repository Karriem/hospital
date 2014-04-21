/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.GeneralSupplies;
import com.karriem.hospital.services.GeneralSuppliersService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class GeneralSuppliersServiceImpl implements GeneralSuppliersService{

    List<GeneralSupplies> genSupList = new ArrayList<GeneralSupplies>();
    
    @Override
    public List<GeneralSupplies> createGenSupplies() {
       
        GeneralSupplies genSupObj = new GeneralSupplies.Builder()
                                        .amt(250)
                                        .date("25 October 2014")
                                        .description("Suppliers of general items")
                                        .equipmentID("E1001")
                                        .suppliersID("S1001")
                                        .suppliersName("SuperArt")
                                        .cost(10000)
                                        .build();
        
        genSupList.add(genSupObj);
        
        return genSupList;
    }

    @Override
    public List<GeneralSupplies> createNewGenSupplies() {
        
        GeneralSupplies newGenSupObj = new GeneralSupplies.Builder()
                                            .genSupplier(new GeneralSuppliersServiceImpl().createGenSupplies().get(0))
                                            .date("27 October 2014")
                                            .build();
        
        genSupList.add(newGenSupObj);
        
        return genSupList;
    }
    
}

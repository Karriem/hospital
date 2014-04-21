/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services;


import com.karriem.hospital.domain.MedicalSupplies;
import java.util.List;

/**
 *
 * @author karriem
 */
public interface MedicalSuppliersService {
    
    public List<MedicalSupplies> createMed(); 
    public List<MedicalSupplies> createNewMed();
}

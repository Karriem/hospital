/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.repository;

import com.karriem.hospital.domain.GeneralEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Karriem
 */
@Repository
public interface GeneralEquipmentRepository extends JpaRepository<GeneralEquipment, Long>{
    
}

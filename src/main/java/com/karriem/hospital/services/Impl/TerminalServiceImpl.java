/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.services.Impl;


import com.karriem.hospital.domain.TerminalPatients;
import com.karriem.hospital.services.TerminalService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karriem
 */
public class TerminalServiceImpl implements TerminalService{

    private List<TerminalPatients> terminalList = new ArrayList<TerminalPatients>();
    
    @Override
    public List<TerminalPatients> createICU() {
        
        TerminalPatients terObj = new TerminalPatients.Builder()
                                    .patID("P1002")
                                    .doctorID("D1001")
                                    .firstName("Jack")
                                    .illness("Flu")
                                    .lastName("Torture")
                                    .age(24)
                                    .bedNumber("7")
                                    .timeLeft("5 Days")
                                    .build();
        
        terminalList.add(terObj);
        
        return terminalList;
    }

    @Override
    public List<TerminalPatients> createNewICU() {
        
        TerminalPatients newTer= new TerminalPatients.Builder()
                                    .terminalPatients(new TerminalServiceImpl().createICU().get(0))
                                    .timeLeft("10 Days")
                                    .build();
        
        terminalList.add(newTer);
        
        return terminalList;
    }
    
}

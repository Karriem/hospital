/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karriem.hospital.app.conf;


import com.karriem.hospital.services.Impl.TerminalServiceImpl;
import com.karriem.hospital.services.TerminalService;
import com.karriem.hospital.services.crud.Impl.TerminalCrudServiceImpl;
import com.karriem.hospital.services.crud.TerminalCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karriem
 */
@Configuration
public class TerminalConfig {
    
    @Bean (name = "Terminal")
    public TerminalService getTerminal(){
        
        return new TerminalServiceImpl();
    }
    
    @Bean (name = "terminalCrud")
    public TerminalCrudService getTerminalCrud(){
        
        return new TerminalCrudServiceImpl();
    }
}

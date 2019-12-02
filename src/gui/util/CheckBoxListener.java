/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.util;

import app.AppManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kendrick-Laptop
 */
public class CheckBoxListener implements ActionListener{
    
    private final AppManager manager;
    
    public CheckBoxListener(AppManager manager){
        this.manager = manager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manager.updateValues();
    }
    
}

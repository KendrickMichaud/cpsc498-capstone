/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.util;

import app.AppManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Kendrick
 */
public class ComboItemListener implements ItemListener{
    
    private AppManager manager;
    
    public ComboItemListener(AppManager manager){
        this.manager = manager;
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        manager.dataChanged();
        manager.updateValues();
    }
    
}

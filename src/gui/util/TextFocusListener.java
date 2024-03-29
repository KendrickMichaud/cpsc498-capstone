/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.util;

import app.AppManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Kendrick
 */
public class TextFocusListener implements FocusListener{
    
    String key;
    Document document;
    AppManager manager;
    private String str_previous;
    
    public TextFocusListener(String key, Document document, AppManager manager){
        this.key = key;
        this.document = document;
        this.manager = manager;
    }

    @Override
    public void focusGained(FocusEvent e) {
        try {
            str_previous = document.getText(0, document.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(TextFocusListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        int length = document.getLength();
        if(length >= 0){
            try {
                //if the user data change is not allowed by the manager
                //manager will then notify JFrame to alert user to invalid data
                //change and then lastly
                //manager will revert document to default based on key.
                if(!manager.validateDataChange(key, document.getText(0, length))){
                    manager.restoreDefaultValue(key, document);
                }
                String str_current = document.getText(0, document.getLength());
                if(!str_current.equals(str_previous))
                    manager.dataChanged();
                //regardlesss of data being valid or invalid. A Data change
                //can result in a cascading effect. Therefore, related values
                //must be updated based on the key.
                manager.updateValues();
            } catch (BadLocationException ex) {
                Logger.getLogger(TextFocusListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

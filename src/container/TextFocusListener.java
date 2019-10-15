/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

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
    
    public TextFocusListener(String key, Document document, AppManager manager){
        this.key = key;
        this.document = document;
        this.manager = manager;
    }

    @Override
    public void focusGained(FocusEvent e) {
        //Do nothing because we have to wait for focus to end to ensure data;
    }

    @Override
    public void focusLost(FocusEvent e) {
        int length = document.getLength();
        if(length > 0){
            try {
                manager.updateData(key, document.getText(0, length));
            } catch (BadLocationException ex) {
                Logger.getLogger(TextFocusListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

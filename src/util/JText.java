/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constants.KEY;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Kendrick-Laptop
 */
public class JText {
    public static String extractString(Document component) {
        try {
            int length = component.getLength();
            return component.getText(0, length);
        } catch (BadLocationException ex) {
            Logger.getLogger(JText.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KEY.NULL;
    }
    
    public static String extractString(JTextComponent comp){
        if(comp != null){
            return extractString(comp.getDocument());
        }
        else{
            return "";
        }
    }

    public static void putString(String str, JTextComponent target) {
        if(str != null && target != null){
            target.setText(str);
        }
    }
}

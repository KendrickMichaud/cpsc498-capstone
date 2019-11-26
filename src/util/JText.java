/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constants.KEY;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
    
    public static void addTabFocusChanger(JTextArea area){
        //https://kodejava.org/how-do-i-move-focus-from-jtextarea-using-tab-key/
        area.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    if(e.getModifiers() > 0){
                        area.transferFocusBackward();
                    }
                else{
                        area.transferFocus();
                    }
                    e.consume();
                }
            }
        });
    }

    
    private static Bundle qHighlight;
    public static void highlightLabel(JLabel lbl) {
        if(qHighlight == null){
            qHighlight = new Bundle();
        }
        Font font = lbl.getFont();
        Font highlight = new Font(font.getFontName(), Font.PLAIN, font.getSize());
        qHighlight.putInteger(lbl.toString(), font.getSize());
        lbl.setFont(highlight);
    }
    
    public static void unHighlightLabel(JLabel lbl){
        if(qHighlight != null){
            Integer fontSize = qHighlight.getInteger(lbl.toString());
            if(fontSize <= 0)
                fontSize = 11;
            Font font = lbl.getFont();
            Font un = new Font(font.getFontName(), Font.PLAIN, fontSize);
            lbl.setFont(un);
        }
    }
    
    public static void wrapWord(JTextArea area){
        if(area != null)
            area.setWrapStyleWord(true);
    }
}

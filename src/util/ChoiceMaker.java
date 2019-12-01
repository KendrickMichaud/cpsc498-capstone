/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author Kendrick
 * 
 * Choice maker class is a utility class to assits with
 * automatically picking items for JComboBoxes, as well as,
 * other Swing Components.
 */
public class ChoiceMaker {
    
    public static void decideComboBox(JComboBox box){
        if(box == null)
            return;
        
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) box.getModel();
        if(model == null)
            return;
        
        int size = model.getSize();
        
        Random r = new Random(System.currentTimeMillis());
        //Range of choices [0...(size-1)]
        int index = r.nextInt(size); //bound is exclusive\
        
        box.setSelectedIndex(index);
    }
    
    public static void decideCheckBoxes(ArrayList<JCheckBox> boxes, int cap){
        if(cap < 0 || boxes == null)
            return;
        
        for(JCheckBox box : boxes){
            box.setSelected(false);
            box.setEnabled(false);
        }
        
        ArrayList<Integer> usedSlots = new ArrayList<>();
        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < cap; i++){
            int index = 0;
            do{
                index = r.nextInt(boxes.size());
                if(usedSlots.indexOf(index) == -1){
                    JCheckBox box = boxes.get(index);
                    box.setSelected(true);
                    box.setEnabled(true);
                    usedSlots.add(index);
                    break;
                }
            }while(usedSlots.indexOf(index) != -1);
        }
    }
}

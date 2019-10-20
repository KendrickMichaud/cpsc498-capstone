/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JLabel;

/**
 *
 * @author Kendrick
 */
public class Ability {
    public static String modifierToString(int modifier){
        if(modifier == 0){
            return "+0";
        }
        else if (modifier < 0){
            return Integer.toString(modifier);
        }
        else{
            return "+".concat(Integer.toString(modifier));
        }
    }

    public static int getModifier(int abilityScore) {
        int modifier = abilityScore-10;
        return Math.floorDiv(modifier, 2);
    }
}

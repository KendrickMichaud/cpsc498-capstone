/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.character_sheet;

import app.AppManager;
import gui.util.KEY;
import gui.util.Deck;
import gui.util.TextFocusListener;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Kendrick-Laptop
 */
class WeaponDeck extends Deck {
    
    public WeaponDeck(JPanel holder) {
        super(holder);
    }
    
    public void setTextListeners(){
        for(int curr=0; curr<3; curr++){
            WeaponCard panel = (WeaponCard) panels.get(curr);
            String k_name = KEY.K_WEAPON_NAME + KEY.item(curr);
            String k_attkBonus = KEY.K_WEAPON_ATTK_BONUS + KEY.item(curr);
            String k_dmgBonus = KEY.K_WEAPON_DMG_BONUS + KEY.item(curr);
            String k_desc = KEY.K_WEAPON_DESCRIPTION + KEY.item(curr);
            String k_dmgRoll = KEY.K_WEAPON_DMG_ROLL + KEY.item(curr);
            
            setTextListener(k_desc, panel.txt_weapon_damage_type);
            setTextListener(k_name, panel.txt_weapon_name);
            setTextListener(k_attkBonus, panel.txt_weapon_attk_bonus);
            setTextListener(k_dmgRoll, panel.txt_weapon_damage_roll);
            setTextListener(k_dmgBonus, panel.txt_weapon_damage_bonus);
        }
    }
    
    private void setTextListener(String key, JTextComponent comp){
       comp.addFocusListener(
       new TextFocusListener(key, comp.getDocument(), AppManager.getInstance()));
    }

    public void updateWeapons(int mod, int prof) {
        for(int i = 0; i < 3; i++){
            WeaponCard panel = (WeaponCard) panels.get(i);
            panel.updateValues(mod, prof);
        }
    }
}

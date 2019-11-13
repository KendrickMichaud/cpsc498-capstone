/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constants.KEY;
import java.util.HashMap;
import data_structure.Inventory;
import data_structure.Skills;
import data_structure.Spellbook;
import templates.BackgroundTemplates;
import templates.Templates;

/**
 *
 * @author Kendrick
 */
public class Bundle extends HashMap<String, Object>{
    public void putString(String key, String value){
        if(key != null && value != null)
            put(key, value);
    }
    
    public void putInteger(String key, int value){
        if(key != null)
            put(key, value);
    }
    
    public String getString(String key){
        Object potentialString = get(key);
        if(potentialString instanceof String)
            return (String) potentialString;
        else if(potentialString != null)
           throw new IllegalArgumentException("Calling for a type that is not a String"); 
        else{
            return "";
        }
    }
    
    public Integer getInteger(String key){
        Object potentialInteger = get(key);
        if(potentialInteger instanceof Integer)
            return (Integer) potentialInteger;
        else if (potentialInteger != null)
           throw new IllegalArgumentException("Calling for a type that is not a Integer");
        else
            return 0;
    }

    public void putBoolean(String key, Boolean value) {
        if(key != null){
            put(key, value);
        }
    }

    public boolean getBoolean(String key) {
        Object potentialBoolean = get(key);
        if(potentialBoolean instanceof Boolean)
            return (Boolean) potentialBoolean;
        else if(potentialBoolean != null)
           throw new IllegalArgumentException("Calling for a type that is not a Boolean"); 
        else
            return false;
    }

    public void putInventory(Inventory inventory) {
        put(KEY.K_INVENTORY, inventory);
    }
    
    public Inventory getInventory(){
        Object o = get(KEY.K_INVENTORY);
        if(o instanceof Inventory){
            return (Inventory) o;
        }
        else{
            return null;
        }
    }

    public void putSpellbook(Spellbook spellbook) {
        put(KEY.K_SPELLBOOK, spellbook);
    }
    
    public Spellbook getSpellbook(){
        Object o = get(KEY.K_SPELLBOOK);
        if(o instanceof Spellbook){
            return (Spellbook) o;
        }
        else{
            return null;
        }
    }

    public void putSkills(Skills skills) {
        put(KEY.K_SKILLS, skills);
    }
    
    public Skills getSkills(){
        Object o = get(KEY.K_SKILLS);
        if(o instanceof Skills){
            return (Skills) o;
        }
        else
            return null;
    }

    void putTemplate(templates.Templates.TYPE template, BackgroundTemplates templates) {
        if(templates != null){
            put(template.toString(), templates);
        }

    }

    public Templates getTemplate(Templates.TYPE type) {
        Object o = get(type.toString());
        if(o instanceof Templates){
            return (Templates) o;
        }
        return null;
    }
    
    
}

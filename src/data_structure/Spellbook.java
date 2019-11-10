/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.util.ArrayList;

/**
 *
 * @author Kendrick
 */
public class Spellbook {
    private ArrayList<ArrayList<Spell>> spells;
    private int casterType;
    public Spellbook(int casterType){
        spells = new ArrayList<>();
        this.casterType = casterType;
    }

    public Spellbook() {
    }
    
    public ArrayList<Spell> getCollection(int i){
        return spells.get(i);
    }
    
    public void addSpellsCollection(ArrayList<Spell> level){
        spells.add(level);
    }
    
    public int length(){
        return spells.size();
    }
    
    public int getCasterType(){
        return casterType;
    }
    
}

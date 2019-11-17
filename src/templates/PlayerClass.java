/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;

/**
 *
 * @author Kendrick-Laptop
 */
public class PlayerClass {
    String name;
    String casterType;
    ArrayList<Feature> features;
    ArrayList<String> skillProfs;
    ArrayList<String> savingThrows;
    public ArrayList<String> equipmentProfs;
    String hitDie;
    String hitDieAttribute;
    String flavorText;
    
    public PlayerClass(String name, String casterType, ArrayList<Feature> features, ArrayList<String> skillsProfs,
            ArrayList<String> savingThrows, ArrayList<String> equipmentProfs, String hitDie, String hitDieAttribute, String flavorText){
        
        this.name = name;
        this.casterType = casterType;
        this.features = features;
        this.skillProfs = skillsProfs;
        this.savingThrows = savingThrows;
        this.equipmentProfs = equipmentProfs;
        this.hitDie = hitDie;
        this.hitDieAttribute = hitDieAttribute;
        this.flavorText = flavorText;
    }
    
}
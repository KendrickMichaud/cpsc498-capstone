/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;
import util.Power;

/**
 *
 * @author Kendrick-Laptop
 */
public class PlayerClass {
    public final String name;
    public final String casterType;
    public final ArrayList<Feature> features;
    public final ArrayList<String> skillProfs;
    public final ArrayList<String> savingThrows;
    public final ArrayList<String> equipmentProfs;
    public final String hitDie;
    public final String hitDieAttribute;
    public final String flavorText;
    private Power power;
    
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

    public void setPowerLevel(Power power) {
        this.power = power;
    }

    public Power powerLevel() {
        return power;
    }
    
}

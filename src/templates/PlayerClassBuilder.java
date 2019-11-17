/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;


public class PlayerClassBuilder {

    private String name;
    private String casterType;
    private ArrayList<Feature> features;
    private ArrayList<String> skillsProfs;
    private ArrayList<String> savingThrows;
    private ArrayList<String> equipmentProfs;
    private String hitDie;
    private String hitDieAttribute;
    private String flavorText;

    public PlayerClassBuilder() {
    }

    public PlayerClassBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerClassBuilder setCasterType(String casterType) {
        this.casterType = casterType;
        return this;
    }

    public PlayerClassBuilder setFeatures(ArrayList<Feature> features) {
        this.features = features;
        return this;
    }

    public PlayerClassBuilder setSkillsProfs(ArrayList<String> skillsProfs) {
        this.skillsProfs = skillsProfs;
        return this;
    }

    public PlayerClassBuilder setSavingThrows(ArrayList<String> savingThrows) {
        this.savingThrows = savingThrows;
        return this;
    }

    public PlayerClassBuilder setEquipmentProfs(ArrayList<String> equipmentProfs) {
        this.equipmentProfs = equipmentProfs;
        return this;
    }

    public PlayerClassBuilder setHitDie(String hitDie) {
        this.hitDie = hitDie;
        return this;
    }

    public PlayerClassBuilder setHitDieAttribute(String hitDieAttribute) {
        this.hitDieAttribute = hitDieAttribute;
        return this;
    }

    public PlayerClassBuilder setFlavorText(String flavorText) {
        this.flavorText = flavorText;
        return this;
    }

    public PlayerClass createPlayerClass() {
        return new PlayerClass(name, casterType, features, skillsProfs, savingThrows, equipmentProfs, hitDie, hitDieAttribute, flavorText);
    }

    public boolean validClass() {
        if(isNull(name)){
            System.err.println("Name null");
            return false;
        }
        if(isNull(casterType)){
            System.err.println("caster null");
            return false;
        }
        if(isNull(features)){
            System.err.println("features null");
            return false;
        }
        if(isNull(savingThrows)){
            System.err.println("saves null");
            return false;
        }
        if(isNull(equipmentProfs)){
            System.err.println("equip null");
            return false;
        }
        if(isNull(hitDie)){
            System.err.println("hitDie null");
            return false;
        }
        if(isNull(hitDieAttribute)){
            System.err.println("hitDieAttribute null");
            return false;
        }
        if(isNull(flavorText)){
            System.err.println("flavor null");
            return false;
        }
        return true;
    }
    
    private boolean isNull(Object o){
        return (o == null);
    }
    
}

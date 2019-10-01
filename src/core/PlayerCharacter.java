package core;

import constants.KEY;

import java.util.List;

public class PlayerCharacter {
    PlayerClass type;
    PlayerRace race;
    List<Equipment> inventory;
    List<Spell> spellBook;
    Armor equippedArmor;
    Weapon equippedWeapon;
    Biography biographicalData;
    Background backgroundData;
    Integer[] attributes;
    public PlayerCharacter(){
        biographicalData = new Biography();
    }

    public void updateValue(String key, String value) {
        if(key.contains(KEY.bio)){
            biographicalData.update(key, value);
        }
    }

    public String get(String characterName) {
        return biographicalData.get(characterName);
    }
}

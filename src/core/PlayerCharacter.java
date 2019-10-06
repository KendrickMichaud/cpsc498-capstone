package core;

import constants.KEY;
import constants.TEXT;
import util.KeyReader;
import util.KeyValueReader;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter implements KeyValueReader<String, String> {
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
        type = new PlayerClass();
        race = new PlayerRace();
        inventory = new ArrayList<>();
        spellBook = new ArrayList<>();
        biographicalData = new Biography();
        equippedArmor = new Armor(TEXT.NONE, TEXT.NONE);
        equippedWeapon = new Weapon(TEXT.NONE, TEXT.NONE);
        backgroundData = new Background();
        attributes = new Integer[6];
    }

    //This class checks for super key to determine proper field to pull from
    @Override
    public String getValue(String key) {
        switch(KeyReader.getHighKey(key)){
            case KEY.BACKGROUND:break;
            case KEY.BIOGRAPHICAL_DATA:break;
            case KEY.PLAYER_CLASS:break;
            case KEY.PLAYER_RACE:break;
            case KEY.ATTRIBUTES:break;
            case KEY.INVENTORY:break;
            case KEY.SPELLBOOK:break;
            case KEY.EQUIPPED_WEAPON:break;
            case KEY.EQUIPPED_ARMOR:break;
            case KEY.NULL: throw new NullPointerException("Key is null");
            default: throw new IllegalArgumentException("Key:" + key + " is not a valid key");
        }
        return null;
    }

    //This class checks for super key to determine proper field to update
    @Override
    public void updateValue(String key, String value) {
        switch(KeyReader.getHighKey(key)){
            case KEY.BACKGROUND:backgroundData.updateValue(key,value);break;
            case KEY.BIOGRAPHICAL_DATA:biographicalData.updateValue(key,value);break;
            case KEY.PLAYER_CLASS:type.updateValue(key,value);break;
            case KEY.PLAYER_RACE:race.updateValue(key,value);break;
            case KEY.ATTRIBUTES:updateAttribute(key,value);break;
            case KEY.INVENTORY:updateInventoryItem(key,value);break;
            case KEY.SPELLBOOK:updateSpellbook(key,value);break;
            case KEY.EQUIPPED_WEAPON:equippedWeapon.updateValue(key,value);break;
            case KEY.EQUIPPED_ARMOR:equippedArmor.updateValue(key,value);break;
            case KEY.NULL:
                throw new NullPointerException("Key is null for a value: " + value);
        }
    }

    private void updateSpellbook(String key, String value) {
        int index = KeyReader.getRowIndex(key);
        Spell spell = spellBook.get(index);
        switch (KeyReader.getOptionalKey(key)){
            case KEY.SPELL_NAME:break;
            case KEY.SPELL_DESC:break;
            case KEY.SPELL_LEVEL:break;
        }
    }

    private void updateInventoryItem(String key, String value) {
        int index = KeyReader.getRowIndex(key);
        Equipment equipment = inventory.get(index);
        switch (KeyReader.getOptionalKey(key)){
            case KEY.ITEM_NAME:break;
            case KEY.ITEM_DESC:break;
            case KEY.EQUIPPED:break;
        }
    }

    private void updateAttribute(String key, String value) {
        switch (KeyReader.getLowKey(key)){
            case KEY.STRENGTH:break;
            case KEY.DEXTERITY:break;
            case KEY.CONSTITUTION:break;
            case KEY.INTELLIGENCE:break;
            case KEY.WISDOM:break;
            case KEY.CHARISMA:break;
        }
    }

    //Clears contents of all player manipulated data and resets all attributes to 10
    @Override
    public void clearContents() {
        type.clearContents();
        race.clearContents();
        inventory.clear();
        spellBook.clear();
        biographicalData.clearContents();
        equippedWeapon.clearContents();
        equippedArmor.clearContents();
        backgroundData.clearContents();
        resetAttributes();
    }

    //Helper method that resets player attributes to DND default (10)
    private void resetAttributes() {
        for(int i : attributes){
            i = 10;
        }
    }


    //In this case PlayerCharacter always has data, in the case of Attributes so return true
    @Override
    public boolean hasContents() {
        return true;
    }
}

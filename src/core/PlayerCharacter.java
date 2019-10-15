package core;

import app.AppManager;
import constants.KEY;
import constants.TEXT;
import util.KeyReader;
import util.KeyValueReader;

import java.util.ArrayList;
import java.util.List;
import util.DataIntegrity;

public class PlayerCharacter implements KeyValueReader<String, String> {
    List<Equipment> inventory;
    List<Spell> spellBook;
    Armor equippedArmor;
    Weapon equippedWeapon;
    Biography biographicalData;
    Background backgroundData;
    public Derived derived;
    int[] attributes;
    private AppManager manager;

    /**
     * When created initialize all values to default strings or integers
     * That way when user manipulates data, the program doesn't explode
     * because of a null pointer. Same applies to any custom class 
     * and not Java classes like ArrayList.
     */
    public PlayerCharacter() {
        inventory = new ArrayList<>();
        spellBook = new ArrayList<>();
        biographicalData = new Biography();
        equippedArmor = new Armor(TEXT.NONE, TEXT.NONE);
        equippedWeapon = new Weapon(TEXT.NONE, TEXT.NONE);
        backgroundData = new Background();
        attributes = new int[] {10, 10, 10, 10, 10, 10};
        derived = new Derived();
    }

    //This class checks for super key to determine proper field to pull from
    @Override
    public String getValue(String key) {
        switch(KeyReader.getHighKey(key)){
            case KEY.H_BACKGROUND:break;
            case KEY.H_BIOGRAPHICAL_DATA:break;
            case KEY.H_ATTRIBUTES:break;
            case KEY.H_INVENTORY:break;
            case KEY.H_SPELLBOOK:break;
            case KEY.H_WEAPON:break;
            case KEY.H_ARMOR:break;
            case KEY.NULL: throw new NullPointerException("Key is null");
            default: throw new IllegalArgumentException("Key:" + key + " is not a valid key");
        }
        return null;
    }

    //This class checks for super key to determine proper field to update
    @Override
    public void updateValue(String key, String value) {
        switch(KeyReader.getHighKey(key)){
            case KEY.H_BACKGROUND:backgroundData.updateValue(key,value);break;
            case KEY.H_BIOGRAPHICAL_DATA:biographicalData.updateValue(key,value);break;
            case KEY.H_ATTRIBUTES:updateAttribute(key,value);break;
            case KEY.H_INVENTORY:updateInventoryItem(key,value);break;
            case KEY.H_SPELLBOOK:updateSpellbook(key,value);break;
            case KEY.H_WEAPON:equippedWeapon.updateValue(key,value);break;
            case KEY.H_ARMOR:equippedArmor.updateValue(key,value);break;
            case KEY.NULL:
                throw new NullPointerException("Key is null for a value: " + value);
        }
        
        //Due to key being very important for gui this must be verified.
        if(key.equals(KEY.K_LEVEL)){
            manager.updateProficiencyBonusRelatedItems(attributes);
        }
    }

    private void updateSpellbook(String key, String value) {

    }

    private void updateInventoryItem(String key, String value) {

    }

    private void updateAttribute(String key, String value) {
        switch (KeyReader.getLowKey(key)){
            case KEY.L_STRENGTH:updateAttributeValue(0, value);manager.updateStrengthValues(derived.strengthModifier());break;
            case KEY.L_DEXTERITY:updateAttributeValue(1, value);manager.updateDexterityValues(derived.dexterityModifier());break;
            case KEY.L_CONSTITUION:updateAttributeValue(2, value);manager.updateConstituionValues(derived.constituionModifier());break;
            case KEY.L_INTELLIGENCE:updateAttributeValue(3, value);manager.updateIntelligenceValues(derived.intelligenceModifier());break;
            case KEY.L_WISDOM:updateAttributeValue(4, value);manager.updateWisdomValues(derived.wisdomModifier());break;
            case KEY.L_CHARISMA:updateAttributeValue(5, value);manager.updateCharismaValues(derived.charismaModifier());break;
        }
    }
    
    private void updateAttributeValue(int index, String value){
        try{
            if(index != -1){
            attributes[index] = Integer.parseInt(value);
            }  
        }
        catch (NumberFormatException e){//Do nothing don't update values
        }
    }

    //Clears contents of all player manipulated data and resets all attributes to 10
    @Override
    public void clearContents() {
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
        attributes = new int[] {10,10,10,10,10,10};
    }


    //In this case PlayerCharacter always has data, in the case of Attributes so return true
    @Override
    public boolean hasContents() {
        return true;
    }

    public void setManager(AppManager aThis) {
        manager = aThis;
    }
    
    public class Derived{
        public int strengthModifier(){
            return calculateModifier(attributes[0]);
        }
        public int dexterityModifier(){
            return calculateModifier(attributes[1]);
        }
        public int constituionModifier(){
            return calculateModifier(attributes[2]);
        }
        public int intelligenceModifier(){
            return calculateModifier(attributes[3]);
        }
        public int wisdomModifier(){
            return calculateModifier(attributes[4]);
        }
        public int charismaModifier(){
            return calculateModifier(attributes[5]);
        }
        
        public int proficiencyBonus(){
            return calculateProficiencybonus();
        }
        
        

        private int calculateModifier(int attribute) {
            double change = (double) (attribute-10);
            double result = change/2.0;
            result = (result >= 0)?Math.floor(result):Math.ceil(result);
            return (int) result;
        }

        private int calculateProficiencybonus() {
            String level = getValue(KEY.K_LEVEL);
            int num;
            if(level == null){
                num = 2;
            }
            else{
                num = Integer.parseInt(level);
            }
            
            if(num < 5)
                return 2;
            else if (num < 9)
                return 3;
            else if (num < 13)
                return 4;
            else if (num < 17)
                return 5;
            else 
                return 6;
        }
    }
}

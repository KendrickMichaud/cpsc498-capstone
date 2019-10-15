package app;


import constants.KEY;
import container.CharacterFrame;
import core.PlayerCharacter;
import java.io.File;
import util.KeyReader;

import javax.swing.*;

public class AppManager {
    
    
    private static AppManager manager;
    private CharacterFrame main_frame;
    private PlayerCharacter character;
    private boolean unsavedData;

    static AppManager getInstance() {
        if(manager == null){
            manager = new AppManager();
        }
        return manager;
    }

    private AppManager(){
        character = new PlayerCharacter();
    }

    public void updateData(String key, String value) {
        if(KeyReader.validKey(key) && value != null){
            System.out.println(key.concat(" ").concat(value));
            character.updateValue(key, value);
            unsavedData = true;
        }
 
    }

    void launchApplication() {
        if(main_frame != null && character != null){
            main_frame.setVisible(true);
        }
    }

    void initFrame() {
        main_frame = new CharacterFrame(this);
        character.setManager(this);
    }

    public boolean authorizedToExit() {
        if(unsavedData){
            int validation = JOptionPane.showConfirmDialog
                (main_frame, 
                "Are you sure? Unsaved data will be lost.", 
                "Unsaved Changes Detected", 
                0);
            return validation == JOptionPane.YES_OPTION;
        }
        else
            return true;
    }

    public void reinitializeEnvironment() {
        character.clearContents();
        main_frame.dispose();
        main_frame = new CharacterFrame(this);
        launchApplication();
    }
    
    public void reinitializeEnvironment(File openCharacterFile){
        
    }
    
    public File getFileToOpen(){
        JFileChooser chooser = new JFileChooser();
        chooser.setVisible(true);
        File file = chooser.getSelectedFile();
        if(file != null && file.canRead() && file.isFile()){
            return file;
        }
        
        throw new IllegalArgumentException("The file cannot be opened");
    }

    /**
     * Updates all GUI components that are tied to strengthModifier
     * JLabel strengthModifier
     * Skills related to Strength
     * Attack roll bonus
     * Attack damage bonus
     * 
     * @param strengthModifier 
     */
    public void updateStrengthValues(int strengthModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateStrengthLabel(strengthModifier);
        main_frame.updateStrengthSkills(strengthModifier, proficiency);
        main_frame.updateOffensiveAbilities(strengthModifier, proficiency);
    }

    /**
     * Updates all GUI components tied to dexterity attribute
     * Dexterity modifier
     * Skills related to dexterity
     * Dex AC bonus
     * Initiative Dex Bonus
     * 
     * @param dexterityModifier 
     */
    public void updateDexterityValues(int dexterityModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateDexterityLabel(dexterityModifier);
        main_frame.updateSkillsDexterity(dexterityModifier, proficiency);
        main_frame.updateDexACBonus(dexterityModifier);
        main_frame.updateDexInitBonus(dexterityModifier);
        main_frame.updateDexSaveBonus(dexterityModifier, proficiency);
    }
    
    /**
     * Updates all GUI components tied to constitution attribute
     * Constitution modifier
     * Skills related to constitution
     * @param constitutionModifier 
     */
    public void updateConstituionValues(int constitutionModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateConstitutionLabel(constitutionModifier);
        main_frame.updateSkillsConstitution(constitutionModifier, proficiency);
    }

    /**
     * Updates all GUI components tied to intelligence attribute
     * Intelligence modifier
     * Skills related to intelligence
     * @param intelligenceModifier 
     */
    public void updateIntelligenceValues(int intelligenceModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateIntelligenceLabel(intelligenceModifier);
        main_frame.updateSkillsIntelligence(intelligenceModifier, proficiency);
    }

    /**
     * Updates all GUI components tied to wisdom attribute
     * Wisdom modifier
     * Skills related to wisdom
     * Wisdom save
     * 
     * @param wisdomModifier 
     */
    public void updateWisdomValues(int wisdomModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateWisdomLabel(wisdomModifier);
        main_frame.updateWisdomSkills(wisdomModifier, proficiency);
        main_frame.updateWisdomSave(wisdomModifier, proficiency);
    }

    /**
     * Updates all GUI components tied to charisma attribute
     * Charisma modifier
     * Skills related to Charisma
     * Charisma save
     * 
     * @param charismaModifier 
     */
    public void updateCharismaValues(int charismaModifier) {
        int proficiency = character.derived.proficiencyBonus();
        main_frame.updateCharismaLabel(charismaModifier);
        main_frame.updateCharismaSkills(charismaModifier, proficiency);
        main_frame.updateCharismaSave(charismaModifier, proficiency);
    }

    /**
     * If the level of the player has changed, then it will be necessary
     * to update all related components (which are a lot). Therefore, pass
     * attributes and let this method call necessary updates as a whole.
     * @param attributes 
     */
    public void updateProficiencyBonusRelatedItems(int[] attributes) {
        updateStrengthValues(attributes[0]);
        updateDexterityValues(attributes[1]);
        updateConstituionValues(attributes[2]);
        updateIntelligenceValues(attributes[3]);
        updateWisdomValues(attributes[4]);
        updateCharismaValues(attributes[5]);
    }

    

}

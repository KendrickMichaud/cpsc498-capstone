package app;


import constants.CARD;
import constants.KEY;
import container.CharacterFrame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.KeyReader;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import templates.BackgroundTemplates;
import templates.BackgroundTemplates.Background;
import templates.BackgroundTemplates.Background.STORY;
import util.Bundle;
import util.DataIntegrity;

public class AppManager {
    
    
    private static AppManager manager;
    private CharacterFrame main_frame;
    private boolean unsavedData;

    public static AppManager getInstance() {
        if(manager == null){
            manager = new AppManager();
        }
        return manager;
    }

    private AppManager(){}

    public boolean validateDataChange(String key, String value) {
        if(key != null && value != null){
            //Few to keys to verify validity
            //Anything involving numbers is pretty much the domain of keys
            
            //First we check if the value is a number
            boolean isANumber = DataIntegrity.isNumeric(value);
            if(KeyReader.getHighKey(key).equals(KEY.H_ATTRIBUTES)){
                //We want to check if this is a valid attribute number
                //and not some ridiculous -1000 or 1000
                return isANumber && DataIntegrity.validAttribute(value);
            }
            else if(KeyReader.getHighKey(key).equals(KEY.H_SKILLS)){
                //In this case it should be possible to allow for
                //Homebrewing where you might get a -1 to a skill
                //Just return if its a number
                return isANumber;
            }
            else if (KeyReader.getHighKey(key).equals(KEY.H_WEAPON)){
                switch(KeyReader.getLowKey(key)){
                    case KEY.L_ATTK_BONUS:
                    case KEY.L_DMG_BONUS:return isANumber;
                    default:
                }
            }
            //At this point we are just checking other values that could be
            //Numeric. This can increase or decrease depending on future changes
            //All in all, this is just one big if_else statement
            switch(key){
                //Offensive Panel
                case KEY.K_WEAPON_ATTK_BONUS:
                case KEY.K_WEAPON_DMG_BONUS:
                //Util panel
                case KEY.K_INIT_BONUS:
                case KEY.K_SPEED_BONUS:
                //Defense panel
                case KEY.K_DEFENSE_AC_EXTRA:
                case KEY.K_ARMOR_AC:return isANumber;
            }
            //If it's none of the above, then it's a value we don't care
            //about since it's not a number that affects others in the program
            return true;
        }
        else{       
            return false;
        }
    }

    void launchApplication() {
        if(main_frame != null){
            updateValues();
            main_frame.setVisible(true);
        }
    }

    void initFrame() {
        main_frame = new CharacterFrame(this);
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
        main_frame.dispose();
        main_frame = new CharacterFrame(this);
        launchApplication();
    }
    
    public void reinitializeEnvironment(File openCharacterFile){
        FileManager file_manager = new FileManager(
                openCharacterFile, 
                FileManager.TYPE.READ, 
                FileManager.FILE.CXML);
        Bundle character_data = file_manager.getData();
        if(character_data.getBoolean(FileManager.IO_SUCCESS)){
            main_frame.updateValues(character_data);
        }
    }
    
    public File getFileToOpen() throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Character xml (*.cxml)", "cxml");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        File file = null;
        switch(chooser.showOpenDialog(main_frame)){
            case JFileChooser.APPROVE_OPTION:file = chooser.getSelectedFile();
            if(!file.toString().endsWith(".cxml")){
                JOptionPane.showMessageDialog(main_frame, "File does not end with .cxml");
                file = null;;
            }
            case JFileChooser.CANCEL_OPTION:break;
        }
        if(file != null && file.canRead() && file.isFile()){
            return file;
        }
        else if(file == null){
            return null;
        }
        else{
            throw new IOException("The file cannot be opened");
        }
    }
    
    public File getFileToSave() throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Character xml (*.cxml)", "cxml");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        File file = null;
        switch(chooser.showSaveDialog(main_frame)){
            case JFileChooser.APPROVE_OPTION:
                file = chooser.getSelectedFile();
                String filename = file.toString();
                if(!filename.endsWith(".cxml")){
                    file = new File(chooser.getSelectedFile() + ".cxml");
                }
                
        }
        
        return file;
    }

    public void restoreDefaultValue(String key, Document document) {
        try {
            String errorText = "Error, the value you entered ("
                    .concat(document.getText(0, document.getLength()))
                    .concat(") is not a valid number")
                    .concat("A default value will be applied");
            JOptionPane.showMessageDialog(main_frame, errorText, "Invalid Input", 0);
        } catch (BadLocationException ex) {
            Logger.getLogger(AppManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            document.remove(0, document.getLength());
            document.insertString(0, DataIntegrity.getDefault(key), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(AppManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateValues() {
        main_frame.updateAttributePanel();
        main_frame.updateOffensivePanel();
        main_frame.updateDefensePanel();
        main_frame.updateUtilityPanel();
        main_frame.updateSkillPanel();
        main_frame.updateOthers();
    }

    public void saveData(File file, Bundle bundle) {
        FileManager file_manager = new FileManager
        (file, FileManager.TYPE.WRITE, FileManager.FILE.CXML);
        file_manager.sendData(bundle);
        unsavedData = false;
    }

    public void dataChanged() {
        unsavedData = true;
    }

    public void close() {
        main_frame.dispose();
        System.exit(0);
    }

    public void readTemplate() {
        FileManager fm = new FileManager
        (new File(getClass().getResource("/templates/backgrounds.xml").getPath())
                ,FileManager.TYPE.READ, FileManager.FILE.T_BACKGROUND);
        Bundle bundle = fm.getData();
        BackgroundTemplates t = (BackgroundTemplates) bundle.getTemplate(templates.Templates.TYPE.T_BACKGROUND);
        if(t != null){
            System.out.println("Not null");
            Background b = t.getBackground(1);
            ArrayList<String> bonds;
            bonds = b.getStrings(STORY.BOND);
            System.out.println(b.getName());
        }
    }

    

}

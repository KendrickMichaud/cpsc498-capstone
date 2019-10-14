package app;


import constants.KEY;
import gui.CharacterFrame;
import core.PlayerCharacter;
import java.io.File;
import util.KeyReader;

import javax.swing.*;

public class AppManager {
    
    
    private static AppManager manager;
    private JFrame main_frame;
    private PlayerCharacter character;
    private boolean unsavedData;

    static AppManager getInstance() {
        if(manager == null){
            manager = new AppManager();
        }
        return manager;
    }

    private AppManager(){
        character = new PlayerCharacter(manager);
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
}

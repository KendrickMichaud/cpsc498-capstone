package app;

import file_io.FileManager;
import gui.util.KEY;
import gui.character_builder.BuilderFrame;
import gui.character_sheet.CharacterFrame;
import gui.menu.MenuFrame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.util.KeyReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import templates.Templates;

/**
 * Singleton design. 
 * This class is the manager of the entire application and controls:
 *  Launching of new JFrames
 *  Validation of data
 *  Transfer and storage of data
 * 
 *  To get the AppManager, use the AppManager.getInstance() method 
 * 
 * @author Kendrick 
 */
public class AppManager {
    
    private static AppManager manager; //Singleton
    private MenuFrame menuFrame;        //Main Menu
    private BuilderFrame builderFrame;  //Character Builder
    private CharacterFrame character_sheet;  //Character Sheet
    private boolean unsavedData;        //Controls exiting behavior
    private boolean lock;
    
    /**
     * Returns the instance of the AppManager.
     * @return 
     */
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

    /**
     * Updates values based on an initialized character frame and then
     * sets the frame visible for the user
     */
    private void launchCharacterFrame() {
        if(character_sheet != null){
            updateValues();
            menuFrame.setVisible(false);
            character_sheet.setVisible(true);
        }
    }

    /**
     * Creates the Character Frame and passes the singleton (less instance calls)
     * 
     */
    private void initCharacterFrame() {
        character_sheet = new CharacterFrame(this);
        character_sheet.setVisible(false);
    }

    /**
     * Checks if the manager is ready to begin a shutdown of the application
     * or allow an exit from the frame. User is prompted to confirm
     * @return true if user selects yes, false if no
     */
    public boolean authorizedToExit() {
        if(unsavedData){
            int validation = JOptionPane.showConfirmDialog
                (character_sheet, 
                "Are you sure? Unsaved data will be lost.", 
                "Unsaved Changes Detected", 
                0);
            return validation == JOptionPane.YES_OPTION;
        }
        else
            return true;
    }

    /**
     * Reinitializes the CharacterFrame environment with an empty
     * environment
     */
    public void reinitializeEnvironment() {
        character_sheet.dispose();
        character_sheet = new CharacterFrame(this);
        launchCharacterFrame();
    }
    
    /**
     * Reinitializes the CharacterFrame environment with a new 
     * Character XML (.cxml) file
     * @param openCharacterFile 
     */
    public void reinitializeEnvironment(File openCharacterFile){
        FileManager file_manager = new FileManager(
                openCharacterFile, 
                FileManager.IO_TYPE.READ, 
                FileManager.FILE_TYPE.CXML);
        Bundle character_data = file_manager.getData();
        if(character_data.getBoolean(FileManager.IO_SUCCESS)){
            character_sheet.updateValues(character_data);
        }
    }
    
    /**
     * Prompts the user to select a file to open
     * @return File to be opened
     * @throws IOException if the file cannot be opened
     */
    public File getFileToOpen() throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Character xml (*.cxml)", "cxml");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        File file = null;
        switch(chooser.showOpenDialog(character_sheet)){
            case JFileChooser.APPROVE_OPTION:file = chooser.getSelectedFile();
            if(!file.toString().endsWith(".cxml")){
                JOptionPane.showMessageDialog(character_sheet, "File does not end with .cxml");
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
            if(!file.exists()){
                JOptionPane.showMessageDialog(character_sheet, "File does not exist");
            }
            return null;
        }
    }
    
    /**
     * Returns the file to save based on the user's preference.
     * Only allows the user to save in .cxml format. 
     * @return File to save at or null
     * @throws IOException 
     */
    public File getFileToSave() throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Character xml (*.cxml)", "cxml");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        File file = null;
        switch(chooser.showSaveDialog(character_sheet)){
            case JFileChooser.APPROVE_OPTION:
                file = chooser.getSelectedFile();
                String filename = file.toString();
                if(!filename.endsWith(".cxml")){
                    file = new File(chooser.getSelectedFile() + ".cxml");
                    if(file.exists()){
                        JOptionPane.showConfirmDialog(character_sheet, "File exists, do you wish to overwrite");
                    }
                }
        }
        
        return file;
    }

    /**
     * Prompts the user with an error message and sets the document (text)
     * to the default based on the type of key shown. 
     * 
     * @see KEY class for types of KEYS used
     * @param key must be a KEY.K_(anything) type. L_ and H_ types are not valid
     * @param document component containing the text to set default
     */
    public void restoreDefaultValue(String key, Document document) {
        try {
            String errorText = "Error, the value you entered ("
                    .concat(document.getText(0, document.getLength()))
                    .concat(") is not a valid number")
                    .concat("A default value will be applied");
            JOptionPane.showMessageDialog(character_sheet, errorText, "Invalid Input", 0);
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

    /**
     * Updates all automated values in the CharacterFrame
     */
    public void updateValues() {
        character_sheet.updateAttributePanel();
        character_sheet.updateOffensivePanel();
        character_sheet.updateDefensePanel();
        character_sheet.updateUtilityPanel();
        character_sheet.updateSkillPanel();
        character_sheet.updateOthers();
    }

    /**
     * Saves the data based on the file passed in.
     * The Bundle contains all data from the CharacterFrame to be saved
     * @param file
     * @param bundle 
     */
    public void saveData(File file, Bundle bundle) {
        FileManager file_manager = new FileManager
        (file, FileManager.IO_TYPE.WRITE, FileManager.FILE_TYPE.CXML);
        file_manager.sendData(bundle);
        unsavedData = false;
    }

    /**
     * Simple method to show that the data is changed
     */
    public void dataChanged() {
        unsavedData = true;
    }

    /**
     * Exit program via the Character Sheet
     */
    public void close() {
        character_sheet.dispose();
        System.exit(0);
    }

    /**
     * Inits the menu frame and set it to invisible
     */
    void initMenuFrame() {
        menuFrame = new MenuFrame();
        lock = false;
    }

    /**
     * Sets the menuFrame to visible
     */
    void launchMenuFrame() {
        if(menuFrame != null && !lock){
            menuFrame.setVisible(true);
            lock = true;
        }
    }

    /**
     * Initializes the BuilderFrame
     */
    private void initBuilderFrame() {
        BuilderFrame.createInstance(pullTemplates());
        builderFrame = BuilderFrame.getInstance();
    }
    
    /**
     * Pulls all templates from the appropriate files
     * @return Bundle containing the Race, Class, and Background templates
     */
    private Bundle pullTemplates(){
        File fRace, fClass, fBackground;
        fRace = new File(getClass().getResource(Templates.FILE_RACE).getFile());
        fClass = new File(getClass().getResource(Templates.FILE_CLASS).getFile());
        fBackground = new File(getClass().getResource(Templates.FILE_BACKGROUND).getFile());
        FileManager raceManager = new FileManager(fRace, FileManager.IO_TYPE.READ, FileManager.FILE_TYPE.T_RACE);
        FileManager classManager = new FileManager(fClass, FileManager.IO_TYPE.READ, FileManager.FILE_TYPE.T_CLASS);
        FileManager backManager = new FileManager(fBackground, FileManager.IO_TYPE.READ, FileManager.FILE_TYPE.T_BACKGROUND);
        
        Bundle templates = new Bundle();
        templates.putTemplate(Templates.TYPE.T_CLASS, classManager.getData().getTemplate(Templates.TYPE.T_CLASS));
        templates.putTemplate(Templates.TYPE.T_RACE, raceManager.getData().getTemplate(Templates.TYPE.T_RACE));
        templates.putTemplate(Templates.TYPE.T_BACKGROUND, backManager.getData().getTemplate(Templates.TYPE.T_BACKGROUND));
        
        return templates;
    }

    /**
     * Starts the character frame up
     * @param f .cxml file that contains character information
     */
    public void startUpCharacterFrame(File f) {
        if(f == null){
            if(character_sheet != null && character_sheet.isVisible())
                return;
            manager.initCharacterFrame();
            menuFrame.setVisible(false);
            manager.launchCharacterFrame();
        }
        else{
            manager.initCharacterFrame();
            manager.reinitializeEnvironment(f);
            menuFrame.setVisible(false);
            manager.launchCharacterFrame();
        }
    }

    /**
     * Starts up the BuilderFrame
     */
    public void startUpBuilderFrame() {
        if(builderFrame != null && builderFrame.isVisible())
            return;
        initBuilderFrame();
        if(character_sheet != null)
            character_sheet.dispose();
        unsavedData = false;
        menuFrame.setVisible(false);
        builderFrame.setVisible(true);
    }

    /**
     * Starts up the CharacterFrame containing a Bundle of data
     * @param character_info 
     */
    public void startUpCharacterFrame(Bundle character_info) {
        if(character_sheet != null && character_sheet.isVisible())
            return;
        manager.initCharacterFrame();
        manager.characterFrameUpdate(character_info);
        manager.launchCharacterFrame();
    }

    /**
     * Updates the CharacterFrame with a bundle of data
     * bundle must have a true boolean for BuilderFrame.FROM_BUILDER
     * @param character_info this must come from the Builder
     */
    private void characterFrameUpdate(Bundle character_info) {
        if(character_info.getBoolean(BuilderFrame.FROM_BUILDER)){
            character_sheet.updateValues(character_info);
        }
        
    }

    /**
     * Returns to the main menu
     */
    public void goToMainMenu() {
        if(manager.authorizedToExit()){
            if(character_sheet != null)
                character_sheet.setVisible(false);
            if(builderFrame != null)
                builderFrame.setVisible(false);
            menuFrame.setVisible(true);
        }
    }
}

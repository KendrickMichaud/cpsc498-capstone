package app;

import container.CharacterInfoPanel;
import container.ParentPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppFrame extends JFrame {

    private JPanel parent;

    public AppFrame(String name, int width, int height){
        super(name);
        setSize(width, height);
        initProperties();
    }
    
    public AppFrame(String name, int size){
        super(name);
        initFrameSize(size);
        initProperties();
    }

    private void initParentPanel() {
        parent = new ParentPanel();
        JScrollPane scrollPane = new JScrollPane(parent);
        parent.setBackground(Color.GRAY);
        getContentPane().add(scrollPane);
    }

    private void initProperties() {
        createApplicationMenuBar();
        initParentPanel();
        initCharacterInfoPanel();
        initUtilityAndCombatPanel();
        initSkillsAndActionsPanel();
        initFeatsFeaturesProficienciesPanel();
        initInventoryPanel();
        initSpellbookPanel();
    }

    /**
     * Initializes the panel responsible for holding spell information
     */
    private void initSpellbookPanel() {
    }

    /**
     * Initializes the panel that will hold feats, features, and proficiencies
     */
    private void initFeatsFeaturesProficienciesPanel() {
    }

    /**
     * Initializes the panel that will hold the skills and actions available
     * !!! Might require extra work will see.
     */
    private void initSkillsAndActionsPanel() {
    }

    /**
     * Initializes the utility and combat panel. Utility involves things such as
     * speed, initiative, and perception, while combat involves Armor Class, Spell Resistance,
     * and Damage Reduction
     */
    private void initUtilityAndCombatPanel() {

    }

    /**
     * Complex panel responsible for holding items in the form of a list
     */
    private void initInventoryPanel() {

    }

    /**
     * Initializes the Character Information Panel. This panel should interact with the
     * Background and Biography of the Character in particular. For now it should
     * also deal with PlayerRace, and Player Class until we add feature functionality'
     */
    private void initCharacterInfoPanel() {
        JPanel characterInfoPanel = new CharacterInfoPanel();
        parent.add(characterInfoPanel);
    }


    /////////////////////////////////////////////////////////////////////////
    //AppFrame

    private void initFrameSize(int size) {
        double divider = 1.0;
        if(size != 0)
            divider = (double) 100/size;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) ((double) screenSize.width/divider);
        int height = (int) ((double) screenSize.height/divider);
        setSize(width, height);
    }

    /////////////////////////////////////////////////////
    //JMenuBar

    private void createApplicationMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");
        ArrayList<JMenuItem> items;
        items = buildFileItems();
        addItemsFor(file, items);
        items = buildEditItems();
        addItemsFor(edit, items);
        items = buildHelpItems();
        addItemsFor(help, items);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        setJMenuBar(menuBar);
    }

    private ArrayList<JMenuItem> buildHelpItems() {
        ArrayList<JMenuItem> items = new ArrayList<>();
        items.add(new JMenuItem("About..."));
        items.add(new JMenuItem("Guide..."));
        items.add(new JMenuItem("Support..."));
        return items;
    }

    private ArrayList<JMenuItem> buildEditItems() {
        ArrayList<JMenuItem> items = new ArrayList<>();
        items.add(new JMenuItem("Find Item..."));
        items.add(new JMenuItem("Verify Contents..."));
        items.add(new JMenuItem("Lock Changes..."));
        items.add(new JMenuItem("Unlock Changes..."));
        return items;
    }

    private ArrayList<JMenuItem> buildFileItems() {
        ArrayList<JMenuItem> items = new ArrayList<>();
        items.add(new JMenuItem("New..."));
        items.add(new JMenuItem("Save..."));
        items.add(new JMenuItem("Open..."));
        return items;
    }

    private void addItemsFor(JMenu menu, ArrayList<JMenuItem> items) {
        if(items == null){
            throw new NullPointerException("Items is not initialized");
        }
        for(JMenuItem item : items){
            menu.add(item);
        }
    }


}

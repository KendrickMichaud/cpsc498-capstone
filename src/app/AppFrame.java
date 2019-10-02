package app;

import container.CharacterInfoPanel;

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
        parent = new JPanel();
        JScrollPane scrollPane = new JScrollPane(parent);
        parent.setLayout(new GridBagLayout());
        parent.setBackground(Color.GRAY);
        parent.setSize(400, getHeight());
        getContentPane().add(scrollPane);
    }

    private void initProperties() {
        createApplicationMenuBar();
        initParentPanel();
        initCharacterInfoPanel();
        initInventoryPanel();
    }

    private void initInventoryPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        parent.add(panel,constraints);
    }

    /**
     * Initializes the Character Information Panel. This panel should interact with the
     * Background and Biography of the Character in particular. For now it should
     * also deal with PlayerRace, and Player Class until we add feature functionality'
     */
    private void initCharacterInfoPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        parent.add(new CharacterInfoPanel(), constraints);
    }

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

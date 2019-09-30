package app;

import container.CharacterInfoPanel;
import container.FramePanel;

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
        parent = new FramePanel().panel;
        parent.setBackground(Color.GRAY);
        JScrollPane scrollPane = new JScrollPane(parent, ScrollPaneLayout.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    private void initProperties() {
        createApplicationMenuBar();
        initParentPanel();
        initCharacterInfoPanel();
    }

    private void initCharacterInfoPanel() {
        JPanel charInfo = new CharacterInfoPanel().panel;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        parent.add(charInfo, gbc);
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

package app;

import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class AppManager {
    public static JMenuBar createApplicationMenuBar(){

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");
        JMenuItem save = new JMenuItem("Save...");
        JMenuItem create = new JMenuItem("New...");
        JMenuItem open = new JMenuItem("Open...");
        file.add(create);
        file.add(open);
        file.add(save);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        return menuBar;
    }

    public static void createParentPanel(JFrame parent) {
        JButton button = new JButton("Click me");
        JPanel panel = new JPanel(new FlowLayout());


        panel.add(button);
        panel.add(new JButton("Click two"));
        JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneLayout.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        parent.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void launchFrame(AppFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void addLookAndFeel(LookAndFeel materialLookAndFeel) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(materialLookAndFeel);
    }
}

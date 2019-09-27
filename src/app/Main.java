package app;

import constants.GUI;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]){
        try {
            AppManager.addLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            return;
        }
        AppFrame frame = new AppFrame(GUI.app_title, GUI.size);
        AppManager.createParentPanel(frame);
        frame.setJMenuBar(AppManager.createApplicationMenuBar());
        AppManager.launchFrame(frame);
    }
}

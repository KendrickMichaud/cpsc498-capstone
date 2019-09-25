package app;

import constants.GUI;

import javax.swing.*;

public class Main {
    public static void main(String args[]){
        AppFrame frame = new AppFrame(GUI.app_title, GUI.size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

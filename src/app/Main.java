package app;

import constants.GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]){
        AppFrame frame = new AppFrame(GUI.app_title, GUI.size);
        frame.setLayout(new GridLayout());
        AppManager manager = new AppManager(frame);
        manager.launch();
    }
}

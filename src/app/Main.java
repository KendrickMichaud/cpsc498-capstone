package app;

import constants.GUI;

public class Main {
    public static void main(String args[]){
        AppFrame frame = new AppFrame(GUI.app_title, GUI.size);
        AppManager manager = new AppManager(frame);
        manager.launch();
    }
}

package app;

import container.CharacterFrame;

public class Main {
    public static void main(String args[]){
        //NOTE to David, to run this you might have to create a separate class
        // CTRL+C the code from CharacterFrame.java to a new class and then 
        //make the class.
        AppManager manager = AppManager.getInstance();
        manager.initFrame();
        manager.launchApplication();
    }
}

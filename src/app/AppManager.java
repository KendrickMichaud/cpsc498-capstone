package app;


import constants.KEY;
import core.PlayerCharacter;

import javax.swing.*;

public class AppManager {

    private static AppFrame frame;
    private static PlayerCharacter character;

    public AppManager(AppFrame frame){
        if(frame == null)
            throw new NullPointerException();
        AppManager.frame = frame;
        character = new PlayerCharacter();
    }

    public static void changeData(String key, String value) {
        System.out.println(key + " " + value);
        character.updateValue(key, value);
    }

    public static void printData() {
        String value = character.getValue(KEY.CHARACTER_NAME);
        System.out.println("My name is: " + value);
    }

    public void launch() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }






}

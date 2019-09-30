package app;


import container.FramePanel;
import core.PlayerCharacter;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public void launch() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }






}

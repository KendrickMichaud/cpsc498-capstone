package app;


import container.FramePanel;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppManager {

    private AppFrame frame;

    public AppManager(AppFrame frame){
        if(frame == null)
            throw new NullPointerException();
        this.frame = frame;
    }

    public void launch() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

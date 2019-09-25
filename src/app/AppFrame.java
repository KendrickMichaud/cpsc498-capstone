package app;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    public AppFrame(String name, int width, int height){
        super(name);
        setSize(width, height);
    }
    
    public AppFrame(String name, int size){
        super(name);
        buildWindow(size);
    }

    private void buildWindow(int size) {
        double divider = 1.0;
        if(size != 0)
            divider = (double) 100/size;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) ((double) screenSize.width/divider);
        int height = (int) ((double) screenSize.height/divider);
        setSize(width, height);
    }
}

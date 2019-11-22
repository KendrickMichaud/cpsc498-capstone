package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String args[]){
        try {
            //NOTE to David, to run this you might have to create a separate class
            // CTRL+C the code from CharacterFrame.java to a new class and then
            //make the class.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        AppManager manager = AppManager.getInstance();
        manager.initMenuFrame();
        manager.launchMenuFrame();
        //manager.initCharacterFrame();
        //manager.launchCharacterFrame();
    }
}

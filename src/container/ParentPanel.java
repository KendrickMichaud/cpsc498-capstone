package container;

import javax.swing.*;

public class ParentPanel extends JPanel {
    public ParentPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

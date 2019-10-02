package container;

import javax.swing.*;
import java.awt.*;

public class CombatInfoPanel extends JPanel{
    JPanel attributePanel;
    JPanel defenseUtilityPanel;
    JPanel attackPanel;

    public CombatInfoPanel(){
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        initAttributePanel();
        add(attributePanel);
        initDefenseUtilPanel();
        add(defenseUtilityPanel);
        initAttackPanel();
        add(attackPanel);
    }

    private void initAttackPanel() {
        
    }

    private void initDefenseUtilPanel() {
    }

    private void initAttributePanel() {

    }
}

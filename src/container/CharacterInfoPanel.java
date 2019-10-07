package container;

import app.AppManager;
import constants.GUI;
import constants.KEY;
import constants.TEXT;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CharacterInfoPanel extends JPanel {

    private JPanel panBasicInfo;

    public CharacterInfoPanel(){
        super();
        initLayout();
        initBasicInfoPanel();
        initFields();
        add(panBasicInfo);
    }

    private void initBasicInfoPanel() {
        panBasicInfo = new JPanel();
        panBasicInfo.setLayout(new BoxLayout(panBasicInfo, BoxLayout.Y_AXIS));
    }

    private void initLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    private void initFields() {
        initializeEntry(GUI.LABEL_NAME, KEY.CHARACTER_NAME, panBasicInfo);
        initializeEntry(GUI.LABEL_CLASS, KEY.PLAYER_CLASS, panBasicInfo);
        initializeEntry(GUI.LABEL_RACE, KEY.RACE_NAME, panBasicInfo);
        initializeEntry(GUI.LABEL_DEITY, KEY.DEITY, panBasicInfo);
        initializeEntry(GUI.LABEL_ALIGNMENT, KEY.ALIGNMENT, panBasicInfo);
        initializeEntry(GUI.LABEL_SIZE, KEY.SIZE, panBasicInfo);
        initializeEntry(GUI.LABEL_HEIGHT, KEY.HEIGHT, panBasicInfo);
        initializeEntry(GUI.LABEL_WEIGHT, KEY.WEIGHT, panBasicInfo);
    }

    private void initializeEntry(String labelName, String textKey, JPanel panBasicInfo){
        JLabel label = new JLabel();
        label.setText(labelName);
        JTextField field = new JTextField();
        field.setName(textKey);
        field.setColumns(TEXT.VERY_LONG);
        addQueryUpdateListener(field);
        panBasicInfo.add(label);
        panBasicInfo.add(field);
    }

    private void addQueryUpdateListener(Component obj){
        JTextField field;
        JTextArea area;

        if(obj.getClass().equals(JTextField.class)){
            field = (JTextField) obj;
            field.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    AppManager.changeData(field.getName(), field.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    AppManager.changeData(field.getName(), field.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    AppManager.changeData(field.getName(), field.getText());
                }
            });
        }
        else if(obj.getClass().equals(JTextArea.class)){
            area = (JTextArea) obj;
            area.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    AppManager.changeData(area.getName(), area.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    AppManager.changeData(area.getName(), area.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    AppManager.changeData(area.getName(), area.getText());
                }
            });
        }

    }
}

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
    private JPanel panBackground;
    private boolean textArea;

    public CharacterInfoPanel(){
        super();
        initLayout();
        initBasicInfoPanel();
        initBackgroundPanel();
        initFields();
        add(panBasicInfo);
        add(panBackground);
    }

    private void initBackgroundPanel() {
        panBackground = new JPanel();
        panBackground.setLayout(new BoxLayout(panBackground, BoxLayout.Y_AXIS));
    }

    private void initBasicInfoPanel() {
        panBasicInfo = new JPanel();
        panBasicInfo.setLayout(new BoxLayout(panBasicInfo, BoxLayout.Y_AXIS));
    }

    private void initLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    private void initFields() {
        textArea = false;
        initializeEntry(GUI.LABEL_NAME, KEY.characterName, TEXT.LONG, panBasicInfo);
        initializeEntry(GUI.LABEL_CLASS, KEY.playerClass, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_RACE, KEY.race, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_DEITY, KEY.deity, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_ALIGNMENT, KEY.alignment, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_SIZE, KEY.size, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_HEIGHT, KEY.height, TEXT.SHORT, panBasicInfo);
        initializeEntry(GUI.LABEL_WEIGHT, KEY.weight, TEXT.SHORT, panBasicInfo);

        textArea = true;
        initializeEntry(GUI.LABEL_BACKGROUND, KEY.BACKGROUND_TITLE, TEXT.MEDIUM, panBackground);
        initializeEntry(GUI.PERSONALITY_TRAIT, KEY.PERSONALITY_TRAIT, TEXT.MEDIUM, panBackground);
        initializeEntry(GUI.IDEAL, KEY.IDEAL, TEXT.MEDIUM, panBackground);
        initializeEntry(GUI.BOND, KEY.BOND, TEXT.MEDIUM, panBackground);
        initializeEntry(GUI.FLAW, KEY.FLAW, TEXT.MEDIUM, panBackground);

    }

    private void initializeEntry(String labelName, String textKey, int textLength, JPanel panBasicInfo){
        JLabel label = new JLabel();
        Component text = null;
        label.setText(labelName);
        if(!textArea){
            JTextField field = new JTextField();
            field.setName(textKey);
            field.setColumns(TEXT.VERY_LONG);
            field.setMaximumSize(field.getPreferredSize());
            text = field;
            addQueryUpdateListener(text);
            panBasicInfo.add(label);
            panBasicInfo.add(text);
        }
        else{
            JTextArea area = new JTextArea();
            area.setName(textKey);
            area.setMaximumSize(new Dimension(160,40));
            text = area;
            JScrollPane pane = new JScrollPane(text);
            addQueryUpdateListener(text);
            panBackground.add(label);
            panBackground.add(pane);
        }

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

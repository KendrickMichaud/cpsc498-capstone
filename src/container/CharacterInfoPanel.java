package container;

import app.AppManager;
import constants.GUI;
import constants.KEY;
import constants.TEXT;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CharacterInfoPanel extends JPanel {

    public CharacterInfoPanel(){
        super();
        initFields();
    }

    private void initFields() {
        initializeEntry(GUI.LABEL_NAME, KEY.characterName, TEXT.LONG);
        initializeEntry(GUI.LABEL_CLASS, KEY.playerClass, TEXT.SHORT);
        initializeEntry(GUI.LABEL_RACE, KEY.race, TEXT.SHORT);
        initializeEntry(GUI.LABEL_DEITY, KEY.deity, TEXT.SHORT);
        initializeEntry(GUI.LABEL_ALIGNMENT, KEY.alignment, TEXT.SHORT);
        initializeEntry(GUI.LABEL_SIZE, KEY.size, TEXT.SHORT);
        initializeEntry(GUI.LABEL_HEIGHT, KEY.height, TEXT.SHORT);
        initializeEntry(GUI.LABEL_WEIGHT, KEY.weight, TEXT.SHORT);
    }

    private void initializeEntry(String labelName, String textKey, int textLength){
        JLabel label = new JLabel();
        JTextField text = new JTextField();
        label.setText(labelName);
        text.setName(textKey);
        text.setColumns(textLength);
        addQueryUpdateListener(text);
        add(label);
        add(text);
    }

    private void addQueryUpdateListener(JTextField field){
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStringValue(field);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStringValue(field);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStringValue(field);
            }
        });
    }

    private void updateStringValue(JTextField field) {
        String key = field.getName();
        String value = field.getText();
        AppManager.changeData(key,value);
    }
}

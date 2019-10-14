package gui;

import app.AppManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TextChangeListener implements DocumentListener {

    private final String key;
    private final AppManager manager;

    public TextChangeListener(String key, AppManager manager){
        this.key = key;
        this.manager = manager;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        sendQuery(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        sendQuery(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        sendQuery(e);
    }

    private void sendQuery(DocumentEvent e) {
        Document document = e.getDocument();
        int length = document.getLength();
        try {
            manager.updateData(key, document.getText(0, length));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

}

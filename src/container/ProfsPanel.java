/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import constants.KEY;
import javax.swing.text.Document;
import util.Bundle;
import util.SwingHelper;

/**
 *
 * @author Kendrick
 */
public class ProfsPanel extends javax.swing.JPanel implements CardDataHolder{

    /**
     * Creates new form ProfsPanel
     */
    public ProfsPanel() {
        initComponents();
        SwingHelper.addTabFocusChanger(txt_profs);
        SwingHelper.wrapWord(txt_profs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_prof = new javax.swing.JScrollPane();
        txt_profs = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        txt_profs.setColumns(20);
        txt_profs.setLineWrap(true);
        txt_profs.setRows(5);
        scroll_prof.setViewportView(txt_profs);

        add(scroll_prof, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scroll_prof;
    private javax.swing.JTextArea txt_profs;
    // End of variables declaration//GEN-END:variables

    @Override
    public Document extractDocument(String key) {
        return txt_profs.getDocument();
    }

    @Override
    public void putDocument(String key, String value) {
    }

    @Override
    public void getData(Bundle b) {
        b.putString(KEY.K_EQUIPMENT_LANG_PROFICIENCIES, SwingHelper.extractString(txt_profs));
    }

    @Override
    public void update(Bundle b) {
        String desc = b.getString(KEY.K_EQUIPMENT_LANG_PROFICIENCIES);
        if(desc != null){
            txt_profs.setText(desc);
            SwingHelper.setScrollPositionToTop(scroll_prof);
        }
    }
}

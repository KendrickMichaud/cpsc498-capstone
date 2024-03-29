/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.character_sheet;

import gui.util.KEY;
import app.Bundle;
import gui.util.SwingHelper;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Kendrick
 */
public class BackgroundFrame extends javax.swing.JFrame {

    /**
     * Creates new form BackgroundFrame
     */
    public BackgroundFrame() {
        initComponents();
        SwingHelper.addTabFocusChanger(txt_bond);
        SwingHelper.addTabFocusChanger(txt_flaw);
        SwingHelper.addTabFocusChanger(txt_ideal);
        SwingHelper.addTabFocusChanger(txt_trait);
        SwingHelper.wrapWord(txt_bond);
        SwingHelper.wrapWord(txt_flaw);
        SwingHelper.wrapWord(txt_ideal);
        SwingHelper.wrapWord(txt_trait);
        try {
            File f = new File(getClass().getResource("/img/icon_person.png").getPath());
            if(f != null){
                BufferedImage img = ImageIO.read(f);
                setIconImage(img);
            }
        } catch (IOException ex) {
            Logger.getLogger(CharacterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_trait = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_ideal = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_bond = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_flaw = new javax.swing.JTextArea();

        setTitle("Background");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("Background Name");
        jPanel2.add(jLabel1);
        jPanel2.add(txt_name);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("Background Trait");
        jPanel3.add(jLabel2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_trait.setColumns(20);
        txt_trait.setLineWrap(true);
        txt_trait.setRows(5);
        jScrollPane1.setViewportView(txt_trait);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText("Background Ideal");
        jPanel4.add(jLabel3);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_ideal.setColumns(20);
        txt_ideal.setLineWrap(true);
        txt_ideal.setRows(5);
        jScrollPane3.setViewportView(txt_ideal);

        jPanel4.add(jScrollPane3);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Background Bond");
        jPanel5.add(jLabel4);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_bond.setColumns(20);
        txt_bond.setLineWrap(true);
        txt_bond.setRows(5);
        jScrollPane4.setViewportView(txt_bond);

        jPanel5.add(jScrollPane4);

        jPanel1.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Background Flaw");
        jPanel6.add(jLabel5);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_flaw.setColumns(20);
        txt_flaw.setLineWrap(true);
        txt_flaw.setRows(5);
        jScrollPane5.setViewportView(txt_flaw);

        jPanel6.add(jScrollPane5);

        jPanel1.add(jPanel6);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void collectData(Bundle b) {
        b.putString(KEY.K_BACKGROUND_NAME, SwingHelper.extractString(txt_name));
        b.putString(KEY.K_BACKGROUND_FLAW, SwingHelper.extractString(txt_flaw));
        b.putString(KEY.K_BACKGROUND_IDEAL, SwingHelper.extractString(txt_ideal));
        b.putString(KEY.K_BACKGROUND_BOND, SwingHelper.extractString(txt_bond));
        b.putString(KEY.K_BACKGROUND_TRAIT, SwingHelper.extractString(txt_trait));
    }
    
    void updateData(Bundle b){
        String name, ideal, flaw, bond, trait;
        name = b.getString(KEY.K_BACKGROUND_NAME);
        ideal = b.getString(KEY.K_BACKGROUND_IDEAL);
        bond = b.getString(KEY.K_BACKGROUND_BOND);
        trait = b.getString(KEY.K_BACKGROUND_TRAIT);
        flaw = b.getString(KEY.K_BACKGROUND_FLAW);
        
        SwingHelper.putString(name, txt_name);
        SwingHelper.putString(ideal, txt_ideal);
        SwingHelper.putString(bond, txt_bond);
        SwingHelper.putString(trait, txt_trait);
        SwingHelper.putString(flaw, txt_flaw);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txt_bond;
    private javax.swing.JTextArea txt_flaw;
    private javax.swing.JTextArea txt_ideal;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextArea txt_trait;
    // End of variables declaration//GEN-END:variables

}

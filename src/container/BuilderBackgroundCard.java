/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import constants.KEY;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.Document;
import templates.BackgroundTemplates;
import templates.Templates;
import util.Bundle;

/**
 *
 * @author Kendrick-Laptop
 */
public class BuilderBackgroundCard extends javax.swing.JPanel implements CardDataHolder{

    private BackgroundTemplates tBackgrounds;

    /**
     * Creates new form BuilderBackgroundCard
     */
    public BuilderBackgroundCard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        combo_backgrounds = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_trait = new javax.swing.JComboBox<>();
        combo_bond = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        combo_ideal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        combo_flaw = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_background_deck_title.png"))); // NOI18N
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(null);

        jLabel2.setText("Select your Background");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 10, 170, 14);

        combo_backgrounds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_backgrounds.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_backgroundsItemStateChanged(evt);
            }
        });
        jPanel4.add(combo_backgrounds);
        combo_backgrounds.setBounds(10, 30, 90, 20);

        jLabel3.setText("Personality Trait");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 60, 370, 14);

        combo_trait.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(combo_trait);
        combo_trait.setBounds(10, 80, 240, 40);

        combo_bond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(combo_bond);
        combo_bond.setBounds(10, 150, 240, 40);

        jLabel4.setText("Personality Bond");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 130, 370, 14);

        combo_ideal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(combo_ideal);
        combo_ideal.setBounds(10, 220, 240, 40);

        jLabel5.setText("Personality Ideal");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 200, 370, 14);

        combo_flaw.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(combo_flaw);
        combo_flaw.setBounds(10, 290, 240, 40);

        jLabel6.setText("Personality Flaw");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 270, 370, 14);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_backgroundsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_backgroundsItemStateChanged
        BuilderFrame frame = BuilderFrame.getInstance();
        frame.updateValues();
    }//GEN-LAST:event_combo_backgroundsItemStateChanged

    @Override
    public Document extractDocument(String key) {return null;}

    @Override
    public void putDocument(String key, String value) {}

    @Override
    public void getData(Bundle b) {
    }

    @Override
    public void update(Bundle b) {
    }

    BackgroundTemplates.Background getSelectedBackground() {
        String item = (String) combo_backgrounds.getSelectedItem();
        for(BackgroundTemplates.Background b : tBackgrounds){
            if(b.getName().equals(item))
                return b;
        }
        return null;        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_backgrounds;
    private javax.swing.JComboBox<String> combo_bond;
    private javax.swing.JComboBox<String> combo_flaw;
    private javax.swing.JComboBox<String> combo_ideal;
    private javax.swing.JComboBox<String> combo_trait;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    void storeInfo(Bundle character_info) {
        if(character_info == null)
            character_info = new Bundle();
        
        BackgroundTemplates.Background ba = getSelectedBackground();
        if(ba != null){
            character_info.putString(KEY.K_BACKGROUND_NAME, ba.getName());
            character_info.putString(KEY.K_BACKGROUND_TRAIT, (String) combo_trait.getSelectedItem());
            character_info.putString(KEY.K_BACKGROUND_IDEAL, (String) combo_ideal.getSelectedItem());
            character_info.putString(KEY.K_BACKGROUND_FLAW, (String) combo_flaw.getSelectedItem());
            character_info.putString(KEY.K_BACKGROUND_BOND, (String) combo_bond.getSelectedItem());
        }
    }

    void putTemplate(Templates template) {
        if(template != null && template instanceof BackgroundTemplates){
            tBackgrounds = (BackgroundTemplates) template;
            
            Vector<String> backgroundNames = new Vector<>();
            tBackgrounds.forEach((b) -> {
                backgroundNames.add(b.getName());
            });
            backgroundNames.add("(DEBUG_NULL)");
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel(backgroundNames);
            combo_backgrounds.setModel(model);
            
            
        }
    }

    void resetComponents() {
    }

    void updateComponents(BackgroundTemplates.Background ba) {
            Vector<String> backgroundTraits = new Vector<>();
            Vector<String> backgroundBonds = new Vector<>();
            Vector<String> backgroundIdeals = new Vector<>();
            Vector<String> backgroundFlaws = new Vector<>();     
            backgroundTraits.addAll(ba.getStrings(BackgroundTemplates.Background.STORY.TRAIT));
            backgroundBonds.addAll(ba.getStrings(BackgroundTemplates.Background.STORY.BOND));
            backgroundIdeals.addAll(ba.getStrings(BackgroundTemplates.Background.STORY.IDEAL));
            backgroundFlaws.addAll(ba.getStrings(BackgroundTemplates.Background.STORY.FLAW));
            
            DefaultComboBoxModel<String> traitsModel = new DefaultComboBoxModel<>(backgroundTraits);
            DefaultComboBoxModel<String> bondsModel = new DefaultComboBoxModel<>(backgroundBonds);
            DefaultComboBoxModel<String> idealsModel = new DefaultComboBoxModel<>(backgroundIdeals);
            DefaultComboBoxModel<String> flawsModel = new DefaultComboBoxModel<>(backgroundFlaws);
            
            combo_trait.setModel(traitsModel);
            combo_bond.setModel(bondsModel);
            combo_ideal.setModel(idealsModel);
            combo_flaw.setModel(flawsModel);
    }
    
    
}

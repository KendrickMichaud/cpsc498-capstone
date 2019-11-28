/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import app.AppManager;
import constants.KEY;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.Document;
import templates.ClassTemplates;
import templates.Feature;
import templates.PlayerClass;
import templates.PlayerRace;
import templates.RaceTemplates;
import templates.Templates;
import util.Bundle;
import util.ChoiceMaker;

/**
 *
 * @author Kendrick-Laptop
 */
public class BuilderRaceCard extends javax.swing.JPanel implements CardDataHolder{

    private RaceTemplates raceTemplates;

    /**
     * Creates new form BuilderRaceCard
     */
    public BuilderRaceCard() {
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        combo_races = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_pane_flavor = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_languages = new javax.swing.JLabel();
        lbl_attribute_bonuses = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_race_deck_title.png"))); // NOI18N
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(null);

        combo_races.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        combo_races.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_racesItemStateChanged(evt);
            }
        });
        jPanel3.add(combo_races);
        combo_races.setBounds(20, 40, 250, 20);

        txt_pane_flavor.setEditable(false);
        jScrollPane2.setViewportView(txt_pane_flavor);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 72, 250, 380);

        jLabel2.setText("Select your Race here...");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 10, 250, 14);

        jLabel3.setText("Attributes:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 460, 60, 14);

        jLabel4.setText("Languages: ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 480, 70, 14);

        lbl_languages.setText("None");
        jPanel3.add(lbl_languages);
        lbl_languages.setBounds(90, 480, 200, 14);

        lbl_attribute_bonuses.setText("None");
        jPanel3.add(lbl_attribute_bonuses);
        lbl_attribute_bonuses.setBounds(90, 460, 200, 14);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_racesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_racesItemStateChanged
        BuilderFrame frame = BuilderFrame.getInstance();
        frame.updateValues();
    }//GEN-LAST:event_combo_racesItemStateChanged

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

    public PlayerRace getSelectedRace() {
        String item = (String) combo_races.getSelectedItem();
        for(PlayerRace r : raceTemplates){
            if(r.name.equals(item))
                return r;
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_races;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_attribute_bonuses;
    private javax.swing.JLabel lbl_languages;
    private javax.swing.JTextPane txt_pane_flavor;
    // End of variables declaration//GEN-END:variables

    void storeInfo(Bundle character_info) {
        if(character_info == null)
            return;
        PlayerRace ra = getSelectedRace();
        if(ra != null){
            String raceName = ra.name;
            String size = ra.size;
            if(raceName != null){
                character_info.putString(KEY.K_RACE, raceName);
            }
            
            if(size != null)
                character_info.putString(KEY.K_SIZE, size);
            
        ArrayList<Feature> features = ra.features;
        if(features != null){
            String feats = character_info.getString(KEY.K_FEATURES_DESCRIPTION);
            if(feats == null){
                feats = "";
            }
            for(Feature f : features){
                String name = f.name.concat("\n");
                String desc = f.description.concat("\n");
                if(feats.equals("")){
                    feats += name.concat(desc);
                }
                else{
                    feats += "\n".concat(name).concat(desc);
                }
                
            
            }
            
            character_info.putString(KEY.K_FEATURES_DESCRIPTION, feats);
        }
        
        
        }
    }

    void resetComponents() {
        
    }

    void updateComponents(PlayerRace ra) {
        if(ra != null){
            String flavorText = ra.flavorText;
            if(flavorText != null){
                txt_pane_flavor.setText(flavorText);
            }
            //This is for attributes now
            Bundle attributes = ra.attributes;
            if(attributes != null){
                int str, dex, con, intel, wis, cha;
                str = attributes.getInteger(KEY.L_STRENGTH);
                dex = attributes.getInteger(KEY.L_DEXTERITY);
                con = attributes.getInteger(KEY.L_CONSTITUION);
                intel = attributes.getInteger(KEY.L_INTELLIGENCE);
                wis = attributes.getInteger(KEY.L_WISDOM);
                cha = attributes.getInteger(KEY.L_CHARISMA);
                
                String text = "";
                text = checkAttributes(str, "STR").concat(checkAttributes(dex, "DEX"))
                        .concat(checkAttributes(con, "CON")).concat(checkAttributes(intel, "INT"))
                        .concat(checkAttributes(wis, "WIS")).concat(checkAttributes(cha, "CHA"));
                int wild = attributes.getInteger("wildcard");
                int amt = attributes.getInteger("wildcardAmount");
                
                if(amt > 0 && wild > 0){
                    String wildcard =                         
                    "; Pick "
                            .concat(Integer.toString(amt))
                            .concat(" attributes, add +")
                            .concat(Integer.toString(wild));
                    text += wildcard;
                }
               lbl_attribute_bonuses.setText(text);
            }
            
            Bundle languages = ra.languages;
            if(languages != null){
                int size = languages.getInteger(KEY.L_SIZE);
                String langs = "";
                for(int i = 0; i < size-1; i++){
                    String lang = languages.getString(Integer.toString(i));
                    langs += lang + ", ";
                }
                
                langs += languages.getString(Integer.toString(size-1));
                
                if(languages.getInteger("wildcard") > 0){
                    langs += ", pick " + languages.getInteger("wildcard") + " extra";
                }
                lbl_languages.setText(langs);
            }
        }
    }

    void putTemplate(Templates templates) {
        if(templates != null && templates instanceof RaceTemplates){
            raceTemplates = (RaceTemplates) templates;
            Vector<String> raceNames = new Vector<>();
            raceTemplates.forEach((r) -> {
                raceNames.add(r.name);
            });
            raceNames.add("(DEBUG_NULL)");
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel(raceNames);
            combo_races.setModel(model);
            
        }
    }

    private String checkAttributes(int ability, String text) {
        if(ability > 0){
            return text.concat(" +".concat(Integer.toString(ability)));
        }
        else{
            return "";
        }
    }

    void randomize() {
        ChoiceMaker.decideComboBox(combo_races);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import constants.KEY;
import javax.swing.text.Document;

/**
 *
 * @author Kendrick
 */
public class ArmorPanel extends javax.swing.JPanel implements CardDataHolder{

    /**
     * Creates new form ArmorPanel
     */
    public ArmorPanel() {
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

        jPanel1 = new javax.swing.JPanel();
        cf_lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        cf_lbl_ac = new javax.swing.JLabel();
        txt_armor_class = new javax.swing.JTextField();
        cf_lbl_dex_cap = new javax.swing.JLabel();
        txt_dexterity_cap = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cf_lbl_description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_description = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        cf_lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cf_lbl_name.setText("Name");
        jPanel1.add(cf_lbl_name);

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_name);

        cf_lbl_ac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cf_lbl_ac.setText("Armor Class");
        jPanel1.add(cf_lbl_ac);

        txt_armor_class.setText("0");
        jPanel1.add(txt_armor_class);

        cf_lbl_dex_cap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cf_lbl_dex_cap.setText("Dexterity Cap");
        jPanel1.add(cf_lbl_dex_cap);

        txt_dexterity_cap.setText("0");
        jPanel1.add(txt_dexterity_cap);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        cf_lbl_description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cf_lbl_description.setText("Description");
        jPanel2.add(cf_lbl_description, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_description.setColumns(20);
        txt_description.setLineWrap(true);
        txt_description.setRows(5);
        jScrollPane1.setViewportView(txt_description);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cf_lbl_ac;
    private javax.swing.JLabel cf_lbl_description;
    private javax.swing.JLabel cf_lbl_dex_cap;
    private javax.swing.JLabel cf_lbl_name;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_armor_class;
    public javax.swing.JTextArea txt_description;
    public javax.swing.JTextField txt_dexterity_cap;
    public javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

    int getDEX_CAP() {
        return Integer.parseInt(txt_dexterity_cap.getText());
    }
    
    int getAC(){
        return Integer.parseInt(txt_armor_class.getText());
    }

    @Override
    public Document extractDocument(String key) {
        switch(key){
            case KEY.K_ARMOR_AC:return txt_armor_class.getDocument();
            case KEY.K_ARMOR_DESCRIPTION:return txt_description.getDocument();
            case KEY.K_ARMOR_DEX_CAP:return txt_dexterity_cap.getDocument();
            case KEY.K_ARMOR_NAME:return txt_name.getDocument();
        }
        return null;
    }

    @Override
    public void putDocument(String key, String value) {
    }


}

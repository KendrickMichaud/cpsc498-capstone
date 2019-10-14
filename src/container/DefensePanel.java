/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Kendrick
 */
public class DefensePanel extends javax.swing.JPanel {

    /**
     * Creates new form DefensePanel
     */
    public DefensePanel() {
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

        jPanel5 = new javax.swing.JPanel();
        lbl_ac_title = new javax.swing.JLabel();
        lbl_equal_sign = new javax.swing.JLabel();
        lbl_armor_title = new javax.swing.JLabel();
        lbl_dex_bonus_title = new javax.swing.JLabel();
        lbl_bonus_ac_title = new javax.swing.JLabel();
        lbl_derived_ac = new javax.swing.JLabel();
        lbl_equal_sign2 = new javax.swing.JLabel();
        lbl_derived_armor = new javax.swing.JLabel();
        lbl_derived_dexterity_bonus = new javax.swing.JLabel();
        txt_extra_ac_bonus = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbl_common_save_type_title = new javax.swing.JLabel();
        lbl_common_save_total_title = new javax.swing.JLabel();
        lbl_common_save_derived_title = new javax.swing.JLabel();
        lbl_common_save_bonus_title = new javax.swing.JLabel();
        lbl_common_save_dex_title = new javax.swing.JLabel();
        lbl_derived_dex_total = new javax.swing.JLabel();
        lbl_derived_dex_mod = new javax.swing.JLabel();
        txt_dex_bonus = new javax.swing.JTextField();
        lbl_common_save_wis_title = new javax.swing.JLabel();
        lbl_derived_wis_total = new javax.swing.JLabel();
        lbl_derived_wis_mod = new javax.swing.JLabel();
        txt_wis_bonus = new javax.swing.JTextField();
        lbl_common_save_cha_title = new javax.swing.JLabel();
        lbl_derived_cha_total = new javax.swing.JLabel();
        lbl_derived_cha_mod = new javax.swing.JLabel();
        txt_cha_bonus = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(2, 5));

        lbl_ac_title.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_ac_title.setText("AC");
        jPanel5.add(lbl_ac_title);

        lbl_equal_sign.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_equal_sign.setText("= ");
        jPanel5.add(lbl_equal_sign);

        lbl_armor_title.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_armor_title.setText("ARM");
        jPanel5.add(lbl_armor_title);

        lbl_dex_bonus_title.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dex_bonus_title.setText("DEX");
        jPanel5.add(lbl_dex_bonus_title);

        lbl_bonus_ac_title.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_bonus_ac_title.setText("EXTRA");
        jPanel5.add(lbl_bonus_ac_title);

        lbl_derived_ac.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_derived_ac.setText("0");
        jPanel5.add(lbl_derived_ac);

        lbl_equal_sign2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_equal_sign2.setText("=");
        jPanel5.add(lbl_equal_sign2);

        lbl_derived_armor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_derived_armor.setText("0");
        jPanel5.add(lbl_derived_armor);

        lbl_derived_dexterity_bonus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_derived_dexterity_bonus.setText("0");
        jPanel5.add(lbl_derived_dexterity_bonus);

        txt_extra_ac_bonus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(txt_extra_ac_bonus);

        add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Common Saves");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.GridLayout(4, 4));

        lbl_common_save_type_title.setText("Type");
        jPanel9.add(lbl_common_save_type_title);

        lbl_common_save_total_title.setText("Total");
        jPanel9.add(lbl_common_save_total_title);

        lbl_common_save_derived_title.setText("Modifier");
        jPanel9.add(lbl_common_save_derived_title);

        lbl_common_save_bonus_title.setText("Bonus");
        jPanel9.add(lbl_common_save_bonus_title);

        lbl_common_save_dex_title.setText("DEX");
        jPanel9.add(lbl_common_save_dex_title);

        lbl_derived_dex_total.setText("0");
        jPanel9.add(lbl_derived_dex_total);

        lbl_derived_dex_mod.setText("0");
        jPanel9.add(lbl_derived_dex_mod);
        jPanel9.add(txt_dex_bonus);

        lbl_common_save_wis_title.setText("WIS");
        jPanel9.add(lbl_common_save_wis_title);

        lbl_derived_wis_total.setText("0");
        jPanel9.add(lbl_derived_wis_total);

        lbl_derived_wis_mod.setText("0");
        jPanel9.add(lbl_derived_wis_mod);
        jPanel9.add(txt_wis_bonus);

        lbl_common_save_cha_title.setText("CHA");
        jPanel9.add(lbl_common_save_cha_title);

        lbl_derived_cha_total.setText("0");
        jPanel9.add(lbl_derived_cha_total);

        lbl_derived_cha_mod.setText("0");
        jPanel9.add(lbl_derived_cha_mod);
        jPanel9.add(txt_cha_bonus);

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        add(jPanel8, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_ac_title;
    private javax.swing.JLabel lbl_armor_title;
    private javax.swing.JLabel lbl_bonus_ac_title;
    private javax.swing.JLabel lbl_common_save_bonus_title;
    private javax.swing.JLabel lbl_common_save_cha_title;
    private javax.swing.JLabel lbl_common_save_derived_title;
    private javax.swing.JLabel lbl_common_save_dex_title;
    private javax.swing.JLabel lbl_common_save_total_title;
    private javax.swing.JLabel lbl_common_save_type_title;
    private javax.swing.JLabel lbl_common_save_wis_title;
    private javax.swing.JLabel lbl_derived_ac;
    private javax.swing.JLabel lbl_derived_armor;
    private javax.swing.JLabel lbl_derived_cha_mod;
    private javax.swing.JLabel lbl_derived_cha_total;
    private javax.swing.JLabel lbl_derived_dex_mod;
    private javax.swing.JLabel lbl_derived_dex_total;
    private javax.swing.JLabel lbl_derived_dexterity_bonus;
    private javax.swing.JLabel lbl_derived_wis_mod;
    private javax.swing.JLabel lbl_derived_wis_total;
    private javax.swing.JLabel lbl_dex_bonus_title;
    private javax.swing.JLabel lbl_equal_sign;
    private javax.swing.JLabel lbl_equal_sign2;
    public javax.swing.JTextField txt_cha_bonus;
    public javax.swing.JTextField txt_dex_bonus;
    public javax.swing.JTextField txt_extra_ac_bonus;
    public javax.swing.JTextField txt_wis_bonus;
    // End of variables declaration//GEN-END:variables
}

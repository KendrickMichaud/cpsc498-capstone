/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

/**
 *
 * @author Kendrick
 */
public class ResistancesPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResistancesPanel
     */
    public ResistancesPanel() {
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

        panel_spell_resistance = new javax.swing.JPanel();
        lbl_damage_resistance_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_damage_resistance = new javax.swing.JTextArea();
        panel_damage_resistance = new javax.swing.JPanel();
        lbl_spell_resistance_title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_spell_resistance = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        panel_spell_resistance.setLayout(new java.awt.BorderLayout());

        lbl_damage_resistance_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_damage_resistance_title.setText("Damage Resistance");
        panel_spell_resistance.add(lbl_damage_resistance_title, java.awt.BorderLayout.PAGE_START);

        txt_damage_resistance.setColumns(20);
        txt_damage_resistance.setLineWrap(true);
        txt_damage_resistance.setRows(5);
        jScrollPane1.setViewportView(txt_damage_resistance);

        panel_spell_resistance.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(panel_spell_resistance);

        panel_damage_resistance.setLayout(new java.awt.BorderLayout());

        lbl_spell_resistance_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_spell_resistance_title.setText("Spell Resistance");
        panel_damage_resistance.add(lbl_spell_resistance_title, java.awt.BorderLayout.PAGE_START);

        txt_spell_resistance.setColumns(20);
        txt_spell_resistance.setLineWrap(true);
        txt_spell_resistance.setRows(5);
        jScrollPane2.setViewportView(txt_spell_resistance);

        panel_damage_resistance.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(panel_damage_resistance);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_damage_resistance_title;
    private javax.swing.JLabel lbl_spell_resistance_title;
    private javax.swing.JPanel panel_damage_resistance;
    private javax.swing.JPanel panel_spell_resistance;
    public javax.swing.JTextArea txt_damage_resistance;
    public javax.swing.JTextArea txt_spell_resistance;
    // End of variables declaration//GEN-END:variables
}

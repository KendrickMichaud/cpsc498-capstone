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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panel_damage_resistance = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        panel_spell_resistance.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Damage Resistance");
        panel_spell_resistance.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        panel_spell_resistance.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(panel_spell_resistance);

        panel_damage_resistance.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Spell Resistance");
        panel_damage_resistance.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        panel_damage_resistance.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(panel_damage_resistance);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel panel_damage_resistance;
    private javax.swing.JPanel panel_spell_resistance;
    // End of variables declaration//GEN-END:variables
}

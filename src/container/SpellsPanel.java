/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import javax.swing.text.Document;

/**
 *
 * @author Kendrick
 */
public class SpellsPanel extends javax.swing.JPanel implements CardDataHolder{

    /**
     * Creates new form SpellsPanel
     */
    public SpellsPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_spells = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        table_spells.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Spell Name", "Description", "Required Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_spells.setColumnSelectionAllowed(true);
        table_spells.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_spells);
        table_spells.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table_spells.getColumnModel().getColumnCount() > 0) {
            table_spells.getColumnModel().getColumn(2).setResizable(false);
            table_spells.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        add(jScrollPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_spells;
    // End of variables declaration//GEN-END:variables

    @Override
    public Document extractDocument(String key) {
        return null;
    }

    @Override
    public void putDocument(String key, String value) {
    }
}

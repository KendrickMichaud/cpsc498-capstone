/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.character_sheet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import data_structure.Inventory;
import data_structure.Item;
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
public class InventoryFrame extends javax.swing.JFrame {
    
    private Double limit;
    
    /**
     * Sets the weight limit of the inventory.
     * @param strengthAttr Strength (not modifier but strength total)
     */
    public void setLimit(int strength){
        int mult = (15*strength);
        lbl_carr_num.setText(Integer.toString(mult));
        limit = (double) mult;
    }

    private void setEncumbered(encumbered encumbered) {
        switch(encumbered){
            case ENCUMBERED:
                 icon_status.setIcon(new ImageIcon(getClass().getResource(ICON_STATUS.IMG_ICON_STATUS_RED)));
                 break;
            case SEMI_ENCUMBERED:
                icon_status.setIcon(new ImageIcon(getClass().getResource(ICON_STATUS.IMG_ICON_STATUS_YELLOW)));
                break;
            case STABLE:
                icon_status.setIcon(new ImageIcon(getClass().getResource(ICON_STATUS.IMG_ICON_STATUS_GREEN)));
                break;
        }
    }

    private Item item(int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String name = (String) model.getValueAt(row, 0);
        String desc = (String) model.getValueAt(row, 1);
        Integer quantity = (Integer) model.getValueAt(row, 2);
        Double weight = (Double) model.getValueAt(row, 3);
        
        String qString = quantity==null?null:quantity.toString();
        String wString = weight==null?null:weight.toString();
        
        Item item = new Item(name, desc, qString, wString);
        return item;
    }

    void updateInventory(Inventory inventory) {
        if(inventory == null)
            return;
        for(int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String name = item.name;
            String desc = item.desc;
            String quantityStr = item.quantity;
            String weightStr = item.weight;
            Double weight = (weightStr==null||weightStr.equals(""))?null:Double.parseDouble(weightStr);
            Integer quantity = (quantityStr==null||quantityStr.equals(""))?null:Integer.parseInt(quantityStr);
            
            model.insertRow(i, new Object[] {name, desc, quantity, weight});
        }
    }

    void stopEditingTables() {
        SwingHelper.stopEdit(table);
    }
    
    private enum encumbered{
        ENCUMBERED, SEMI_ENCUMBERED, STABLE;
    }
    
    /**
     * Creates new form InventoryFrame
     */
    public InventoryFrame() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addTableModelListener((TableModelEvent e) -> {
            checkWeight(calculateWeightTotal());
        });
        try {
            File f = new File(getClass().getResource("/img/ico_bag.png").getPath());
            if(f != null){
                BufferedImage img = ImageIO.read(f);
                setIconImage(img);
            }
        } catch (IOException ex) {
            Logger.getLogger(CharacterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Double calculateWeightTotal(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Double sum = 0.0;
        for(int row = 0; row < model.getRowCount(); row++){
            Object quantity = model.getValueAt(row, 2);
            Object weight = model.getValueAt(row, 3);
            if(weight != null && quantity != null){
                int q = ((Integer) quantity).intValue();
                double w = ((Double) weight).doubleValue();
                if(q < 0)
                    model.setValueAt(new Integer(-q), row, 2);
                if(w < 0)
                    model.setValueAt(new Double(-w), row, 3);
                sum += ((double) q) * w;
            }
        }
        return sum;
    }
    
    private void checkWeight(Double total){
        if(limit < total){
            setEncumbered(encumbered.ENCUMBERED);
        }
        else if (Math.round(limit) == Math.round(total)){
            setEncumbered(encumbered.SEMI_ENCUMBERED);
        }
        else{
            setEncumbered(encumbered.STABLE);
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_add_row = new javax.swing.JButton();
        btn_remove_selected_row = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_max_weight = new javax.swing.JLabel();
        lbl_carr_num = new javax.swing.JLabel();
        icon_status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel2.setText("jLabel1");

        setTitle("Inventory");

        jPanel1.setLayout(new java.awt.BorderLayout());

        btn_add_row.setText("Add Item");
        btn_add_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_rowActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add_row);

        btn_remove_selected_row.setText("Remove Selected");
        btn_remove_selected_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_selected_rowActionPerformed(evt);
            }
        });
        jPanel2.add(btn_remove_selected_row);

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        lbl_max_weight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_max_weight.setText("Carrying Capacity");
        jPanel3.add(lbl_max_weight);

        lbl_carr_num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_carr_num.setText("100");
        jPanel3.add(lbl_carr_num);

        icon_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_status_green.png"))); // NOI18N
        jPanel3.add(icon_status);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Quantity", "Weight (kg)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_rowActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[] {null,null,null,null});
        table.setRowSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
    }//GEN-LAST:event_btn_add_rowActionPerformed

    private void btn_remove_selected_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_selected_rowActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int index = table.getSelectedRow();
        if(index > -1){
            model.removeRow(index);
            if(model.getRowCount() > 0){
                if(index == 0){
                    index = 1;
                }
                table.setRowSelectionInterval(index-1, index-1);
            }
            
        }
        else if (index == -1){
            JOptionPane.showMessageDialog(rootPane, "Please select a row to delete");
        }
    }//GEN-LAST:event_btn_remove_selected_rowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_row;
    private javax.swing.JButton btn_remove_selected_row;
    private javax.swing.JLabel icon_status;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_carr_num;
    private javax.swing.JLabel lbl_max_weight;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public Inventory getInventory(){
        Inventory inventory = new Inventory();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int row = 0; row < model.getRowCount(); row++){
            inventory.store(item(row));
        }
        return inventory;
    }
    
}

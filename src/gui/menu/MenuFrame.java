/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.menu;

import app.AppManager;
import app.Support;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import app.Bundle;

/**
 *
 * @author Kendrick-Laptop
 */
public class MenuFrame extends javax.swing.JFrame {

    private final AppManager manager;

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
        initComponents();
        manager = AppManager.getInstance();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        action_sheet = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        action_builder = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        action_open = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        action_support = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adventure5E");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel5.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpg"))); // NOI18N
        jPanel5.add(jLabel2);
        jLabel2.setBounds(50, 0, 100, 100);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));
        jPanel7.setLayout(new java.awt.BorderLayout());

        action_sheet.setForeground(new java.awt.Color(255, 255, 255));
        action_sheet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        action_sheet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paper.png"))); // NOI18N
        action_sheet.setText("Create Character Sheet...");
        action_sheet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        action_sheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_sheetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                action_sheetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                action_sheetMouseExited(evt);
            }
        });
        jPanel7.add(action_sheet, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setLayout(new java.awt.BorderLayout());

        action_builder.setForeground(new java.awt.Color(255, 255, 255));
        action_builder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        action_builder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hammer.png"))); // NOI18N
        action_builder.setText("Create using Builder...");
        action_builder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        action_builder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_builderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                action_builderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                action_builderMouseExited(evt);
            }
        });
        jPanel8.add(action_builder, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 51, 102));
        jPanel9.setLayout(new java.awt.BorderLayout());

        action_open.setForeground(new java.awt.Color(255, 255, 255));
        action_open.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        action_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder.png"))); // NOI18N
        action_open.setText("Open a Character Sheet...");
        action_open.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        action_open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_openMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                action_openMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                action_openMouseExited(evt);
            }
        });
        jPanel9.add(action_open, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 51, 102));
        jPanel10.setLayout(new java.awt.BorderLayout());

        action_support.setForeground(new java.awt.Color(255, 255, 255));
        action_support.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        action_support.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/support.png"))); // NOI18N
        action_support.setText("Support...");
        action_support.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        action_support.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action_supportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                action_supportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                action_supportMouseExited(evt);
            }
        });
        jPanel10.add(action_support, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(0, 51, 102));
        jPanel11.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(0, 51, 102));
        jPanel12.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(0, 51, 102));
        jPanel13.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(0, 51, 102));
        jPanel14.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jPanel14);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void action_sheetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_sheetMouseClicked
        Bundle b = new Bundle();
        manager.startUpCharacterFrame(b);
    }//GEN-LAST:event_action_sheetMouseClicked

    private void action_sheetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_sheetMouseEntered
        action_sheet.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_action_sheetMouseEntered

    private void action_sheetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_sheetMouseExited
        action_sheet.setBorder(null);    
    }//GEN-LAST:event_action_sheetMouseExited

    private void action_builderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_builderMouseExited
        action_builder.setBorder(null);
    }//GEN-LAST:event_action_builderMouseExited

    private void action_builderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_builderMouseEntered
        action_builder.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_action_builderMouseEntered

    private void action_openMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_openMouseEntered
        action_open.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_action_openMouseEntered

    private void action_openMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_openMouseExited
        action_open.setBorder(null);
    }//GEN-LAST:event_action_openMouseExited

    private void action_supportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_supportMouseEntered
        action_support.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_action_supportMouseEntered

    private void action_supportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_supportMouseExited
        action_support.setBorder(null);
    }//GEN-LAST:event_action_supportMouseExited

    private void action_builderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_builderMouseClicked
        manager.startUpBuilderFrame();
    }//GEN-LAST:event_action_builderMouseClicked

    private void action_openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_openMouseClicked
        try {
            File f = manager.getFileToOpen();
            if(f != null){
                manager.startUpCharacterFrame(f);
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_action_openMouseClicked

    private void action_supportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_action_supportMouseClicked
        JLabel label = new JLabel(Support.getContactInformation());
        JOptionPane.showMessageDialog(action_open, label);
    }//GEN-LAST:event_action_supportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel action_builder;
    private javax.swing.JLabel action_open;
    private javax.swing.JLabel action_sheet;
    private javax.swing.JLabel action_support;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}

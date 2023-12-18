/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.ino.gui.dialog.au;

import com.aldrin.ino.dao.UnitDAO;
import com.aldrin.ino.model.Category;
import com.aldrin.ino.model.Unit;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogAUUnit extends javax.swing.JDialog {

    /**
     * Creates new form JDialogAUUser
     */
    private UnitDAO categoryDAO = new UnitDAO();
    private Unit unit = new Unit();
    static String title = "";
    private com.aldrin.ino.gui.JFrameInoPOS mainForm;

    public JDialogAUUnit(com.aldrin.ino.gui.JFrameInoPOS parent, boolean modal, String title) {
        super(parent, modal);
        this.mainForm = parent;
        initComponents();
        this.title = title;
        this.setTitle(title);
        jButton1.setText("Save");
    }

    public JDialogAUUnit(com.aldrin.ino.gui.JFrameInoPOS parent, boolean modal, String title, Unit u) {
        super(parent, modal);
        initComponents();
        this.mainForm = parent;
        jButton1.setText("Update");
        this.unit = u;
        this.title = title;
        this.setTitle(title);
        jTextFieldUnit.setText(u.getUnit());
        jTextAreaDescription.setText(u.getDescription());
        jButton1.setEnabled(false);
    }

    public JDialogAUUnit(com.aldrin.ino.gui.JFrameInoPOS parent, boolean modal, Unit u, String title) {
        super(parent, modal);
        initComponents();
        this.mainForm = parent;
        jButton1.setText("Delete");
        this.unit = u;
        this.title = title;
        this.setTitle(title);
        jTextFieldUnit.setText(u.getUnit());
        jTextAreaDescription.setText(u.getDescription());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextFieldUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 276, 30));

        jTextFieldUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUnitKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, 280, 30));

        jLabel5.setText("Unit");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 20, 270, 20));

        jLabel6.setText("Description");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 280, 20));

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaDescriptionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, 280, 110));

        setSize(new java.awt.Dimension(345, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (title.equals("New")) {
            try {
                int response = JOptionPane.showConfirmDialog(mainForm, "Are you sure to add a user?", "Add new user", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    this.unit.setId(null);
                    this.unit.setUnit(jTextFieldUnit.getText());
                    this.unit.setDescription(jTextAreaDescription.getText());
                    Unit u = categoryDAO.saveUnit(unit);
                    JOptionPane.showMessageDialog(rootPane, "The addition of a new user is successfully recorded.");
                    this.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (title.equals("Update")) {
            try {
                int response = JOptionPane.showConfirmDialog(mainForm, "Are you sure to update a user?", "Update user", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    this.unit.setId(unit.getId());
                    this.unit.setUnit(jTextFieldUnit.getText());
                    this.unit.setDescription(jTextAreaDescription.getText());
                    Unit u = categoryDAO.saveUnit(unit);
                    JOptionPane.showMessageDialog(rootPane, "The updating of a new user is successfully recorded.");
                    this.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (title.equals("Delete")) {
            try {
                int response = JOptionPane.showConfirmDialog(mainForm, "Are you sure to delete a user?", "Delete user", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    categoryDAO.delete(unit.getId());
                    JOptionPane.showMessageDialog(rootPane, "Deletion of user is successfully recorded!");
                    this.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUnitKeyReleased
        unitIsUpdated();
    }//GEN-LAST:event_jTextFieldUnitKeyReleased

    private void jTextAreaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescriptionKeyReleased
        unitIsUpdated();
    }//GEN-LAST:event_jTextAreaDescriptionKeyReleased

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JDialogAUUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JDialogAUUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JDialogAUUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JDialogAUUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JDialogAUUser dialog = new JDialogAUUser(new com.aldrin.ino.view.JFrameInoPOS(unit), true, title);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldUnit;
    // End of variables declaration//GEN-END:variables
 private void unitIsUpdated() {
        Unit u = new Unit(unit.getId(), jTextFieldUnit.getText(), jTextAreaDescription.getText());
        if (this.unit.toString().equals(u.toString())) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }

}
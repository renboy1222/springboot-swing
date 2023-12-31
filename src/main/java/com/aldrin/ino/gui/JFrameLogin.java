/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aldrin.ino.gui;

import com.aldrin.ino.dao.UserDAO;
import com.aldrin.ino.model.User;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author ALDRIN B. C.
 */
public class JFrameLogin extends javax.swing.JFrame {

    private UserDAO userDAO = new UserDAO();
    private User user = new User();

    /**
     * Creates new form JFrameLogin
     */
    public JFrameLogin() {
        initComponents();
        jPasswordFieldX1.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true;" + "showCapsLock:true");
        jLabelTitle.putClientProperty(FlatClientProperties.STYLE, "font:$h1.font");

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
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jTextFieldX1 = new com.aldrin.ino.util.JTextFieldX();
        jPasswordFieldX1 = new com.aldrin.ino.util.JPasswordFieldX();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelErrorMessage = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Login");
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 360, 40));

        jButtonLogin.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 360, 30));

        jTextFieldX1.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jTextFieldX1.setPlaceHolder("Username");
        jPanel1.add(jTextFieldX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 360, 30));

        jPasswordFieldX1.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jPasswordFieldX1.setPlaceHolder("Password");
        jPasswordFieldX1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldX1KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordFieldX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 360, 30));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Password");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 330, 30));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Log-in with Username");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 330, 30));

        jLabelErrorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelErrorMessage.setForeground(new java.awt.Color(153, 0, 0));
        jLabelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 46, 380, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        setSize(new java.awt.Dimension(420, 344));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        User user = userDAO.loginUser(jTextFieldX1.getText(), jPasswordFieldX1.getText());
        if (user != null) {
            this.dispose();
            JFrameInoPOS inoPOS = new JFrameInoPOS(user);
            inoPOS.setVisible(true);
        } else {
            jLabelErrorMessage.setText("Please check your password and username and try again.");
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordFieldX1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldX1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            User user = userDAO.loginUser(jTextFieldX1.getText(), jPasswordFieldX1.getText());
            if (user != null) {
                this.dispose();
                JFrameInoPOS inoPOS = new JFrameInoPOS(user);
                inoPOS.setVisible(true);
            } else {
                jLabelErrorMessage.setText("Please check your password and username and try again.");
            }
        }
    }//GEN-LAST:event_jPasswordFieldX1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        System.setProperty("flatlaf.menuBarEmbedded", "false");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameLogin f = new JFrameLogin();
                f.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private com.aldrin.ino.util.JPasswordFieldX jPasswordFieldX1;
    private com.aldrin.ino.util.JTextFieldX jTextFieldX1;
    // End of variables declaration//GEN-END:variables
}

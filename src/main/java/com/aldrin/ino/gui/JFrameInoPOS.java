/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aldrin.ino.gui;

import com.aldrin.ino.dao.UserDAO;
import com.aldrin.ino.gui.dialog.JDialogCategory;
import com.aldrin.ino.gui.dialog.JDialogUnit;
import com.aldrin.ino.gui.dialog.JDialogUser;
import com.aldrin.ino.gui.dialog.au.JDialogAUUser;
import com.aldrin.ino.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ALDRIN B. C.
 */
public class JFrameInoPOS extends javax.swing.JFrame implements MouseListener {

    /**
     * Creates new form JFrameInoPOS
     */
    Font fontSize10 = UIManager.getFont("medium.font");
    Font fontSize12 = UIManager.getFont("defaultFont");
    Font fontSize14 = UIManager.getFont("large.font");
    Font fontSize16 = UIManager.getFont("h3.regular.font");
    Font fontSize18 = UIManager.getFont("h2.regular.font");
    Font fontSize20 = UIManager.getFont("h1.regular.font");
    JLayeredPane layeredPane = new JLayeredPane();
    JPanel contentPanel = new JPanel();
    private static User user;

    private UserDAO userDAO;

    public JFrameInoPOS(User u) {
        initComponents();
        this.userDAO = new UserDAO();
        this.user = new User();
        setTable();
        selectUsers();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldX1 = new com.aldrin.ino.util.JTextFieldX();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD (SPRING BOOT, SWING)");

        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUser);

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.setMargin(new java.awt.Insets(2, 3, 3, 3));
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(87, 23));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setMargin(new java.awt.Insets(2, 3, 3, 3));
        jButtonDelete.setPreferredSize(new java.awt.Dimension(87, 23));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTextFieldX1.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        jTextFieldX1.setPlaceHolder("Search");
        jTextFieldX1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldX1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldX1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263)
                        .addComponent(jTextFieldX1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldX1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Settings");

        jMenuItem1.setText("User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Category");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem17.setText("Unit");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(933, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDialogUser user = new JDialogUser(this, true);
        user.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JDialogCategory category = new JDialogCategory(this, true);
        category.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        JDialogUnit unit = new JDialogUnit(this, true);
        unit.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        int row = jTableUser.getSelectedRow();
        Long id = Long.parseLong(jTableUser.getModel().getValueAt(row, 0).toString());
        String firstnamel = jTableUser.getModel().getValueAt(row, 1).toString();
        String lastnamel = jTableUser.getModel().getValueAt(row, 2).toString();

        String usernamel = jTableUser.getModel().getValueAt(row, 3) == null ? "" : jTableUser.getModel().getValueAt(row, 3).toString();
        String passwordl = jTableUser.getModel().getValueAt(row, 4) == null ? "" : jTableUser.getModel().getValueAt(row, 4).toString();
        this.user.setId(id);
        this.user.setFirstname(firstnamel);
        this.user.setLastname(lastnamel);
        this.user.setUsername(usernamel);
        this.user.setPassword(passwordl);
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String title = "New";
        JDialogAUUser auUser = new JDialogAUUser(this, true, title);
        auUser.setVisible(true);
        selectUsers();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        String title = "Update";
        JDialogAUUser auUser = new JDialogAUUser(this, true, title, user);
        auUser.setVisible(true);
        selectUsers();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        String title = "Delete";
        JDialogAUUser auUser = new JDialogAUUser(this, true, user, title);
        auUser.setVisible(true);
        selectUsers();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldX1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldX1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldX1KeyPressed

    private void jTextFieldX1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldX1KeyReleased
//        String text = jTextFieldX1.getText().trim();
//        if (text.length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ",*"));
//        }
    }//GEN-LAST:event_jTextFieldX1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameInoPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameInoPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameInoPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameInoPOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SwingUtilities.invokeLater(() -> {
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new JFrameInoPOS(user).setVisible(true);
                }
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUser;
    private com.aldrin.ino.util.JTextFieldX jTextFieldX1;
    // End of variables declaration//GEN-END:variables
   private ArrayList<User> userList;
    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"ID", "FIRSTNAME", "LASTNAME", "USERNAME", "PASSWORD"}, 0) {
        public Class getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 11:
                    return Boolean.class;
                default:
                    return Object.class;
            }

        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    private void setTable() {
        try {
            jTableUser.setCellSelectionEnabled(true);
            jTableUser = new JTable(tableModel);
            JTableHeader header = jTableUser.getTableHeader();
            header.setFont(new Font("Courier New", Font.BOLD, 14));
            header.setForeground(new Color(102, 102, 102));
            header.setPreferredSize(new Dimension(100, 35));
            jTableUser.setRowHeight(30);
            jTableUser.setRowSorter(sorter);
            jTableUser.addMouseListener(this);

            // Create a JTable with the model
//            JTable table = new JTable(model);
            jTableUser.setFont(new Font("Courier New", Font.PLAIN, 14));

//            JButton edit = new JButton(new FlatSVGIcon("svg/edit.svg"));
//            edit.setName("UPDATE");
//            jTableUser.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
//            jTableUser.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(edit));
//
//            JButton delete = new JButton(new FlatSVGIcon("svg/delete.svg"));
//            delete.setName("DELETE");
//            jTableUser.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
//            jTableUser.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(delete));
//
            jScrollPane1.setViewportView(jTableUser);

            TableColumn[] column = new TableColumn[100];

            column[0] = jTableUser.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(40);

            column[1] = jTableUser.getColumnModel().getColumn(1);
            column[1].setPreferredWidth(150);
//            column[1] = jTableUser.getColumnModel().getColumn(5);
//            column[1].setPreferredWidth(30);
//            column[1] = jTableUser.getColumnModel().getColumn(6);
//            column[1].setPreferredWidth(30);

            TableColumn hidden1 = jTableUser.getColumnModel().getColumn(0);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
//            TableColumn hidden2 = jTableUser.getColumnModel().getColumn(2);
//            hidden2.setMinWidth(0);
//            hidden2.setPreferredWidth(0);
//            hidden2.setMaxWidth(0);
//            TableColumn hidden3 = jTableUser.getColumnModel().getColumn(3);
//            hidden3.setMinWidth(0);
//            hidden3.setPreferredWidth(0);
//            hidden3.setMaxWidth(0);
//            TableColumn hidden4 = jTableUser.getColumnModel().getColumn(4);
//            hidden4.setMinWidth(0);
//            hidden4.setPreferredWidth(0);
//            hidden4.setMaxWidth(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTableUser) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    int row = jTableUser.getSelectedRow();
                    jButtonUpdate.setEnabled(true);
                    jButtonDelete.setEnabled(true);
                    if (row != -1) {
                        Long idl = Long.parseLong(jTableUser.getValueAt(row, 0).toString());
                        String firstnamel = jTableUser.getValueAt(row, 1).toString();
                        String lastnamel = jTableUser.getValueAt(row, 2).toString();
                        String usernamel = jTableUser.getValueAt(row, 3).toString();
                        String passwordl = jTableUser.getValueAt(row, 4).toString();
                        User u = new User(idl, firstnamel, lastnamel, usernamel, passwordl);
                        this.user = u;
//                        user.setId(Long.parseLong(idl.toString()));
//                        user.setFirstname(firstnamel.toString());
//                        user.setLastname(lastnamel.toString());
//                        user.setUsername(usernamel.toString());
//                        user.setPassword(passwordl.toString());

                    }
                }
            }

        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private void selectUsers() {
        List<User> list = userDAO.listOfUser();
        tableModel.setRowCount(0);
        list.forEach(pr -> {
            tableModel.addRow(new Object[]{
                pr.getId(),
                pr.getFirstname(),
                pr.getLastname(),
                pr.getUsername(),
                pr.getPassword()
            });
        });
    }

// Custom cell renderer for buttons
    class ButtonRenderer extends DefaultTableCellRenderer {

        private JButton button = new JButton();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            button.setText((value == null) ? "" : value.toString());
            return button;
        }
    }

// Custom cell editor for buttons
    class ButtonEditor extends DefaultCellEditor {

        private JButton button;

        public ButtonEditor(JButton jButton) {
            super(new JCheckBox());
            this.button = jButton;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    if (button.getText().equals("UPDATE")) {
                        System.out.println("UPDATE!!!");
                    } else if (button.getText().equals("UPDATE")) {
                        System.out.println("DELETE!!!");
                    }
                    // Add your action here
//                System.out.println(button.getIcon().toString());

                    JOptionPane.showMessageDialog(null, button.getText());
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }

            button.setText((value == null) ? "" : value.toString());
            return button;
        }

        public Object getCellEditorValue() {
            return button.getText();
        }
    }

}

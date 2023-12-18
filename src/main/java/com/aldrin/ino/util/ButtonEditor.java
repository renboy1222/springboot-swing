/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.util;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALDRIN B. C.
 */
    public class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private DefaultTableModel model;
        private int rowIndex;
        private JTable t;

        public ButtonEditor(DefaultTableModel model) {
            super(new JCheckBox());
            button = new JButton();
            button.setOpaque(true);
            this.model = model;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
//                    // Remove the row from the table
//                    if(button.getText().equals("Edit")){
//                         System.out.println("edit:");
//                    }if(button.getText().equals("Remove")){
//                         System.out.println("remove:");
//                    }
                    System.out.println("row:"+t.getValueAt(rowIndex, 0));
                    model.removeRow(rowIndex);
                    
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            rowIndex = row;
            t=table;

            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            // Set the button text
            button.setText(value == null ? "" : value.toString());

            return button;
        }
    }

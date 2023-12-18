/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.util;



import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ALDRIN B. C.
 */
public class ButtonRenderer extends DefaultTableCellRenderer {
//        private JButton button = new JButton(new FlatSVGIcon("svg/pos.svg"));

    private JButton button;

    public ButtonRenderer(JButton jButton) {
        jButton.setOpaque(false);
        jButton.setPreferredSize(new Dimension(30, 30));
        this.button = jButton;
//        System.out.println("button:"+jButton.getName());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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

package com.aldrin.ino.util;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author ALDRIN B. C.
 */
public class JPasswordFieldX extends JPasswordField {


    private String placeHolder = "Place Holder";
    private boolean showPlaceHolder;
    private Icon leftIcon;
    private Icon rightIcon;

    //JComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
    }
    //Component --> Container --> JCommponent

//  paint methods  Invoked by Swing to draw components.
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            Insets ins = getInsets();

            FontMetrics fm = g.getFontMetrics();
            int bg = getBackground().getRGB();
            int fg = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((bg & m) >>> 1) + ((fg & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(getPlaceHolder(), ins.left, h / 2 + fm.getAscent() / 2 - 2);

        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (getLeftIcon() != null) {
            Image prefix = ((ImageIcon) getLeftIcon()).getImage();
            int y = (getHeight() - getLeftIcon().getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
        if (getRightIcon() != null) {
            Image suffix = ((ImageIcon) getRightIcon()).getImage();
            int y = (getHeight() - getRightIcon().getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - getRightIcon().getIconWidth() - 3, y, this);
        }
    }
    /**
     * @return the placeHolder
     */
    public String getPlaceHolder() {
        return placeHolder;
    }

    /**
     * @param placeHolder the placeHolder to set
     */
    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    /**
     * @return the showPlaceHolder
     */
    public boolean isShowPlaceHolder() {
        return showPlaceHolder;
    }

    /**
     * @param showPlaceHolder the showPlaceHolder to set
     */
    public void setShowPlaceHolder(boolean showPlaceHolder) {
        this.showPlaceHolder = showPlaceHolder;
    }

    /**
     * @return the leftIcon
     */
    public Icon getLeftIcon() {
        return leftIcon;
    }

    /**
     * @param leftIcon the leftIcon to set
     */
    public void setLeftIcon(Icon leftIcon) {
        this.leftIcon = leftIcon;
    }

    /**
     * @return the rightIcon
     */
    public Icon getRightIcon() {
        return rightIcon;
    }

    /**
     * @param rightIcon the rightIcon to set
     */
    public void setRightIcon(Icon rightIcon) {
        this.rightIcon = rightIcon;
    }
}

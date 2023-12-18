/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.util;

import com.formdev.flatlaf.ui.FlatDropShadowBorder;
import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author ALDRIN B. C.
 */

class HintManager {
  private static final List<HintPanel> hintPanels = new ArrayList<>();
  
  static void showHint(Hint hint) {
//    if (DemoPrefs.getState().getBoolean(hint.prefsKey, false)) {
//      if (hint.nextHint != null)
//        showHint(hint.nextHint); 
//      return;
//    } 
    HintPanel hintPanel = new HintPanel(hint);
    hintPanel.showHint();
    hintPanels.add(hintPanel);
  }
  
  static void hideAllHints() {
    HintPanel[] hintPanels2 = hintPanels.<HintPanel>toArray(new HintPanel[hintPanels.size()]);
    for (HintPanel hintPanel : hintPanels2)
      hintPanel.hideHint(); 
  }
  
  static class Hint {
    private final String message;
    
    private final Component owner;
    
    private final int position;
    
    private final String prefsKey;
    
    private final Hint nextHint;
    
    Hint(String message, Component owner, int position, String prefsKey, Hint nextHint) {
      this.message = message;
      this.owner = owner;
      this.position = position;
      this.prefsKey = prefsKey;
      this.nextHint = nextHint;
    }
  }
  
  private static class HintPanel extends JPanel {
    private final HintManager.Hint hint;
    
    private JPanel popup;
    
    private JLabel hintLabel;
    
    private JButton gotItButton;
    
    private HintPanel(HintManager.Hint hint) {
      this.hint = hint;
      initComponents();
      setOpaque(false);
      updateBalloonBorder();
      this.hintLabel.setText("<html>" + hint.message + "</html>");
      addMouseListener(new MouseAdapter() {
          
          });
    }
    
    public void updateUI() {
      super.updateUI();
      if (UIManager.getLookAndFeel() instanceof com.formdev.flatlaf.FlatLaf) {
        setBackground(UIManager.getColor("HintPanel.backgroundColor"));
      } else {
        setBackground(FlatUIUtils.nonUIResource(UIManager.getColor("info")));
      } 
      if (this.hint != null)
        updateBalloonBorder(); 
    }
    
    private void updateBalloonBorder() {
      int direction;
      switch (this.hint.position) {
        case 2:
          direction = 4;
          break;
        case 1:
          direction = 3;
          break;
        case 4:
          direction = 2;
          break;
        case 3:
          direction = 1;
          break;
        default:
          throw new IllegalArgumentException();
      } 
      setBorder((Border)new HintManager.BalloonBorder(direction, FlatUIUtils.getUIColor("PopupMenu.borderColor", Color.gray)));
    }
    
    void showHint() {
      JRootPane rootPane = SwingUtilities.getRootPane(this.hint.owner);
      if (rootPane == null)
        return; 
      JLayeredPane layeredPane = rootPane.getLayeredPane();
      this.popup = new JPanel(new BorderLayout()) {
          public void updateUI() {
            super.updateUI();
            EventQueue.invokeLater(() -> {
                  validate();
                  setSize(getPreferredSize());
                });
          }
        };
      this.popup.setOpaque(false);
      this.popup.add(this);
      Point pt = SwingUtilities.convertPoint(this.hint.owner, 0, 0, layeredPane);
      int x = pt.x;
      int y = pt.y;
      Dimension size = this.popup.getPreferredSize();
      int gap = UIScale.scale(6);
      switch (this.hint.position) {
        case 2:
          x -= size.width + gap;
          break;
        case 1:
          y -= size.height + gap;
          break;
        case 4:
          x += this.hint.owner.getWidth() + gap;
          break;
        case 3:
          y += this.hint.owner.getHeight() + gap;
          break;
      } 
      this.popup.setBounds(x, y, size.width, size.height);
      layeredPane.add(this.popup, JLayeredPane.POPUP_LAYER);
    }
    
    void hideHint() {
      if (this.popup != null) {
        Container parent = this.popup.getParent();
        if (parent != null) {
          parent.remove(this.popup);
          parent.repaint(this.popup.getX(), this.popup.getY(), this.popup.getWidth(), this.popup.getHeight());
        } 
      } 
      HintManager.hintPanels.remove(this);
    }
    
    private void gotIt() {
      hideHint();
//      DemoPrefs.getState().putBoolean(this.hint.prefsKey, true);
      if (this.hint.nextHint != null)
        HintManager.showHint(this.hint.nextHint); 
    }
    
    private void initComponents() {
      this.hintLabel = new JLabel();
      this.gotItButton = new JButton();
//      setLayout((LayoutManager)new MigLayout("insets dialog,hidemode 3", "[::200,fill]", "[]para[]"));
      this.hintLabel.setText("hint");
      add(this.hintLabel, "cell 0 0");
      this.gotItButton.setText("Got it!");
      this.gotItButton.setFocusable(false);
      this.gotItButton.addActionListener(e -> gotIt());
      add(this.gotItButton, "cell 0 1,alignx right,growx 0");
    }
  }
  
  private static class BalloonBorder extends FlatEmptyBorder {
    private static int ARC = 8;
    
    private static int ARROW_XY = 16;
    
    private static int ARROW_SIZE = 8;
    
    private static int SHADOW_SIZE = 6;
    
    private static int SHADOW_TOP_SIZE = 3;
    
    private static int SHADOW_SIZE2 = SHADOW_SIZE + 2;
    
    private final int direction;
    
    private final Color borderColor;
    
    private final Border shadowBorder;
    
    public BalloonBorder(int direction, Color borderColor) {
      super(1 + SHADOW_TOP_SIZE, 1 + SHADOW_SIZE, 1 + SHADOW_SIZE, 1 + SHADOW_SIZE);
      this.direction = direction;
      this.borderColor = borderColor;
      switch (direction) {
        case 2:
          this.left += ARROW_SIZE;
          break;
        case 1:
          this.top += ARROW_SIZE;
          break;
        case 4:
          this.right += ARROW_SIZE;
          break;
        case 3:
          this.bottom += ARROW_SIZE;
          break;
      } 
      this
        
        .shadowBorder = (UIManager.getLookAndFeel() instanceof com.formdev.flatlaf.FlatLaf) ? (Border)new FlatDropShadowBorder(UIManager.getColor("Popup.dropShadowColor"), new Insets(SHADOW_SIZE2, SHADOW_SIZE2, SHADOW_SIZE2, SHADOW_SIZE2), FlatUIUtils.getUIFloat("Popup.dropShadowOpacity", 0.5F)) : null;
    }
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D)g.create();
      try {
        FlatUIUtils.setRenderingHints(g2);
        g2.translate(x, y);
        int sx = 0;
        int sy = 0;
        int sw = width;
        int sh = height;
        int arrowSize = UIScale.scale(ARROW_SIZE);
        switch (this.direction) {
          case 2:
            sx += arrowSize;
            sw -= arrowSize;
            break;
          case 1:
            sy += arrowSize;
            sh -= arrowSize;
            break;
          case 4:
            sw -= arrowSize;
            break;
          case 3:
            sh -= arrowSize;
            break;
        } 
        if (this.shadowBorder != null)
          this.shadowBorder.paintBorder(c, g2, sx, sy, sw, sh); 
        int bx = UIScale.scale(SHADOW_SIZE);
        int by = UIScale.scale(SHADOW_TOP_SIZE);
        int bw = width - UIScale.scale(SHADOW_SIZE + SHADOW_SIZE);
        int bh = height - UIScale.scale(SHADOW_TOP_SIZE + SHADOW_SIZE);
        g2.translate(bx, by);
        Shape shape = createBalloonShape(bw, bh);
        g2.setColor(c.getBackground());
        g2.fill(shape);
        g2.setColor(this.borderColor);
        g2.setStroke(new BasicStroke(UIScale.scale(1.0F)));
        g2.draw(shape);
      } finally {
        g2.dispose();
      } 
    }
    
    private Shape createBalloonShape(int width, int height) {
      Shape rect, arrow;
      Area area, area2;
      int i;
      Area area1;
      int y, arc = UIScale.scale(ARC);
      int xy = UIScale.scale(ARROW_XY);
      int awh = UIScale.scale(ARROW_SIZE);
      switch (this.direction) {
        case 2:
          rect = new RoundRectangle2D.Float(awh, 0.0F, (width - 1 - awh), (height - 1), arc, arc);
          arrow = FlatUIUtils.createPath(new double[] { awh, xy, 0.0D, (xy + awh), awh, (xy + awh + awh) });
          area = new Area(rect);
          area.add(new Area(arrow));
          return area;
        case 1:
          rect = new RoundRectangle2D.Float(0.0F, awh, (width - 1), (height - 1 - awh), arc, arc);
          arrow = FlatUIUtils.createPath(new double[] { xy, awh, (xy + awh), 0.0D, (xy + awh + awh), awh });
          area2 = new Area(rect);
          area2.add(new Area(arrow));
          return area2;
        case 4:
          rect = new RoundRectangle2D.Float(0.0F, 0.0F, (width - 1 - awh), (height - 1), arc, arc);
          i = width - 1 - awh;
          arrow = FlatUIUtils.createPath(new double[] { i, xy, (i + awh), (xy + awh), i, (xy + awh + awh) });
          area1 = new Area(rect);
          area1.add(new Area(arrow));
          return area1;
        case 3:
          rect = new RoundRectangle2D.Float(0.0F, 0.0F, (width - 1), (height - 1 - awh), arc, arc);
          y = height - 1 - awh;
          arrow = FlatUIUtils.createPath(new double[] { xy, y, (xy + awh), (y + awh), (xy + awh + awh), y });
          area1 = new Area(rect);
          area1.add(new Area(arrow));
          return area1;
      } 
      throw new RuntimeException();
    }
  }
}

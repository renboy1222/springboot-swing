package com.aldrin.ino;

import com.aldrin.ino.gui.JFrameLogin;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringswingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringswingApplication.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

    }

    @Override
    public void run(String... args) throws Exception {

        FlatLightLaf.setup();

        System.setProperty("flatlaf.menuBarEmbedded", "false");
        UIManager.put("JFrame.arc", 0);
        UIManager.put("Button.arc",10);
        UIManager.put("Label.arc", 0);
        UIManager.put("Component.arc", 0);
        UIManager.put("ProgressBar.arc", 0);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("TabbedPane.tabSeparatorsFullHeight", true);
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        FlatSVGIcon svgIcon = new FlatSVGIcon("svg/pos.svg");
        
        JFrameLogin.main(args);

    }

}
